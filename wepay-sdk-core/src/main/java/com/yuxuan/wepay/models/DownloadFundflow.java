package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 下载资金账单请求
 *
 * @author yuxuan
 * @date 2019/6/13
 */
@Data
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class DownloadFundflow {
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
     * 签名类型	sign_type	否	String(32)	HMAC-SHA256	签名类型，目前仅支持HMAC-SHA256
     */
    @XmlElement
    private String sign_type;

    /**
     * 对账单日期	bill_date	是	String(8)	20140603	下载对账单的日期，格式：20140603
     */
    @XmlElement
    private String bill_date;

    /**
     * 资金账户类型	account_type	是	String(8)	Basic
     *  账单的资金来源账户：
     *      Basic  基本账户
     *      Operation 运营账户
     *      Fees 手续费账户
     */
    @XmlElement
    private String account_type;

    /**
     * 压缩账单	tar_type	否	String(8)	GZIP	非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     */
    @XmlElement
    private String tar_type;
}
