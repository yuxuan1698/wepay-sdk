package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 退款查询请求
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundQuery {
	/*********************************************
	 * 字段名	变量名	必填	类型	示例值	描述
	 ********************************************/

	/**
	 * 小程序ID	appid	是	String(32)	wx8888888888888888	微信分配的小程序ID
	 */
	@XmlElement
	private String appid;

	/**
	 * 商户号	mch_id		是	String(32)	1900000109	微信支付分配的商户号
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
	 * 随机字符串nonce_str是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位。推荐随机数生成算法
	 */
	@XmlElement
	private String nonce_str;

	/**
	 * 签名	sign		是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名，详见签名生成算法
	 */
	@XmlElement
	private String sign;

	/**
	 * 签名类型sign_type	否	String(32)	HMAC-SHA256	签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
	 */
	@XmlElement
	private String sign_type;

	/**
	 * 微信订单号 transaction_id	四选一	String(32)	1217752501201407033233368018	微信订单号查询的优先级是： refund_id > out_refund_no > transaction_id > out_trade_no
	 */
	@XmlElement
	private String transaction_id;

	/**
	 * 商户订单号 out_trade_no	String(32)	1217752501201407033233368018	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
	 */
	@XmlElement
	private String out_trade_no;

	/**
	 * 商户退款单号 out_refund_no	String(64)	1217752501201407033233368018	商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	 */
	@XmlElement
	private String out_refund_no;

	/**
	 * 微信退款单号 refund_id	String(32)	1217752501201407033233368018 微信生成的退款单号，在申请退款接口有返回 偏移量	offset	否	Int	15 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
	 */
	@XmlElement
	private String refund_id;

}
