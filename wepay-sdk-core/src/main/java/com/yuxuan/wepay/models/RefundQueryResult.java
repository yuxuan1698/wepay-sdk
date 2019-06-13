package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 退款查询响应
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class
RefundQueryResult extends MchPayResult {
	/*********************************************
	 * 字段名	变量名	必填	类型	示例值	描述
	 ********************************************/

	/**
	 * 微信订单号	transaction_id			是	String(32)	1217752501201407033233368018	微信订单号
	 */
	private String 	transaction_id;

	/**
	 * 商户订单号	out_trade_no			是	String(32)	1217752501201407033233368018	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
	 */
	private String 	out_trade_no;

	/**
	 * 订单金额	total_fee				是	Int	100	订单总金额，单位为分，只能为整数，详见支付金额
	 */
	private String total_fee;

	/**
	 * 应结订单金额	settlement_total_fee否	Int	100	当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
	 */
	private String settlement_total_fee;

	/**
	 * 货币种类	fee_type				否	String(8)	CNY	订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 */
	private String fee_type;

	/**
	 * 现金支付金额	cash_fee			是	Int	100	现金支付金额，单位为分，只能为整数，详见支付金额
	 */
	private String cash_fee;

	/**
	 * 退款笔数	refund_count			是	Int	1	当前返回退款笔数
	 */
	private String refund_count;

	/**
	 * 商户退款单号	out_refund_no_$n	是	String(64)	1217752501201407033233368018	商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	 */
	private String out_refund_no_0;

	/**
	 * 微信退款单号	refund_id_$n		是	String(32)	1217752501201407033233368018	微信退款单号
	 */
	private String refund_id_0;

	/**
	 * 退款渠道	refund_channel_$n		否	String(16)	ORIGINAL	ORIGINAL—原路退款	BALANCE—退回到余额	OTHER_BALANCE—原账户异常退到其他余额账户	OTHER_BANKCARD—原银行卡异常退到其他银行卡
	 */
	private String refund_channel_0;

	/**
	 * 订单总退款次数	total_refund_count	否	Int	35	订单总共已发生的部分退款次数，当请求参数传入offset后有返回
	 */
	private String total_refund_count;

	/**
	 * 退款金额 refund_fee 是 	注意：接口文档没这个字段，实测范围有这个字段，必须加上否则验签不通过
	 */
	private String refund_fee;
	/**
	 * 申请退款金额	refund_fee_$n		是	Int	100	退款总金额,单位为分,可以做部分退款
	 */
	private String refund_fee_0;

	/**
	 * 退款金额	settlement_refund_fee_$n否	Int	100	退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
	 */
	private String settlement_refund_fee_0;

	/**
	 * 代金券类型	coupon_type_$n_$m		否	String(8)	CASH	CASH--充值代金券	NO_CASH---非充值优惠券	开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,$m为下标,从0开始编号，举例：coupon_type_$0_$1
	 */
	private String coupon_type_0_0;

	/**
	 * 总代金券退款金额	coupon_refund_fee_$n	否	Int	100	代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
	 */
	private String coupon_refund_fee_0;

	/**
	 * 退款代金券使用数量	coupon_refund_count_$n	否	Int	1	退款代金券使用数量 ,$n为下标,从0开始编号
	 */
	private String coupon_refund_count_0;

	/**
	 * 退款代金券ID	coupon_refund_id_$n_$m		否	String(20)	10000 	退款代金券ID, $n为下标，$m为下标，从0开始编号
	 */
	private String coupon_refund_id_0_0;

	/**
	 * 单个代金券退款金额	coupon_refund_fee_$n_$m	否	Int	100	单个退款代金券支付金额, $n为下标，$m为下标，从0开始编号
	 */
	private String coupon_refund_fee_0_0;

	/**
	 * 退款状态	refund_status_$n				是	String(16)	SUCCESS	退款状态：	SUCCESS—退款成功	REFUNDCLOSE—退款关闭。	PROCESSING—退款处理中	CHANGE—退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。$n为下标，从0开始编号。
	 */
	private String refund_status_0;

	/**
	 * 退款资金来源	refund_account_$n			否	String(30)	REFUND_SOURCE_RECHARGE_FUNDS	REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户	REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款	$n为下标，从0开始编号。
	 */
	private String refund_account_0;

	/**
	 * 退款入账账户	refund_recv_accout_$n		是	String(64)	招商银行信用卡0403	取当前退款单的退款入账方1）退回银行卡：	{银行名称}{卡类型}{卡尾号}2）退回支付用户零钱:	支付用户零钱3）退还商户:	商户基本账户			商户结算银行账户4）退回支付用户零钱通:	支付用户零钱通
	 */
	private String refund_recv_accout_0;

	/**
	 * 退款成功时间	refund_success_time_$n		否	String(20)	2016-07-25 15:26:26	退款成功时间，当退款状态为退款成功时有返回。$n为下标，从0开始编号。
	 */
	private String refund_success_time_0;


}
