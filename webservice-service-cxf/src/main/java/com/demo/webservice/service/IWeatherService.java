package com.demo.webservice.service;

import javax.jws.WebService;

@WebService
public interface IWeatherService {

    String sayHello(String name);

    String query(String city, String weather);

}
