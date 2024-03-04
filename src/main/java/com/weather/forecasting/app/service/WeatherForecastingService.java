package com.weather.forecasting.app.service;

import com.weather.forecasting.app.common.WeatherInfo;

public interface WeatherForecastingService {
    public WeatherInfo fetchWeatherDetails(String zipcode);
}
