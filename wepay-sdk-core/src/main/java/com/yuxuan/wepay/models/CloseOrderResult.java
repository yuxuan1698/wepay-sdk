package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 关闭订单响应
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CloseOrderResult extends MchPayResult {
    /*********************************************
     * 字段名	变量名	必填	类型	示例值	描述
     ********************************************/

    /**
     * 业务结果描述	result_msg	是	String(32)	OK	对于业务执行的详细描述
     */
    private String result_msg;
}
