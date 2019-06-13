package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 支付异步通知对象
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayNotifyResult extends MchPayResult{
    /**************************************************
     * 字段名  必填  类型  示例值 描述
     *************************************************/

    /**
     * 签名类型 否	String(32)	HMAC-SHA256	签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    private String sign_type;

    /**
     * 用户标识 是	String(128)	wxd930ea5d5a258f4f	用户在商户appid下的唯一标识
     */
    private String openid;

    /**
     * 是否关注公众账号 否	String(1)	Y	用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    private String is_subscribe;

    /**
     * 用户子标识	sub_openid	否	String(128)	wxd930ea5d5a258f4f	用户在子商户appid下的唯一标识
     */
    private String sub_openid;

    /**
     * 是否关注子公众账号	sub_is_subscribe	否	String(1)	Y	用户是否关注子公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    private String sub_is_subscribe;

    /**
     * 交易类型 是	String(16)	JSAPI	JSAPI、NATIVE、APP
     */
    private String trade_type;

    /**
     * 付款银行 是	String(16)	CMC	银行类型，采用字符串类型的银行标识，银行类型见银行列表
     */
    private String bank_type;

    /**
     * 总金额  是	Int	100	订单总金额，单位为分
     */
    private Integer total_fee;

    /**
     * 应结订单金额 否	Int	100	应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    private Integer settlement_total_fee;

    /**
     * 货币种类 否	String(8)	CNY	货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String fee_type;

    /**
     * 现金支付金额   是	Int	100	现金支付金额订单现金支付金额，详见支付金额
     */
    private Integer cash_fee;

    /**
     * 现金支付货币类型 否	String(16)	CNY	货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String cash_fee_type;

    /**
     * 代金券金额    否	Int	10	代金券金额<=订单金额，订单金额-代金券金额=现金支付金额，详见支付金额
     */
    private Integer coupon_fee;

    /**
     * 代金券使用数量  否	Int	1	代金券使用数量
     */
    private Integer coupon_count;

    /**
     * 代金券类型    否	String	CASH代金券 CASH--充值代金券 --非充值代金券 NO_CASH---非充值代金券 充值券后有返回（取值：CASH、 并且订单使用了免充值券后有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0
     */
    private String coupon_type_0;

    /**
     * 代金券ID    否	String(20)	10000	代金券ID,$n为下标，从0开始编号
     */
    private String coupon_id_0;

    /**
     * 单个代金券支付金额    否	Int	100	单个代金券支付金额,$n为下标，从0开始编号
     */
    private Integer coupon_fee_0;

    /**
     * 微信支付订单号  是	String(32)	1217752501201407033233368018	微信支付订单号
     */
    private String transaction_id;

    /**
     * 商户订单号    是	String(32)	1212321211201407033568112322	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    private String out_trade_no;

    /**
     * 商家数据包    否	String(128)	123456	商家数据包，原样返回
     */
    private String attach;

    /**
     * 支付完成时间   是	String(14)	20141030133525	支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    private String time_end;

}
