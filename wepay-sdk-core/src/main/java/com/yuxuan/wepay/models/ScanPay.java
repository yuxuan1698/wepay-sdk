package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 提交付款码支付请求
 *
 * @author yuxuan
 * @date 2019/6/13
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanPay {
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     * 公众账号ID	appid	是	String(32)	wx8888888888888888	微信分配的公众账号ID（企业号corpid即为此appId）
     */
    @XmlElement
    private String appid;

    /**
     * 商户号	mch_id	是	String(32)	1900000109	微信支付分配的商户号
     */
    @XmlElement
    private String mch_id;

    /**
     * 设备号	device_info	否	String(32)	013467007045764	终端设备号(商户自定义，如门店编号)
     */
    @XmlElement
    private String device_info;

    /**
     * 随机字符串	nonce_str	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位。推荐随机数生成算法
     */
    @XmlElement
    private String nonce_str;

    /**
     * 签名	sign	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名，详见签名生成算法
     */
    @XmlElement
    private String sign;

    /**
     * 签名类型	sign_type	否	String(32)	HMAC-SHA256	签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @XmlElement
    private String sign_type;

    /**
     * 商品描述	body	是	String(128)	image形象店-深圳腾大- QQ公仔	商品简单描述，该字段须严格按照规范传递，具体请见参数规定
     */
    @XmlElement
    private String body;

    /**
     * 商品详情	detail	否	String(6000)    单品优惠功能字段，需要接入详见单品优惠详细说明
     */
    @XmlElement
    private String detail;

    /**
     *  附加数据	attach	否	String(127)	说明	附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    @XmlElement
    private String attach;

    /**
     *  商户订单号	out_trade_no	是	String(32)	1217752501201407033233368018	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
     */
    @XmlElement
    private String out_trade_no;

    /**
     *  订单金额	total_fee	是	Int	888	订单总金额，单位为分，只能为整数，详见支付金额
     */
    @XmlElement
    private int total_fee;

    /**
     * 货币类型	fee_type	否	String(16)	CNY	符合ISO4217标准的三位字母代码，默认人民币：CNY，详见货币类型
     */
    @XmlElement
    private String fee_type;

    /**
     *  终端IP	spbill_create_ip	是	String(64)	8.8.8.8	支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     */
    @XmlElement
    private String spbill_create_ip;

    /**
     * 订单优惠标记	goods_tag	否	String(32)	1234	订单优惠标记，代金券或立减优惠功能的参数，详见代金券或立减优惠
     */
    @XmlElement
    private String goods_tag;

    /**
     * 指定支付方式	limit_pay	否	String(32)	no_credit	no_credit--指定不能使用信用卡支付
     */
    @XmlElement
    private String limit_pay;

    /**
     *  交易起始时间	time_start	否	String(14)	20091225091010	订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @XmlElement
    private String time_start;

    /**
     *  交易结束时间	time_expire	否	String(14)	20091227091010订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。注意：最短失效时间间隔需大于1分钟
     */
    @XmlElement
    private String time_expire;

    /**
     * 电子发票入口开放标识	receipt	否	String(8)	Y	Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     */
    @XmlElement
    private String receipt;

    /**
     *  授权码	auth_code	是	String(128)	120061098828009406	扫码支付授权码，设备读取用户微信中的条码或者二维码信息
     *  （注：用户付款码条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     */
    @XmlElement
    private String auth_code;

    /**
     * 场景信息	scene_info	否	String(256)
     *  {"store_info" : {
     *  "id": "SZTX001",
     *  "name": "腾大餐厅",
     *  "area_code": "440305",
     *  "address": "科技园中一路腾讯大厦" }}     *
     *  该字段用于上报场景信息，目前支持上报实际门店信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开
     */
    @XmlElement
    private String scene_info;

}
