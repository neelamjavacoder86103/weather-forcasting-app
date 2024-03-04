package com.weather.forecasting.app.controller;

import com.weather.forecasting.app.common.WeatherInfo;
import com.weather.forecasting.app.service.WeatherForecastingService;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherForecastingService weatherForecastingService;

    @GetMapping("/weather/{zipCode}")
    public ResponseEntity<WeatherInfo> fetchWeatherInfo(@PathVariable("zipCode") @NonNull String zipCode){
          return ResponseEntity.status(HttpStatus.ACCEPTED).body(weatherForecastingService.fetchWeatherDetails(zipCode));
    }

}
