package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 退款解密对象
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundNotifyReqInfo {
    /**************************************************
     * 字段名  必填  类型  示例值 描述
     *************************************************/

    /**
     * 微信订单号    transaction_id        是    String(32)1217752501201407033233368018    微信订单号
     */
    private String transaction_id;

    /**
     * 商户订单号    out_trade_no          是    String(32)1217752501201407033233368018    商户系统内部的订单号
     */
    private String out_trade_no;

    /**
     * 微信退款单号  refund_id             是    String(32)1217752501201407033233368018    微信退款单号
     */
    private String refund_id;

    /**
     * 商户退款单号  out_refund_no         是    String(64)1217752501201407033233368018    商户退款单号
     */
    private String out_refund_no;

    /**
     * 订单金额     total_fee              是    Int100    订单总金额，单位为分，只能为整数，详见支付金额
     */
    private Integer total_fee;

    /**
     * 应结订单金额 settlement_total_fee   否    Int100    当该订单有使用非充值券时，返回此字段。应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    private String settlement_total_fee;

    /**
     * 申请退款金额 refund_fee             是           Int100    退款总金额,单位为分
     */
    private Integer refund_fee;

    /**
     * 退款金额    settlement_refund_fee  是    Int100    退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    private String settlement_refund_fee;

    /**
     * 退款状态     refund_status          是    String(16)    SUCCESS    SUCCESS-退款成功    CHANGE-退款异常    REFUNDCLOSE—退款关闭
     */
    private String refund_status;

    /**
     * 退款成功时间 success_time           否    String(20)2017-12-15 09:46:01    资金退款至用户帐号的时间，格式2017-12-15 09:46:01
     */
    private String success_time;

    /**
     * 退款入账账户 refund_recv_accout     是    String(64)    招商银行信用卡0403            取当前退款单的退款入账方1）退回银行卡：    {银行名称}{卡类型}{卡尾号}2）退回支付用户零钱:    支付用户零钱3）退还商户:    商户基本账户            商户结算银行账户4）退回支付用户零钱通:    支付用户零钱通
     */
    private String refund_recv_accout;

    /**
     * 退款资金来源 refund_account         是    String(30)    REFUND_SOURCE_RECHARGE_FUNDS    REFUND_SOURCE_RECHARGE_FUNDS 可用余额退款/基本账户    REFUND_SOURCE_UNSETTLED_FUNDS 未结算资金退款
     */
    private String refund_account;

    /**
     * 退款发起来源refund_request_source  是    String(30)    API            API接口    VENDOR_PLATFORM商户平台
     */
    private String refund_request_source;
}
