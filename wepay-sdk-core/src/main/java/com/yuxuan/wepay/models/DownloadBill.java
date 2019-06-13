package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 下载对账单请求
 *
 * @author yuxuan
 * @date 2019/6/13
 */
@Data
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class DownloadBill {
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     * 公众账号ID	appid	是	String(32)	wx8888888888888888	微信分配的公众账号ID
     */
    @XmlElement
    private String appid;

    /**
     * 商户号	mch_id	是	String(32)	1900000109	微信支付分配的商户号
     */
    @XmlElement
    private String mch_id;

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
     * 对账单日期	bill_date	是	String(8)	20140603	下载对账单的日期，格式：20140603
     */
    @XmlElement
    private String bill_date;

    /**
     * 账单类型	bill_type	否	String(8)	ALL
     *  ALL（默认值），返回当日所有订单信息（不含充值退款订单）
     *  SUCCESS，返回当日成功支付的订单（不含充值退款订单）
     *  REFUND，返回当日退款订单（不含充值退款订单）
     *  RECHARGE_REFUND，返回当日充值退款订单
     */
    @XmlElement
    private String bill_type;

    /**
     * 压缩账单	tar_type	否	String	GZIP	非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     */
    @XmlElement
    private String tar_type;
}
