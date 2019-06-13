package com.yuxuan.wepay.utils;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 签名工具类
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@UtilityClass
public class SignUtil {

    private static final String ADD_KEY_TEMPLATE = "%s&key=%s";
    private static final String KV_DELIMITER = "=";
    private static final String DELIMITER = "&";

    /**
     * 对象生成签名
     *
     * @param obj 待签名对象
     * @param key 签名key
     * @param <T> 签名对象类型
     * @return 签名结果
     */
    public static <T> String createObjectSign(T obj, String key) {
        String signData = createObjectSignData(obj, KV_DELIMITER, DELIMITER);
        String attachKey = String.format(ADD_KEY_TEMPLATE, signData, key);
        return Objects.requireNonNull(DigestUtil.md5(attachKey)).toUpperCase();
    }

    /**
     * 对象验签
     *
     * @param obj 待验签对象
     * @param key 签名key
     * @param <T> 待验签对象类型
     * @return 验签结果
     */
    public static <T> Boolean checkObjectSign(T obj, String key, String originSign) {
        String signData = createObjectSignData(obj, KV_DELIMITER, DELIMITER);
        String attachKey = String.format(ADD_KEY_TEMPLATE, signData, key);
        String sign = Objects.requireNonNull(DigestUtil.md5(attachKey)).toUpperCase();
        return originSign.equals(sign);
    }

    /**
     * MAP生成签名
     *
     * @param map 待签名MAP
     * @param key 签名key
     * @return 签名结果
     */
    public static String createMapSign(Map<String, Object> map, String key) {
        String signData = createMapSignData(map, KV_DELIMITER, DELIMITER);
        String attachKey = String.format(ADD_KEY_TEMPLATE, signData, key);
        return Objects.requireNonNull(DigestUtil.md5(attachKey)).toUpperCase();
    }

    /**
     * MAP验签
     *
     * @param map 待验签MAP
     * @param key 签名key
     * @return 验签结果
     */
    public static Boolean checkMapSign(Map<String, Object> map, String key, String originSign) {
        String signData = createMapSignData(map, KV_DELIMITER, DELIMITER);
        String attachKey = String.format(ADD_KEY_TEMPLATE, signData, key);
        String sign = Objects.requireNonNull(DigestUtil.md5(attachKey)).toUpperCase();
        return originSign.equals(sign);
    }

    /**
     * 对象拼接签名数据 KEY=VALUE & KEY=VALUE & ...
     *
     * @param obj         签名对象
     * @param kvdelimiter 键值分隔符
     * @param delimiter   字段连接符
     * @param <T>         签名对象类型
     * @return 待签名字符串
     */
    private static <T> String createObjectSignData(T obj, CharSequence kvdelimiter, CharSequence delimiter) {
        //拼接列表
        List<String> properties = new ArrayList<>();
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 如果是验签去掉签名字段
                if ("sign".equals(field.getName())) {
                    continue;
                }
                field.setAccessible(Boolean.TRUE);
                Object value = null;
                try {
                    value = field.get(obj);
                } catch (IllegalAccessException e) {
                    //忽略
                }
                //字段为空不参与加密
                if (value != null) {
                    //拼接 key=value
                    properties.add(field.getName() + kvdelimiter + value);
                }
            }
        }

        //按字段名称ASCII码从小到大排序
        properties.sort(String::compareTo);
        //key=value按分隔符拼接
        return properties.stream().collect(Collectors.joining(delimiter));
    }

    /**
     * MAP拼接签名数据 KEY=VALUE & KEY=VALUE & ...
     *
     * @param params 待签名MAP
     * @return 待签名字符串
     */
    private static String createMapSignData(Map<String, Object> params, CharSequence kvdelimiter, CharSequence delimiter) {
        // treeMap会把数据自动按KEY的ASCII码值排序
        TreeMap<String, Object> sortedParams = new TreeMap<>(params);

        return sortedParams.entrySet().stream().map(entry -> entry.getKey() + kvdelimiter + entry.getValue()).collect(Collectors.joining(delimiter));
    }


}
