package com.yuxuan.wepay.feigns;

import com.yuxuan.wepay.feigns.annotations.Domain;
import com.yuxuan.wepay.feigns.coders.WepayDecoder;
import com.yuxuan.wepay.feigns.coders.WepayEncoder;
import com.yuxuan.wepay.feigns.coders.WepayErrDecoder;
import com.yuxuan.wepay.utils.SSLContextUtil;
import feign.Client;
import feign.Feign;

import javax.net.ssl.SSLContext;

/**
 * @author yuxuan
 * @date 2019/6/11
 */
public class FeignBuilder {

    /**
     * 获取普通接口http请求api
     *
     * @return
     * @throws Exception
     */
    public static WepayApi builderWepayApi() {
        return Feign.builder()
                .encoder(new WepayEncoder())
                .decoder(new WepayDecoder())
                .errorDecoder(new WepayErrDecoder())
                .target(WepayApi.class, WepayApi.class.getAnnotation(Domain.class).value());
    }

    /**
     * 获取退款接口https请求api
     *
     * @param cert
     * @param password
     * @return
     * @throws Exception
     */
    public static WepayApi buildWepaySslApi(byte[] cert, String password) throws Exception {
        SSLContext ctx = SSLContextUtil.getSSLContext(cert, password);
        return Feign.builder()
                .client(new Client.Default(ctx.getSocketFactory(), (s, sslSession) -> true))
                .encoder(new WepayEncoder())
                .decoder(new WepayDecoder())
                .errorDecoder(new WepayErrDecoder())
                .target(WepayApi.class, WepayApi.class.getAnnotation(Domain.class).value());
    }
}
