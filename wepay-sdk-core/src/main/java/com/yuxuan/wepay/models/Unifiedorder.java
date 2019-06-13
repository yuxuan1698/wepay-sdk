package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 统一下单接口请求
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class Unifiedorder implements Serializable {
    /**************************************************
     * 字段名  必填  类型  示例值 描述
     *************************************************/

    /**
     * appid    是   String(32)	wxd678efh567hg6787	微信分配的公众号|小程序ID
     */
    @XmlElement
    private String appid;

    /**
     * 商户号  是   String(32)	1230000109	微信支付分配的商户号
     */
    @XmlElement
    private String mch_id;

    /**
     * sub_appid 是	String(32)	wx8888888888888888	当前调起支付的公众号|小程序APPID
     */
    @XmlElement
    private String sub_appid;

    /**
     * 子商户号 是   String(32)	1900000109	微信支付分配的子商户号
     */
    @XmlElement
    private String sub_mch_id;

    /**
     * 设备号  否	String(32)	013467007045764	自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
     */
    @XmlElement
    private String device_info;

    /**
     * 随机字符串    是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，长度要求在32位以内。推荐随机数生成算法
     */
    @XmlElement
    private String nonce_str;

    /**
     * 签名   是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	通过签名算法计算得出的签名值，详见签名生成算法
     */
    @XmlElement
    private String sign;

    /**
     * 签名类型 否	String(32)	MD5	签名类型，默认为MD5，支持HMAC-SHA256和MD5。
     */
    @XmlElement
    private String sign_type;

    /**
     * 商品描述 是	String(128)	腾讯充值中心-QQ会员充值字段请按照规范传递，具体  商品简单描述，该字段请按照规范传递，具体请见参数规定
     */
    @XmlElement
    private String body;

    /**
     * 商品详情 否	String(6000)	 	商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”
     */
    @XmlElement
    private String detail;

    /**
     * 附加数据 否	String(127)	深圳分店	附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
     */
    @XmlElement
    private String attach;

    /**
     * 商户订单号    是	String(32)	20150806125346	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。详见商户订单号
     */
    @XmlElement
    private String out_trade_no;

    /**
     * 货币类型 否	String(16)	CNY	符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型
     */
    @XmlElement
    private String fee_type;

    /**
     * 总金额  是	Int	88	订单总金额，单位为分，详见支付金额
     */
    @XmlElement
    private Integer total_fee;

    /**
     * 终端IP 是	String(16)	123.12.12.123	APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
     */
    @XmlElement
    private String spbill_create_ip;

    /**
     * 交易起始时间   否	String(14)	20091225091010	订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @XmlElement
    private String time_start;

    /**
     * 交易结束时间   否	String(14)	20091227091010;//订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。其他详见时间规则间间隔大于1分钟  建议：最短失效时间间隔大于1分钟
     */
    @XmlElement
    private String time_expire;

    /**
     * 订单优惠标记   否	String(32)	WXG	订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠
     */
    @XmlElement
    private String goods_tag;

    /**
     * 通知地址 是	String(256)	http://www.weixin.qq.com/wxpay/pay.php	异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
     */
    @XmlElement
    private String notify_url;

    /**
     * 交易类型   交易类型 是	String(16)	JSAPI	小程序取值如下：JSAPI，详细说明见参数规定
     */
    @XmlElement
    private String trade_type;

    /**
     * 商品ID 否	String(32)	12235413214070356458058	trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
     */
    @XmlElement
    private String product_id;

    /**
     * 指定支付方式   否	String(32)	no_credit	上传此参数no_credit--可限制用户不能使用信用卡支付
     */
    @XmlElement
    private String limit_pay;

    /**
     * 用户标识 否	String(128)	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o	trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。
     */
    @XmlElement
    private String openid;

    /**
     * 用户子标识    否	String(128)	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o	trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。
     * 下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。     *
     */
    @XmlElement
    private String sub_openid;

}

