package com.stackroute.resttemplate.service;

import com.stackroute.resttemplate.model.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;


@Service
public class WeatherService {

    //add your api key here
    private static final String API_KEY = "d82970921c7a4110a4490306231511";

    //add the base api url here
    private static final String API_URL = "http://api.weatherapi.com/v1";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // using rest template, get the weather details of a city
    public Weather getWeather(String city) {
        //String apiUrl = API_URL + "/current.json?key=" + API_KEY + "&location=" + city;
        String apiUrl = API_URL + "/forecast.json?key=" + API_KEY + "&city=" + city;
        return restTemplate.getForObject(apiUrl, Weather.class);
    }
}
