package com.yuxuan.wepay.feigns;

import com.yuxuan.wepay.feigns.annotations.Domain;
import com.yuxuan.wepay.models.*;
import feign.RequestLine;

/**
 * @author yuxuan
 * @date 2019/6/10
 */
@Domain("https://api.mch.weixin.qq.com")
public interface WepayApi {
    /**
     * 统一下单接口
     *
     * @param unifiedorder
     * @return
     */
    @RequestLine("POST /pay/unifiedorder")
    UnifiedorderResult payUnifiedorder(Unifiedorder unifiedorder);

    /**
     * 订单查询
     *
     * @param orderQuery
     * @return
     */
    @RequestLine("POST /pay/orderquery")
    OrderQueryResult payOrderquery(OrderQuery orderQuery);

    /**
     * 关闭订单
     * @param closeorder
     * @return
     */
    @RequestLine("POST /pay/closeorder")
    CloseOrderResult payCloseorder(CloseOrder closeorder);

    /**
     * 提交付款码支付 (用户被扫码支付)
     *
     * @param scanPay
     * @return
     */
    @RequestLine("POST /pay/micropay")
    ScanPayResult payMicropay(ScanPay scanPay);

    /**
     * 退款申请
     *
     * 注意：
     *	1.交易时间超过1 年的订单无法提交退款；
     *	2.支持部分退款，部分退需要设置相同的订单号和不同的out_refund_no。一笔退款失
     *	败后重新提交，要采用原来的out_refund_no。总退款金额不能超过用户实际支付金额。
     * @param secapiPayRefund
     * @return
     */
    @RequestLine("POST /secapi/pay/refund")
    SecapiPayRefundResult secapiPayRefund(SecapiPayRefund secapiPayRefund);

    /**
     * 退款查询
     *
     * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款
     * 20 分钟内到账，银行卡支付的退款3 个工作日后重新查询退款状态。
     * @param refundquery
     * @return
     */
    @RequestLine("POST /pay/refundquery")
    RefundQueryResult payRefundquery(RefundQuery refundquery);

    /**
     *  转换短链接
     *
     * @param shortUrl
     * @return
     */
    @RequestLine("POST /tools/shorturl")
    ShortUrlResult toolsShorturl(ShortUrl shortUrl);

    /**
     * 下载对账单
     *
     * @param downloadBill
     * @return
     */
    @RequestLine("POST /pay/downloadbill")
    DownloadBillResult payDownloadbill(DownloadBill downloadBill);

    /**
     * 下载资金账单
     *
     * @param downloadfundflow
     * @return
     */
    @RequestLine("POST /pay/downloadfundflow")
    DownloadFundflowResult payDownloadfundflow(DownloadFundflow downloadfundflow);


    /**
     * 微信支付接口调用耗时、返回信息 主动上报
     * @return
     */
    @RequestLine("POST /payitil/report")
    MchPayResult payitilReport(PayitilReport payitilReport);

}
