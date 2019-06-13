import com.alibaba.fastjson.JSON;
import com.yuxuan.wepay.feigns.FeignBuilder;
import com.yuxuan.wepay.feigns.WepayApi;
import com.yuxuan.wepay.handlers.WepayHandler;
import com.yuxuan.wepay.models.*;
import com.yuxuan.wepay.utils.SignUtil;
import com.yuxuan.wepay.utils.StreamUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author yuxuan
 * @date 2019/6/10
 */
public class TestWepayApi {

    private static String app_id = TestConfig.APP_ID;
    private static String app_mch_id = TestConfig.APP_MCH_ID;
    private static String app_sign_key = TestConfig.APP_SIGN_KEY;
    private static String openid = TestConfig.OPENID;
    private static String notify_url = TestConfig.NOTIFY_URL;
    private static String refund_notify_url = TestConfig.REFUND_NOTIFY_URL;
    private static String certPath = TestConfig.CERT_PATH;

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    // 普通接口http请求api
    private WepayApi wepayApi;
    // 退款接口https请求api
    private WepayApi wepaySslApi;

    @Before
    public void init() throws Exception {
        // 获取普通接口http请求api
        wepayApi = FeignBuilder.builderWepayApi();

        // 读取证书
        File file = new File(certPath);
        InputStream ins = new FileInputStream(file);
        byte[] bytes = StreamUtil.inputStreamToBytes(ins);
        // 获取退款接口https请求api
        wepaySslApi = FeignBuilder.buildWepaySslApi(bytes, app_mch_id);
    }

    /**
     * 查询支付订单
     */
    @Test
    public void testOrderQuery(){
        String tradeNo = "2019061200P518000000000000049545";

        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setAppid(app_id);
        orderQuery.setMch_id(app_mch_id);
        orderQuery.setOut_trade_no(tradeNo);
        orderQuery.setNonce_str(generateNonceStr());
        //请求包体签名
        String sign = SignUtil.createObjectSign(orderQuery, app_sign_key);
        orderQuery.setSign(sign.toUpperCase());
        OrderQueryResult orderQueryResult = wepayApi.payOrderquery(orderQuery);

        boolean check = WepayHandler.checkReturnResult(orderQueryResult, app_sign_key);
        System.out.println(check);
    }

    /**
     * 支付接口
     */
    @Test
    public void testPayUnifiedorder() {
        String body = "支付接口-测试请求";
        Integer total_fee = 1;
        String tradeNo = "2019061200P519000000000000049545";
        // 服务商模式使用参数
        String sub_appid = null;
        String sub_mch_id = null;
        String sub_openid = null;

        Unifiedorder unifiedorder = new Unifiedorder();
        unifiedorder.setAppid(app_id);
        unifiedorder.setMch_id(app_mch_id);
        unifiedorder.setOpenid(openid);
        // 服务商模式使用字段
        unifiedorder.setSub_appid(sub_appid);
        unifiedorder.setSub_mch_id(sub_mch_id);
        unifiedorder.setSub_openid(sub_openid);
        /**
         * 支付附加字段-此处用于支付回调查询原支付流水
         */
        unifiedorder.setAttach(StringUtils.isBlank(sub_appid) ? app_id : sub_appid);
        unifiedorder.setBody(StringUtils.left(body, 32));
        unifiedorder.setNonce_str(generateNonceStr());
        unifiedorder.setNotify_url(notify_url);
        unifiedorder.setOut_trade_no(tradeNo);
        unifiedorder.setTime_start(LocalDateTime.now().format(dateTimeFormatter));
        unifiedorder.setTime_expire(LocalDateTime.now().plusMinutes(30).format(dateTimeFormatter));
        try {
            unifiedorder.setSpbill_create_ip(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        unifiedorder.setTotal_fee(total_fee);
        // JSAPI  NATIVE
        unifiedorder.setTrade_type("JSAPI");
        //请求包体签名
        String sign = SignUtil.createObjectSign(unifiedorder, app_sign_key);
        unifiedorder.setSign(sign.toUpperCase());
        UnifiedorderResult unifiedorderResult = wepayApi.payUnifiedorder(unifiedorder);

        Boolean check = WepayHandler.checkReturnResult(unifiedorderResult, app_sign_key);
        if (check) {
            Map<String, Object> params = WepayHandler.createWepayAppletParams(app_id, unifiedorderResult.getPrepay_id(), app_sign_key);
            System.out.println(JSON.toJSONString(params));
        }
    }

    /**
     * 退款查询
     */
    @Test
    public void testRefundquery(){
        String tradeNo = "2019061200P518000000000000049545";

        RefundQuery refundQuery = new RefundQuery();
        refundQuery.setAppid(app_id);
        refundQuery.setMch_id(app_mch_id);
        refundQuery.setNonce_str(generateNonceStr());
        refundQuery.setOut_trade_no(tradeNo);
        String sign = SignUtil.createObjectSign(refundQuery, app_sign_key);
        refundQuery.setSign(sign);
        RefundQueryResult refundQueryResult = wepayApi.payRefundquery(refundQuery);

        boolean check = WepayHandler.checkReturnResult(refundQueryResult, app_sign_key);
        System.out.println(check);
        System.out.println(JSON.toJSONString(refundQueryResult));
    }

    /**
     * 退款接口
     */
    @Test
    public void testSecapiPayRefund() {
        //创建退款请求对象
        String outTradeNo = "2019061200P518000000000000049545";
        String outRefundNo = "2019061200R518000000000000049545";

        SecapiPayRefund secapiPayRefund = new SecapiPayRefund();
        secapiPayRefund.setAppid(app_id);
        secapiPayRefund.setMch_id(app_mch_id);
        secapiPayRefund.setSub_appid(null);
        secapiPayRefund.setSub_mch_id(null);
        secapiPayRefund.setNonce_str(generateNonceStr());
        secapiPayRefund.setSign_type("MD5");
        secapiPayRefund.setOut_trade_no(outTradeNo);
        secapiPayRefund.setOut_refund_no(outRefundNo);
        //原支付流水金额
        secapiPayRefund.setTotal_fee(1);
        secapiPayRefund.setRefund_fee(1);
        /*if("WEIXIN".equals(wePayModel.getAppType())) {
            // 根据微信文档 在服务商小程序模式接口文档中 没有这个字段 后续需要留意以下是否有效
            secapiPayRefund.setNotify_url(weixinPayConfigEntity.getRefundNotifyUrl());
        }*/
        secapiPayRefund.setNotify_url(refund_notify_url);
        secapiPayRefund.setSign(SignUtil.createObjectSign(secapiPayRefund, app_sign_key));
        SecapiPayRefundResult secapiPayRefundResult = wepaySslApi.secapiPayRefund(secapiPayRefund);

        Boolean check = WepayHandler.checkReturnResult(secapiPayRefundResult, app_sign_key);
        if (check) {
            System.out.println("退款请求成功！");
        }else{
            System.out.println("退款请求失败！");
        }
    }

    /**
     * 创建随机字符串
     *
     * @return
     */
    private String generateNonceStr() {
        return RandomStringUtils.randomAlphabetic(16);
    }
}
