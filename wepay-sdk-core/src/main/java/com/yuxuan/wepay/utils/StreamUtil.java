package com.yuxuan.wepay.utils;

import lombok.experimental.UtilityClass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 流转换工具类
 *
 * @author yuxuan
 * @date 2019/6/12
 */
@UtilityClass
public class StreamUtil {

    /**
     * InputStream 转字符串
     *
     * @param ins
     * @return
     */
    public static String inputStreamToString(InputStream ins) throws IOException {
        try {
            ByteArrayOutputStream baos = toByteArrayOutputStream(ins);
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * InputStream 转字节
     *
     * @param ins
     * @return
     * @throws IOException
     */
    public static byte[] inputStreamToBytes(InputStream ins) throws IOException {
        try {
            ByteArrayOutputStream baos = toByteArrayOutputStream(ins);

            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * InputStream 转 ByteArrayOutputStream
     *
     * @param ins
     * @return
     * @throws IOException
     */
    private static ByteArrayOutputStream toByteArrayOutputStream(InputStream ins) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int i;
        while ((i = ins.read(buffer)) != -1) {
            baos.write(buffer, 0, i);
        }

        return baos;
    }
}
