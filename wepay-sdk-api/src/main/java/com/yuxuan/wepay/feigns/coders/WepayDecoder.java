package com.yuxuan.wepay.feigns.coders;

import com.yuxuan.wepay.utils.StreamUtil;
import com.yuxuan.wepay.utils.XmlUtil;
import feign.Response;
import feign.codec.Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * @author yuxuan
 * @date 2019/6/10
 */
public class WepayDecoder extends Decoder.Default {

    @Override
    public Object decode(Response response, Type type) throws IOException {
        InputStream ins = response.body().asInputStream();
        String result = StreamUtil.inputStreamToString(ins);
        System.out.println(result);

        try {
            Class<?> clazz = Class.forName(type.getTypeName());
            return XmlUtil.convertToObject(result, clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
