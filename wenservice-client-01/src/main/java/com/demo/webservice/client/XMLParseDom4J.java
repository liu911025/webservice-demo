package com.demo.webservice.client;

import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.util.Iterator;

public class XMLParseDom4J {

    static String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body><zys:CallInterfaceResponse xmlns:zys=\"http://www.zysoft.com.cn/\">  <zys:payload>&lt;?xml version=\"1.0\" encoding=\"utf-8\"?&gt;&lt;root&gt;&lt;code&gt;00000&lt;/code&gt;&lt;returnContents&gt;&lt;/returnContents&gt;&lt;message&gt;&lt;/message&gt;&lt;/root&gt;</zys:payload></zys:CallInterfaceResponse></soapenv:Body></soapenv:Envelope>";

    public static void main(String[] args) {
        try {
            org.dom4j.Document doc =  DocumentHelper.parseText(xmlStr);
            org.dom4j.Element message = doc.getRootElement();
            System.out.println("根节点" + message.getName());
            Iterator elements = message.elementIterator();
            while(elements.hasNext()){
                org.dom4j.Element element = (org.dom4j.Element)elements.next();
                String name = element.getName();
                String value = element.getText();
                System.out.println("节点:" + name + "--> value:" + value);
                if ("code".equals(name) && "00000".equals(value)) {

                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
