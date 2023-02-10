package com.example.weathertraining.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.weathertraining.model.Weather;

@Service
public class WeatherService {

    private static String WEATHER_SERVICE_URL = "api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid=bcb884fa1579d203921d374b238e7a3e";
    @Autowired
    private RestTemplate restTemplate;


    public Weather getWeather(String city){
        return restTemplate.exchange(
                WEATHER_SERVICE_URL,
                HttpMethod.GET,
                new HttpEntity<>(HttpHeaders.EMPTY),
                Weather.class, city
        ).getBody();
    }

}
