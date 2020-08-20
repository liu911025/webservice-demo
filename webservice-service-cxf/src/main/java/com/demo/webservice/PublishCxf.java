package com.demo.webservice;


import com.demo.webservice.service.IWeatherService;
import com.demo.webservice.service.WeatherServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class PublishCxf {

    public static void main(String[] args) {

        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress("http://localhost:8080/weatherService");
        factoryBean.setServiceClass(IWeatherService.class);
        factoryBean.setServiceBean(new WeatherServiceImpl());
        factoryBean.create();
        System.out.println("发布服务成功");

    }
}
