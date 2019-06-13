package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 转换短链接响应
 *
 * @author yuxuan
 * @date 2019/6/13
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShortUrlResult extends MchPayResult{
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     * URL链接	short_url	是	String(64)	weixin：//wxpay/s/XXXXXX	转换后的URL
     */
    private String short_url;
}
