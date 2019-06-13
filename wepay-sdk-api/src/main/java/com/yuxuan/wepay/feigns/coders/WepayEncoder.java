package com.yuxuan.wepay.feigns.coders;

import com.yuxuan.wepay.utils.XmlUtil;
import feign.RequestTemplate;
import feign.codec.Encoder;

import java.lang.reflect.Type;

/**
 * @author yuxuan
 * @date 2019/6/10
 */
public class WepayEncoder extends Encoder.Default {

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) {
        String requestStr = XmlUtil.convertToXml(object);
        System.out.println(requestStr);

        template.header("Content-Type", "application/xml");
        template.body(requestStr);
    }

}
