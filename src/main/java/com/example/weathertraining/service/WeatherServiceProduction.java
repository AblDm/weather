package com.example.weathertraining.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.weathertraining.model.Weather;

@Service
@Profile("production")
public class WeatherServiceProduction implements WeatherService{

    private static String WEATHER_SERVICE_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid=bcb884fa1579d203921d374b238e7a3e";
    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(WeatherServiceProduction.class);


    public Weather getWeather(String city){
        logger.debug("Requesting weather for city: {}", city);
        Weather weather = restTemplate.exchange(
                WEATHER_SERVICE_URL,
                HttpMethod.GET,
                new HttpEntity<>(HttpHeaders.EMPTY),
                Weather.class, city
        ).getBody();
        logger.debug("The weather for {} is {}", city, weather);
        return weather;
    }

}
