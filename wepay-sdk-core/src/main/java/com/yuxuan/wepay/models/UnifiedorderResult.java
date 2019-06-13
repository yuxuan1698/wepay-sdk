package com.yuxuan.wepay.models;

import com.yuxuan.wepay.utils.AdaptorCDATA;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 统一下单接口返回
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedorderResult extends MchPayResult {
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     * 交易类型 是	String(16)	JSAPI	交易类型，取值为：JSAPI，NATIVE，APP等，说明详见参数规定
     */
    private String trade_type;

    /**
     * 预支付交易会话标识    是	String(64)	wx201410272009395522657a690389285100	微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    private String prepay_id;

    /**
     * 二维码链接    否	String(64)	URl：weixin：//wxpay/s/An4baqw	trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
     */
    private String code_url;
}
