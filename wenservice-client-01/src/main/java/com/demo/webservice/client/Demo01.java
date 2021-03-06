package com.demo.webservice.client;

import org.apache.cxf.common.i18n.UncheckedException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class Demo01 {

    public static void main(String[] args) throws MalformedURLException {
        Object[] params = new Object[2];
        String msgHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<root>" +
                "<serverName>uploadCaStaffSignature</serverName>" +
                "<format>xml</format>" +
                "<callOperator></callOperator>" +
                "<certificate>566KAxZHKVIdtr4XfGsFig==</certificate>" +
                "</root>";
        String msgBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<tradeIn>" +
                "    <staffNo>T</staffNo>" +
                "    <base64>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</base64>\n" +
                "</tradeIn>";
        params[0] = msgHeader;
        params[1] = msgBody;
        try {
            Object res = cxfWsCall("http://220.173.61.44:8883/His-service/HisEntranceWs?wsdl","CallInterface", msgHeader, msgBody);
            if (res instanceof Object[]) {
                Object[] arr = (Object[]) res;
                for (Object obj : arr) {
                    System.out.println(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static Object cxfWsCall(String wsUrl,String methodName,Object... paramObj) throws Exception {
        Client client = null;
        Object[] res = null;
        try{
            //CXF调用webservice客户端   第一种：
            //生成动态客户端
            JaxWsDynamicClientFactory dynamicClient = JaxWsDynamicClientFactory.newInstance();
            client = dynamicClient.createClient(wsUrl);
            //设置超时时间
            HTTPConduit http = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setConnectionTimeout(5000);  //连接超时
            httpClientPolicy.setAllowChunking(false);    //取消块编码
            httpClientPolicy.setReceiveTimeout(20000);     //响应超时
            http.setClient(httpClientPolicy);
            //调用，并返回结果
            res = client.invoke(methodName, paramObj);
        } catch(UncheckedException uncheckEx) {
            throw new SocketTimeoutException("获取服务【"+wsUrl+"】方法【"+methodName+"】失败："+uncheckEx.getMessage());
        } catch (Exception e) {
            throw new SocketTimeoutException("调用webservices【"+wsUrl+"】,方法名称【"+methodName+"】失败："+e.getMessage());
        } finally {
            client.destroy();
        }
        return res;
    }
}
