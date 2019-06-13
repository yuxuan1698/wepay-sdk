package com.yuxuan.wepay.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 下载资金账单响应
 *
 * @author yuxuan
 * @date 2019/6/13
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class DownloadFundflowResult extends MchPayResult{

    /**
     * 内容
     */
    private String text;
}
