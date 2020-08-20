package com.demo.webservice.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo02 {

    public static void main(String[] args) throws IOException {
        //第一步：创建服务地址，不是WSDL地址
        //URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
        URL url = new URL("http://220.173.61.44:8883/His-service/HisEntranceWs?wsdl");
        //第二步：打开一个通向服务地址的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //第三步：设置参数
        //3.1发送方式设置：POST必须大写
        connection.setRequestMethod("POST");
        //3.2设置数据格式：content-type
        connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
        connection.setRequestProperty("SOAPAction", "http://www.zysoft.com.cn/CallInterface");
        //3.3设置输入输出，因为默认新创建的connection没有读写权限，
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //第四步：组织SOAP数据，发送请求
        /*String soapXML = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:zys=\"http://www.zysoft.com.cn/\">  \n" +
                "  <soapenv:Body> \n" +
                "    <zys:CallInterface> \n" +
                "      <zys:msgHeader><![CDATA[<root><serverName>uploadCaStaffSignature</serverName><format>xml</format><callOperator></callOperator><certificate>oU1QbKbAhBaaB2tzTWcDZg==</certificate></root>]]></zys:msgHeader>  \n" +
                "      <zys:msgBody><![CDATA[<root><staffNo>108209</staffNo><base64>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</base64></root>]]></zys:msgBody> \n" +
                "    </zys:CallInterface> \n" +
                "  </soapenv:Body> \n" +
                "</soapenv:Envelope>";*/
        /*String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:zys=\"http://www.zysoft.com.cn/\">  \n" +
                "  <soapenv:Header/>  \n" +
                "  <soapenv:Body> \n" +
                "    <zys:CallInterface>  \n" +
                "      <zys:msgHeader><![CDATA[<root><serverName>uploadCaStaffSignature</serverName><format>xml</format><callOperator></callOperator><certificate>oU1QbKbAhBaaB2tzTWcDZg==</certificate></root>]]></zys:msgHeader>  \n" +
                "      <zys:msgBody><![CDATA[<root><staffNo>108209</staffNo><base64>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</base64></root>]]></zys:msgBody> \n" +
                "    </zys:CallInterface> \n" +
                "  </soapenv:Body> \n" +
                "</soapenv:Envelope>";*/
        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:zys=\"http://www.zysoft.com.cn/\">  \n" +
                "  <soapenv:Header/>  \n" +
                "  <soapenv:Body> \n" +
                "    <zys:CallInterface> \n" +
                "      <zys:msgHeader><![CDATA[" +
                "\t<root>\n" +
                "\t\t<serverName>uploadCaStaffSignature</serverName>\n" +
                "\t\t<format>xml</format>\n" +
                "\t\t<callOperator></callOperator>\n" +
                "\t\t<certificate>oU1QbKbAhBaaB2tzTWcDZg==</certificate>\n" +
                "\t</root>]]></zys:msgHeader>  \n" +
                "      <zys:msgBody><![CDATA[<root><staffNo>108209</staffNo><base64>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</base64></root>]]></zys:msgBody> \n" +
                "    </zys:CallInterface> \n" +
                "  </soapenv:Body> \n" +
                "</soapenv:Envelope>\n";

        soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:zys=\"http://www.zysoft.com.cn/\">\n" +
                "  <soapenv:Header/>\n" +
                "  <soapenv:Body>\n" +
                "    <zys:CallInterface>\n" +
                "      <zys:msgHeader><![CDATA[    <root>\n" +
                "\t\t<serverName>uploadCaStaffSignature</serverName>\n" +
                "\t\t<format>xml</format>\n" +
                "\t\t<callOperator></callOperator>\n" +
                "\t\t<certificate>oU1QbKbAhBaaB2tzTWcDZg==</certificate>\n" +
                "\t</root>]]></zys:msgHeader>\n" +
                "      <zys:msgBody><![CDATA[<root><staffNo>108209</staffNo><base64>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</base64></root>]]></zys:msgBody>\n" +
                "    </zys:CallInterface>\n" +
                "  </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());

        //第五步：接收服务端响应，打印（xml格式数据）
        int responseCode = connection.getResponseCode();
        if(200 == responseCode){//表示服务端响应成功
            InputStream is = null;
            InputStreamReader isr = null;
            BufferedReader br = null;
            StringBuilder sb = null;
            try {
                is = connection.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                sb = new StringBuilder();
                String temp = null;
                while(null != (temp = br.readLine())){
                    sb.append(temp);
                }
                System.out.println(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                br.close();
                isr.close();
                is.close();
            }
        }

        os.close();
    }

    public static String getXML(String phoneNum) {
        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                +"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                +"<soap:Body>"
                +"<getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">"
                +"<mobileCode>"+phoneNum+"</mobileCode>"
                +"<userID></userID>"
                +"</getMobileCodeInfo>"
                +"</soap:Body>"
                +"</soap:Envelope>";
        return soapXML;
    }

}