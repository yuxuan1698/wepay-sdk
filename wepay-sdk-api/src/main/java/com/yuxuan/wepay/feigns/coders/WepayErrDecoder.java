package com.yuxuan.wepay.feigns.coders;

import com.yuxuan.wepay.utils.StreamUtil;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

/**
 * @author yuxuan
 * @date 2019/6/12
 */
public class WepayErrDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String resp = StreamUtil.inputStreamToString(response.body().asInputStream());
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return FeignException.errorStatus(methodKey, response);
    }
}
