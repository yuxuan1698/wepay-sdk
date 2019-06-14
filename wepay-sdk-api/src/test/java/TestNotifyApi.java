import com.alibaba.fastjson.JSON;
import com.yuxuan.wepay.handlers.WepayHandler;
import com.yuxuan.wepay.models.PayNotifyResult;
import com.yuxuan.wepay.models.RefundNotifyReqInfo;
import com.yuxuan.wepay.models.RefundNotifyResult;
import com.yuxuan.wepay.utils.AESUtil;
import com.yuxuan.wepay.utils.XmlUtil;
import org.junit.Test;

/**
 * @author yuxuan
 * @date 2019/6/14
 */
public class TestNotifyApi {

    @Test
    public void testPayNotify() {
        String notifyStr = "<xml>\n" +
                "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "  <attach><![CDATA[支付测试]]></attach>\n" +
                "  <bank_type><![CDATA[CFT]]></bank_type>\n" +
                "  <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "  <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
                "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
                "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
                "  <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n" +
                "  <sub_mch_id><![CDATA[10000100]]></sub_mch_id>\n" +
                "  <time_end><![CDATA[20140903131540]]></time_end>\n" +
                "  <total_fee>1</total_fee>\n" +
                "<coupon_fee_0><![CDATA[10]]></coupon_fee_0>\n" +
                "<coupon_count><![CDATA[1]]></coupon_count>\n" +
                "<coupon_type><![CDATA[CASH]]></coupon_type>\n" +
                "<coupon_id><![CDATA[10000]]></coupon_id> \n" +
                "  <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
                "</xml>";

        PayNotifyResult notifyResult = XmlUtil.convertToObject(notifyStr, PayNotifyResult.class);
        Boolean check = WepayHandler.checkReturnResult(notifyResult, TestConfig.APP_SIGN_KEY);
        System.out.println(check);
        System.out.println(JSON.toJSONString(notifyResult));
    }

    @Test
    public void testRefundNotify() {
        String notifyStr = "<xml>\n" +
                "<return_code>SUCCESS</return_code>\n" +
                "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "   <nonce_str><![CDATA[TeqClE3i0mvn3DrK]]></nonce_str>\n" +
                "   <req_info><![CDATA[T87GAHG17TGAHG1TGHAHAHA1Y1CIOA9UGJH1GAHV871HAGAGQYQQPOOJMXNBCXBVNMNMAJAA]]></req_info>\n" +
                "</xml>";

        RefundNotifyResult refundNotifyResult = XmlUtil.convertToObject(notifyStr, RefundNotifyResult.class);
        System.out.println(JSON.toJSONString(refundNotifyResult));

        String decryptData = AESUtil.decryptData(refundNotifyResult.getReq_info(), TestConfig.APP_SIGN_KEY);
        RefundNotifyReqInfo notifyReqInfo = XmlUtil.convertToObject(decryptData, RefundNotifyReqInfo.class);
        System.out.println(JSON.toJSONString(notifyReqInfo));
    }
}
