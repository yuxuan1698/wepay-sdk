package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 主动上对象
 *
 * @author yuxuan
 * @date 2019/6/13
 */
@Data
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayitilReport implements Serializable {
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     *  公众账号ID	appid	是	String(32)	wx8888888888888888	微信分配的公众账号ID
     */
    @XmlElement
    private String appid;

    /**
     *  商户号	mch_id	是	String(32)	1900000109	微信支付分配的商户号
     */
    @XmlElement
    private String mch_id;

    /**
     *  子商户公众账号ID	sub_appid	否	String(32)	wx8888888888888888	微信分配的子商户公众账号ID
     */
    @XmlElement
    private String sub_appid;

    /**
     * 子商户号	sub_mch_id	是	String(32)	1900000109	微信支付分配的子商户号
     */
    @XmlElement
    private String sub_mch_id;

    /**
     * 设备号	device_info	否	String(32)	013467007045764	微信支付分配的终端设备号，商户自定义
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
     * 接口URL	interface_url	是	String(127)	https://api.mch.weixin.qq.com/pay/unifiedorder
     * 上报对应的接口的完整URL，类似：https://api.mch.weixin.qq.com/pay/unifiedorder
     * 对于刷卡支付，为更好的和商户共同分析一次业务行为的整体耗时情况，对于两种接入模式，请都在门店侧对一次刷卡行为进行一次单独的整体上报，上报URL指定为：
     * https://api.mch.weixin.qq.com/pay/micropay/total
     * 关于两种接入模式具体可参考本文档章节：刷卡支付商户接入模式
     *　其它接口调用仍然按照调用一次，上报一次来进行。
     */
    @XmlElement
    private String interface_url;

    /**
     * 接口耗时	execute_time	是	Int	1000	接口耗时情况，单位为毫秒
     */
    @XmlElement
    private int execute_time;

    /**
     * 返回状态码	return_code	是	String(16)	SUCCESS
     * SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
     */
    @XmlElement
    private String return_code;

    /**
     * 返回信息	return_msg	否	String(128)	签名失败
     *  返回信息，如非空，为错误原因
     *      签名失败
     *      参数格式校验错误
     */
    @XmlElement
    private String return_msg;

    /**
     * 业务结果	result_code	是	String(16)	SUCCESS	SUCCESS/FAIL
     */
    @XmlElement
    private String result_code;

    /**
     * 错误代码	err_code	否	String(32)	SYSTEMERROR
     *  ORDERNOTEXIST—订单不存在
     *  SYSTEMERROR—系统错误
     */
    @XmlElement
    private String err_code;

    /**
     * 错误代码描述	err_code_des	否	String(128)	系统错误	结果信息描述
     */
    @XmlElement
    private String err_code_des;

    /**
     * 商户订单号	out_trade_no	否	String(32)	1217752501201407033233368018	商户系统内部的订单号,商户可以在上报时提供相关商户订单号方便微信支付更好的提高服务质量。
     */
    @XmlElement
    private String out_trade_no;

    /**
     * 访问接口IP	user_ip	是	String(16)	8.8.8.8	发起接口调用时的机器IP
     */
    @XmlElement
    private String user_ip;

    /**
     * 商户上报时间	time	否	String(14)	20091227091010	系统时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
     */
    @XmlElement
    private String time;
}
