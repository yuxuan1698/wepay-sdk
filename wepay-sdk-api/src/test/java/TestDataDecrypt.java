import com.alibaba.fastjson.JSON;
import com.yuxuan.wepay.models.RefundNotifyReqInfo;
import com.yuxuan.wepay.utils.AESUtil;
import com.yuxuan.wepay.utils.XmlUtil;
import org.junit.Test;

/**
 * @author yuxuan
 * @date 2019/6/12
 */
public class TestDataDecrypt {

    /**
     * 微信退款加密字段解密
     */
    @Test
    public void testDecryptRefundReqInfo(){
        String A = "ejJITq8urV1bcLV4id8hrqMFJZtMPmq5uac0g1/Sw+17zTP8EgaLKZVbIthnZrOykq8EFa1A9EL9DfjrqUfLwNAO2R0wvgWFpeLfKPCr8MoaFTHV+/WPC+J3fC5SQ72/EQ8WMKwCiwvtgS/KvqubfyITjtq4L66R4wbF0Ds/9E+QHa1mYycvXLEjQjewLqpd5/RjCCRM4+sVL1nCF4HoEl22MbiJrjUToECoPMuW3WaClWIVX1q77BZNhcFO9zUtjXurXLj7iFsBY8VLJaTQ4hXOqbwKBZp7IW1Bgu+XNoqONpBuKvxsp61tqPL8OE8S/BVoqHIzpdl8gJq7/gBz3eM2wDD+k+BkNZ7w6U1fmnSBEESn77pthj8AlOF5ydy/lYxCmymt7PswVFE3vpi6nZgUQZyOBeDiAY7eUNkdxxGQDVpZ0mBmWvwDEwL2RGVKSTnVf8aHofmpGfeXQQn+yscZv08WL/AOybSazZcaFHOZCD33LJ/TA14oErEedXMnoTBbC94GgJpmbpF1WiYfxofdXFhjMoR3ufXDRaigJmhmifPlc1PD7yZXMl+BAfdWaRpQBGc6ZLiTfN5fmJevA12Xq3Qi12K63mTB4Fy6DxiamlpLX5/8V/G2FaBaGGYaLJkhhejrwuhWdlkAFTwFyQfYg8UOj3Ei5fI84SzdzOPzObSVVDFcJg+9VAjnWEtF1jFnTaLjE6i1ajTmUbcRLtT6pLVNKngbqhB82hec3D/++teDNwO4kw8LGhc2Z9ObRVBqQrjXiYZBUeKpzzO39ureWfFi8HpV8nd5BMAmaYgxznWM8R5cJjpwGa67vCVAFPdFPmy+hMa/pB9jXPa2ey7kxRyuC78ObIK806mN9SDEENAxcPIQwvtMgDNazJaiPZemKCTpMRd3DE1oOuEosdo5WCa2YMoqz6wOwX4GdyXS8+PbRo2zRq1cNJZRbCRGb8Tc8E2RlbxbsXtrLC4yD6NNh/+Do6jbSwHMtRrtLgpJwATdj5uYORMfsWCSKVV7zPYm7giB+jYI0lAacLzkU8jKagFltrbi1WWYhif8lpiglLL8um78z0dOZF4KXiqV2xPSZ84oQfHEeKsLAIBFUA==";
        String K = TestConfig.APP_SIGN_KEY;
        String B = AESUtil.decryptData(A, K);
        System.out.println(B);

        RefundNotifyReqInfo reqInfo = XmlUtil.convertToObject(B, RefundNotifyReqInfo.class);
        System.out.println(JSON.toJSONString(reqInfo));
    }
}
