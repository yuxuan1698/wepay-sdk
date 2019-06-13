package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 退款通知对象
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundNotifyResult extends MchPayResult{
    /**************************************************
     * 字段名  必填  类型  示例值 描述
     *************************************************/

    /**
     *  返回状态码   return_code 是    String(16)    SUCCESS    SUCCESS/FAIL    此字段是通信标识，非结果标识，退款是否成功需要解密后查看refund_status 来判断
     */
    private String return_code;

    /**
     *  返回信息    return_msg    否    String(128)    返回信息，如非空，为错误原因            参数格式校验错误
     */
    private String return_msg;

    /**
     *  公众账号ID  appid    是    String(32)    wx8888888888888888    微信分配的公众账号ID（企业号corpid即为此appId）
     */
    private String appid;

    /**
     *  退款的商户号  mch_id    是    String(32) 1900000109    微信支付分配的商户号
     */
    private String mch_id;

    /**
     *  特约商户公众账号ID   sub_appid   否   String(32)  wx8888888888888888  微信分配的特约商户的公众账号
     */
    private String sub_appid;

    /**
     *  特约商户商户号 sub_mch_id  是   String(32)  1900000109  微信支付分配的特约商户的商户号
     */
    private String sub_mch_id;

    /**
     *  随机字符串    nonce_str  是    String(32)5K8264ILTKCH16CQ2502SI8ZNMTM67VS    随机字符串，不长于32位。推荐随机数生成算法
     */
    private String nonce_str;

    /**
     *  加密信息    req_info    是    String(1024)    加密信息请用商户秘钥进行解密，详见解密方式
     * {@link RefundNotifyReqInfo}
     */
    private String req_info;
}
