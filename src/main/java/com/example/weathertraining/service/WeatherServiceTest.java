package com.example.weathertraining.service;

import com.example.weathertraining.model.Weather;
import com.example.weathertraining.model.WeatherMain;
import com.example.weathertraining.model.WeatherWind;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Profile("!production")
public class WeatherServiceTest implements WeatherService{
    @Override
    public Weather getWeather(String city) {
        Weather weather = new Weather();

        WeatherMain weatherMain = new WeatherMain();
        weatherMain.setTemp(BigDecimal.ONE);
        weatherMain.setHumidity(BigDecimal.ONE);

        WeatherWind weatherWind = new WeatherWind();
        weatherWind.setSpeed(BigDecimal.ONE);
        weatherWind.setDeg(1);

        weather.setMain(weatherMain);
        weather.setWind(weatherWind);

        return weather;
    }
}
