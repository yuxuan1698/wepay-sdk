package com.yuxuan.wepay.utils;

import lombok.experimental.UtilityClass;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * SSL证书初始化类型
 *
 * @author yuxuan
 * @date 2019/6/12
 */
@UtilityClass
public class SSLContextUtil {

    /**
     * 获得SSLSocketFactory.
     *
     * @param keyStorePath 密钥库路径
     * @param password     密码
     * @return SSLSocketFactory
     * @throws Exception
     */
    public static SSLContext getSSLContext(byte[] keyStorePath,
                                           String password) throws Exception {
        // 获得密钥库
        KeyStore keyStore =
                getKeyStore(keyStorePath, password);
        // 实例化密钥库
        KeyManagerFactory kmf =
                KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        // 初始化密钥工厂
        kmf.init(keyStore, password.toCharArray());

        // 实例化SSL上下文
        SSLContext ctx = SSLContext.getInstance("TLS");
        // 初始化SSL上下文
        ctx.init(kmf.getKeyManagers(),
                null, new SecureRandom());
        // 获得SSLSocketFactory
        return ctx;
    }

    /**
     * 获得KeyStore.
     *
     * @param keyStorePath 密钥库路径
     * @param password     密码
     * @return 密钥库
     * @throws Exception
     */
    public static KeyStore getKeyStore(byte[] keyStorePath, String password)
            throws Exception {
        // 实例化密钥库
        KeyStore ks = KeyStore.getInstance("PKCS12");
        // 获得密钥库文件流
        InputStream is = new ByteArrayInputStream(keyStorePath);
        // 加载密钥库
        ks.load(is, password.toCharArray());
        // 关闭密钥库文件流
        is.close();
        return ks;
    }
}
