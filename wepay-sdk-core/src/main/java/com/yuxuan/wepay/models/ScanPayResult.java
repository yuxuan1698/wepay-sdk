package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 提交付款码支付响应
 *
 * @author yuxuan
 * @date 2019/6/13
 */
@Data
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanPayResult extends MchPayResult{
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     * 用户标识	openid	是	String(128)	Y	用户在商户appid 下的唯一标识
     */
    private String openid;

    /**
     * 是否关注公众账号	is_subscribe	是	String(1)	Y	用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
     */
    private String is_subscribe;

    /**
     * 交易类型	trade_type	是	String(16)	MICROPAY	MICROPAY 付款码支付
     */
    private String trade_type;

    /**
     * 付款银行	bank_type	是	String(32)	CMC	银行类型，采用字符串类型的银行标识，详见银行类型
     */
    private String bank_type;

    /**
     * 币类型	fee_type	否	String(16)	CNY	符合ISO 4217标准的三位字母代码，默认人民币：CNY，详见货币类型
     */
    private String fee_type;

    /**
     * 订单金额	total_fee	是	Int	888	订单总金额，单位为分，只能为整数，详见支付金额
     */
    private int total_fee;

    /**
     * 应结订单金额	settlement_total_fee	否	Int	100	当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    private int settlement_total_fee;

    /**
     * 代金券金额	coupon_fee	否	Int	100	“代金券”金额<=订单金额，订单金额-“代金券”金额=现金支付金额，详见支付金额
     */
    private int coupon_fee;

    /**
     * 现金支付货币类型	cash_fee_type	否	String(16)	CNY	符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String cash_fee_type;

    /**
     * 现金支付金额	cash_fee	是	Int	100	订单现金支付金额，详见支付金额
     */
    private int cash_fee;

    /**
     * 微信支付订单号	transaction_id	是	String(32)	1217752501201407033233368018	微信支付订单号
     */
    private String transaction_id;

    /**
     * 商户订单号	out_trade_no	是	String(32)	1217752501201407033233368018	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。
     */
    private String out_trade_no;

    /**
     *  商家数据包	attach	否	String(128)	123456	商家数据包，原样返回
     */
    private String attach;

    /**
     * 支付完成时间	time_end	是	String(14)	20141030133525	订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。详见时间规则
     */
    private String time_end;

    /**
     * 营销详情	promotion_detail	否	String(6000)	示例见下文	新增返回，单品优惠功能字段，需要接入请见详细说明
     */
    private String promotion_detail;
}
