package com.demo.webservice;


import com.demo.webservice.service.WeatherServiceImpl;

import javax.xml.ws.Endpoint;

public class Publish {

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/weatherService",new WeatherServiceImpl());
        System.out.println("发布成功");

    }
}
