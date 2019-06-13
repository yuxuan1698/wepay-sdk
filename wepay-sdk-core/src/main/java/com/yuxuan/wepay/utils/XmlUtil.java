package com.yuxuan.wepay.utils;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Xml转换工具类
 *
 * @author yuxuan
 * @date 2019/6/10
 */
@UtilityClass
public class XmlUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtil.class);

    /**
     * 对象转换xml数据
     *
     * @param t
     * @param <T>
     * @return
     * @throws JAXBException
     * @throws UnsupportedEncodingException
     */
    public static <T> String convertToXml(T t) {
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            Marshaller marshaller = context.createMarshaller();
            //是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //是否省略xml头信息
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            marshaller.marshal(t, os);
            return new String(os.toByteArray(), "UTF-8");
        } catch (UnsupportedEncodingException | JAXBException e) {
            LOGGER.error("转换出错", e);
        }
        return "";
    }

    /**
     * 简单Map to XML
     *
     * @return
     */
    public static String convertMapToXML(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            String k = stringStringEntry.getKey();
            String v = stringStringEntry.getValue();
            sb.append(v == null ? "" : ("<" + k + ">" + v + "</" + k + ">"));
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 转换XML数据为对象
     *
     * @param xmlContent
     * @param classz
     * @param <T>
     * @return
     */
    public static <T> T convertToObject(String xmlContent, Class<T> classz) {
        T obj = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(classz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Reader reader = new StringReader(xmlContent);
            obj = (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            LOGGER.error("转换出错", e);
        }
        return obj;
    }

    /**
     * 安全转换 禁止外部实体注入
     * 使用原因：XML外部实体注入漏洞
     *
     * @param xmlContent
     * @param classz
     * @param <T>
     * @return
     */
    public static <T> T convertToObjectSafe(String xmlContent, Class<T> classz) {
        T obj = null;
        try {
            JAXBContext context = JAXBContext.newInstance(classz);

            XMLInputFactory xif = XMLInputFactory.newFactory();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, true);
            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlContent));

            Unmarshaller unmarshaller = context.createUnmarshaller();
            obj = (T) unmarshaller.unmarshal(xsr);
        } catch (JAXBException | XMLStreamException e) {
            LOGGER.error("转换出错", e);
        }
        return obj;
    }
}
