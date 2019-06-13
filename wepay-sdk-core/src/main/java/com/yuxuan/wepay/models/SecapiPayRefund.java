package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 退款申请
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecapiPayRefund {
	/**************************************************
	 * 字段名  必填  类型  示例值 描述
	 *************************************************/

	/**
	 * 服务商appid	是	String(32)	wx8888888888888888	申请微信支付服务商的公众号appid
	 */
	@XmlElement
	private String appid;

	/**
	 * 商户号	是	String(32)	1900000109	微信支付分配的商户号
	 */
	@XmlElement
	private String mch_id;

	/**
	 * 公众号|小程序的appid	是	String(32)	wx8888888888888888	当前调起支付的公众号|小程序appid
	 */
	@XmlElement
	private String sub_appid;

	/**
	 * 子商户号	sub_mch_id	是	String(32)	1900000109	微信支付分配的子商户号
	 */
	@XmlElement
	private String sub_mch_id;

	/**
	 * 随机字符串	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位。推荐随机数生成算法
	 */
	@XmlElement
	private String nonce_str;

	/**
	 * 签名	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名，详见签名生成算法
	 */
	@XmlElement
	private String sign;

	/**
	 * 否	String(32)	HMAC-SHA256	签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
	 */
	@XmlElement
	private String sign_type;

	/****************************************
	 * transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no
	 ***************************************/
	/**
	 * 微信订单号	二选一	String(32)	1217752501201407033233368018	微信生成的订单号，在支付通知中有返回
	 */
	@XmlElement
	private String transaction_id;
	/**
	 * 商户订单号	二选一	String(32)	1217752501201407033233368018	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
	 */
	@XmlElement
	private String out_trade_no;

	/**
	 * 商户退款单号	是	String(64)	1217752501201407033233368018	商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	 */
	@XmlElement
	private String out_refund_no;

	/**
	 * 订单金额	是	Int	100	订单总金额，单位为分，只能为整数，详见支付金额
	 */
	@XmlElement
	private Integer total_fee;

	/**
	 * 申请退款金额	是	Int	100	退款总金额，订单总金额，单位为分，只能为整数，详见支付金额
	 */
	@XmlElement
	private Integer refund_fee;

	/**
	 * 货币种类	否	String(8)	CNY	货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 */
	@XmlElement
	private String refund_fee_type;

	/**
	 * 退款原因		否	String(80)	商品已售完	若商户传入，会在下发给用户的退款消息中体现退款原因
	 */
	@XmlElement
	private String refund_desc;

	/**
	 * 退款资金来源	否	String(30)	REFUND_SOURCE_RECHARGE_FUNDS仅针对老资金流商户使用REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
	 */
	@XmlElement
	private String refund_account;


	/**
	 * 退款结果通知url	notify_url	否	String(256)	https://weixin.qq.com/notify/	异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数	如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。
	 * 根据微信文档 在服务商小程序模式接口文档中 没有这个字段 后续需要留意以下是否有效
	 */
	@XmlElement
	private String notify_url;
}
