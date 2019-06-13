package com.yuxuan.wepay.models;

import lombok.Data;

/**
 * 公共响应参数
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
public class MchPayResult {
    /**************************************************
     * 字段名  必填  类型  示例值 描述
     *************************************************/

    /**
     * 返回状态码    是  String(16)	SUCCESS	SUCCESS/FAIL	此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    protected String return_code;
    /**
     * 返回信息 否  String(128)	签名失败 返回信息，如非空，为错误原因	签名失败 	参数格式校验错误
     */
    protected String return_msg;

    /**
     * 公众账号ID   是	String(32)	wx8888888888888888	微信分配的小程序ID
     */
    protected String appid;
    /**
     * 商户号  是	String(32)	1900000109	微信支付分配的商户号
     */
    protected String mch_id;
    /**
     * 子商户公众账号ID	sub_appid	否	String(32)	wx8888888888888888	微信分配的子商户公众账号ID
     */
    protected String sub_appid;
    /**
     * 子商户号	sub_mch_id	是	String(32)	1900000109	微信支付分配的子商户号
     */
    protected String sub_mch_id;
    /**
     * 随机字符串    是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位
     */
    protected String nonce_str;
    /**
     * 设备号	device_info	否	String(32)	013467007045764	调用接口提交的终端设备号，
     */
    protected String device_info;

    /**
     * 签名   是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名，详见签名算法
     */
    protected String sign;

    /**
     * 业务结果 是	String(16)	SUCCESS	SUCCESS/FAIL
     */
    protected String result_code;
    /**
     * 错误代码 否	String(32)	SYSTEMERROR	错误返回的信息描述
     */
    protected String err_code;
    /**
     * 错误代码描述   否	String(128)	系统错误	错误返回的信息描述
     */
    protected String err_code_des;


}
