package com.yuxuan.wepay.models;

import com.yuxuan.wepay.utils.AdaptorCDATA;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 订单查询响应
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderQueryResult extends MchPayResult {
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     * 设备号	device_info	否	String(32)	013467007045764	微信支付分配的终端设备号，
     */
    private String device_info;

    /**
     * 用户标识	openid  是	String(128)	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o	用户在商户appid下的唯一标识
     */
    private String openid;

    /**
     * 是否关注公众账号	is_subscribe    否	String(1)	Y	用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    private String is_subscribe;

    /**
     * 用户子标识	sub_openid	否	String(128)	wxd930ea5d5a258f4f	用户在子商户appid下的唯一标识
     */
    private String sub_openid;

    /**
     * 是否关注子公众账号	sub_is_subscribe	否	String(1)	Y	用户是否关注子公众账号，Y-关注，N-未关注（机构商户不返回）
     */
    private String sub_is_subscribe;

    /**
     * 交易类型	trade_type	是	String(16)	JSAPI	调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定
     */
    private String trade_type;

    /**
     * 交易状态	trade_state	是	String(32)	SUCCESS//SUCCESS—支付成功//REFUND—转入退款//NOTPAY—未支付//CLOSED—已关闭//REVOKED—已撤销（刷卡支付）//USERPAYING--用户支付中//PAYERROR--支付失败(其他原因，如银行返回失败)
     */
    private String trade_state;

    /**
     * 付款银行	bank_type	是	String(16)	CMC	银行类型，采用字符串类型的银行标识
     */
    private String bank_type;

    /**
     * 商品详情	detail	否	String(8192) 商品详细列表，使用Json格式，传输签名前请务必使用CDATA标签将JSON文本串保护起来。如果使用了单品优惠，会有单品优惠信息返回
     */
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String detail;

    /**
     * 标价金额	total_fee	是	Int	100	订单总金额，单位为分
     */
    private String total_fee;

    /**
     * 标价币种	fee_type	否	String(8)	CNY	货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String fee_type;

    /**
     * 应结订单金额	settlement_total_fee    否	Int	100	当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    private String settlement_total_fee;

    /**
     * 现金支付金额	cash_fee	是	Int	100	现金支付金额订单现金支付金额，详见支付金额
     */
    private String cash_fee;

    /**
     * 现金支付币种	cash_fee_type	否	String(16)	CNY	货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String cash_fee_type;

    /**
     * 代金券金额	coupon_fee	否	Int	100	“代金券”金额<=订单金额，订单金额-“代金券”金额=现金支付金额，详见支付金额
     */
    private String coupon_fee;

    /**
     * 代金券使用数量		coupon_count	否	Int	1	代金券使用数量
     */
    private String coupon_count;

    /**
     * 代金券ID	coupon_id_$n	否	String(20)	10000 	代金券ID, $n为下标，从0开始编号
     */
    private String coupon_id_0;

    /**
     * 代金券类型    coupon_type_$n	否	String	CASH //CASH--充值代金券 //NO_CASH---非充值优惠券 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
     */
    private String coupon_type_0;

    /**
     * 单个代金券支付金额    coupon_fee_$n	否	Int	100	单个代金券支付金额, $n为下标，从0开始编号
     */
    private String coupon_fee_0;

    /**
     * 微信支付订单号	    transaction_id	是	String(32)	1009660380201506130728806387	微信支付订单号
     */
    private String transaction_id;

    /**
     * 商户订单号	out_trade_no	是	String(32)	20150806125346	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    private String out_trade_no;

    /**
     * 附加数据	attach	否	String(128)	深圳分店	附加数据，原样返回
     */
    private String attach;

    /**
     * 支付完成时间   time_end	是	String(14)	20141030133525	订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    private String time_end;

    /**
     * 交易状态描述   trade_state_desc	是	String(256)	支付失败，请重新下单支付	对当前查询订单状态的描述和下一步操作的指引
     */
    private String trade_state_desc;

}
