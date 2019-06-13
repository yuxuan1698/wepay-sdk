package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 退款申请响应
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecapiPayRefundResult extends MchPayResult {
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     * 微信订单号	是	String(32)	4007752501201407033233368018	微信订单号
     */
    private String transaction_id;

    /**
     * 商户订单号	是	String(32)	33368018	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    private String out_trade_no;

    /**
     * 商户退款单号	是	String(64)	121775250	商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    private String out_refund_no;

    /**
     * 微信退款单号	是	String(32)	2007752501201407033233368018	微信退款单号
     */
    private String refund_id;

    /**
     * 申请退款金额	是	Int	100	退款总金额,单位为分,可以做部分退款
     */
    private String refund_fee;

    /**
     * 退款金额	否	Int	100	去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    private String settlement_refund_fee;

    /**
     * 订单金额	是	Int	100	订单总金      标价金额	total_fee	是	Int	100	订单总金额，单位为分，只能为整数，详见支付金额
     */
    private Integer total_fee;

    /**
     * 应结订单金额		否	Int	100	去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    private String settlement_total_fee;

    /**
     * 货币种类	否	String(8)	CNY	订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String fee_type;

    /**
     * 现金支付金额	是	Int	100	现金支付金额，单位为分，只能为整数，详见支付金额
     */
    private String cash_fee;

    /**
     * 现金退款金额	否	Int	100	现金退款金额，单位为分，只能为整数，详见支付金额
     */
    private String cash_refund_fee;

    /**
     * 代金券退款总金额	否	Int	100	代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
     */
    private String coupon_refund_fee;

    /**
     * 退款代金券使用数量	否	Int	1	退款代金券使用数量
     */
    private String coupon_refund_count;

    /**
     * 否	String(8)	CASH--充值代金券  NO_CASH---非充值代金券 返回（取值：CASH、NO_CASH）。$n为下      订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0
     */
    private String coupon_type_0;

    /**
     * 退款代金券ID	否	String(20)	10000 	退款代金券ID, $n为下标，从0开始编号
     */
    private String coupon_refund_id_0;

    /**
     * 单个代金券退款金额	否	Int	100	代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
     */
    private String coupon_refund_fee_0;


}
