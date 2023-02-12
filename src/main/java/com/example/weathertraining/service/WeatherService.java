package com.example.weathertraining.service;

import com.example.weathertraining.model.Weather;

public interface WeatherService {
    public Weather getWeather(String city);
}
