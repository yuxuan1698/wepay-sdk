import com.alibaba.fastjson.JSON;
import com.yuxuan.wepay.models.Unifiedorder;
import com.yuxuan.wepay.utils.XmlUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * @author yuxuan
 * @date 2019/6/10
 */
public class TestXmlConvert {
    
    @Test
    public void convertObjectToXml() {
        Unifiedorder unifiedorder = new Unifiedorder();
        unifiedorder.setAppid("wxd678efh567hg6787");
        unifiedorder.setMch_id("1230000109");
        unifiedorder.setOpenid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");
        unifiedorder.setSub_appid("wx8888888888888888");
        unifiedorder.setSub_mch_id("1900000109");
        unifiedorder.setSub_openid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");
        unifiedorder.setAttach("深圳分店");
        unifiedorder.setBody("腾讯充值中心-QQ会员充值");
        unifiedorder.setNonce_str(RandomStringUtils.randomAlphabetic(16));
        unifiedorder.setNotify_url("http://www.weixin.qq.com/wxpay/pay.php");
        unifiedorder.setOut_trade_no("20150806125346");
        unifiedorder.setTime_start("20091225091010");
        unifiedorder.setTime_expire("20091227091010");
        unifiedorder.setSpbill_create_ip("123.12.12.123");
        unifiedorder.setTotal_fee(88);
        // JSAPI  NATIVE
        unifiedorder.setTrade_type("JSAPI");
        //请求包体签名
        unifiedorder.setSign("C380BEC2BFD727A4B6845133519F3AD6");
        String xmlStr = XmlUtil.convertToXml(unifiedorder);

        System.out.println(xmlStr);
    }

    @Test
    public void convertXmlToObject() {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<xml>\n" +
                "    <appid>wxd678efh567hg6787</appid>\n" +
                "    <mch_id>1230000109</mch_id>\n" +
                "    <sub_appid>wx8888888888888888</sub_appid>\n" +
                "    <sub_mch_id>1900000109</sub_mch_id>\n" +
                "    <nonce_str>zgdUJQMMZBoxmXlT</nonce_str>\n" +
                "    <sign>C380BEC2BFD727A4B6845133519F3AD6</sign>\n" +
                "    <body>腾讯充值中心-QQ会员充值</body>\n" +
                "    <attach>深圳分店</attach>\n" +
                "    <out_trade_no>20150806125346</out_trade_no>\n" +
                "    <total_fee>88</total_fee>\n" +
                "    <spbill_create_ip>192.168.1.79</spbill_create_ip>\n" +
                "    <time_start>20091225091010</time_start>\n" +
                "    <time_expire>20091227091010</time_expire>\n" +
                "    <notify_url>http://www.weixin.qq.com/wxpay/pay.php</notify_url>\n" +
                "    <trade_type>JSAPI</trade_type>\n" +
                "    <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>\n" +
                "    <sub_openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</sub_openid>\n" +
                "</xml>";

        System.out.println(JSON.toJSONString(XmlUtil.convertToObject(xmlStr, Unifiedorder.class)));
    }
}
