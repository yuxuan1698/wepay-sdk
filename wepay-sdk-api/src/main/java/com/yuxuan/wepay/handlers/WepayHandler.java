package com.yuxuan.wepay.handlers;

import com.yuxuan.wepay.constants.WepayConstants;
import com.yuxuan.wepay.models.MchPayResult;
import com.yuxuan.wepay.utils.SignUtil;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付操作类型
 *
 * @author yuxuan
 * @date 2019/6/12
 */
public class WepayHandler {

    /**
     * 小程序支付请求参数
     *
     * @param app_id
     * @param prepay_id
     * @param app_sign_key
     * @return
     */
    public static Map<String, Object> createWepayAppletParams(String app_id, String prepay_id, String app_sign_key){
        // 封装返回参数
        Map<String, Object> params = new HashMap<>();
        // 特别注意 此处签名的appid需要发起方的应用appid 而不是服务商对应的appid
        // 如微信文档提示：微信分配的小程序ID，服务商模式下应为当前调起支付小程序的appid
        params.put("appId", app_id);
        // 和公众号网页支付不同的地方 timeStamp这里是String 公众号是LONG 注意这个坑
        params.put("timeStamp", String.valueOf(System.currentTimeMillis()));
        params.put("nonceStr",  RandomStringUtils.randomAlphabetic(16));
        params.put("package", "prepay_id=" + prepay_id);
        params.put("signType", "MD5");
        // 签名
        String paySign = SignUtil.createMapSign(params, app_sign_key);
        params.put("paySign", paySign);
        params.remove("appId");

        return params;
    }

    /**
     * 公众号支付请求参数
     *
     * @param app_id
     * @param prepay_id
     * @param app_sign_key
     * @return
     */
    public static Map<String, Object> createWepayWechatParams(String app_id, String prepay_id, String app_sign_key){
        // 封装返回参数
        Map<String,Object> signMap = new HashMap<String,Object>();
        // 特别注意 此处签名的appid需要发起方的应用appid 而不是服务商对应的appid
        // 如微信文档提示：微信分配的小程序ID，服务商模式下应为当前调起支付公众号的appid
        signMap.put("appId", app_id);
        //和小程序支付不同的地方 timeStamp这里是LONG 小程序是字符串  注意这个坑
        signMap.put("timeStamp", System.currentTimeMillis());
        signMap.put("nonceStr", RandomStringUtils.randomAlphabetic(16));
        signMap.put("package", "prepay_id=" + prepay_id);
        signMap.put("signType", "MD5");
        //支付参数签名
        String paySign = SignUtil.createMapSign(signMap, app_sign_key);

        //小程序发起支付请求参数是timeStamp 公众号是timestamp 一个字母s大小写之差 注意此坑
        //响应参数
        Map<String,Object> params = new HashMap<>();
        params.put("timestamp", signMap.get("timeStamp"));
        params.put("nonceStr", signMap.get("nonceStr"));
        params.put("package", signMap.get("package"));
        params.put("signType", signMap.get("signType"));
        params.put("paySign", paySign);

        return params;
    }

    /**
     * 接口响应校验
     *
     * @param result
     * @param app_sign_key
     * @param <T>
     * @return
     */
    public static <T> Boolean checkReturnResult(T result, String app_sign_key){
        MchPayResult mchPayResult = (MchPayResult) result;
        System.out.println("return_code：" + mchPayResult.getReturn_code());
        System.out.println("return_msg：" + mchPayResult.getReturn_msg());
        if(WepayConstants.FAIL.equals(mchPayResult.getReturn_code())){
            System.out.println("return fail!");
            return false;
        }
        if(WepayConstants.SUCCESS.equals(mchPayResult.getReturn_code())){
            System.out.println("return success!");
        }

        Boolean checkSign = SignUtil.checkObjectSign(result, app_sign_key, mchPayResult.getSign());
        if (!checkSign) {
            System.out.println("验签失败");
            return Boolean.FALSE;
        } else {
            System.out.println("验签成功");
            if (WepayConstants.FAIL.equals(mchPayResult.getResult_code())) {
                System.out.println(
                        "err_code:" + mchPayResult.getErr_code() + "\n" +
                        "err_code_des:" + mchPayResult.getErr_code_des()
                );
                return Boolean.FALSE;
            } else {
                System.out.println("结束");
                return Boolean.TRUE;
            }
        }
    }
}
