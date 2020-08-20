package com.demo.webservice.service;

import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements IWeatherService{

    public String sayHello(String name) {
        return "hello!" + name;
    }

    public String query(String city, String weather) {
        System.out.println("查询天气:" + city + ":" + weather);
        return city + ":" + weather;
    }
}
