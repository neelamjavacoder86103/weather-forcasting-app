package com.weather.forecasting.app;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.conf.TimeoutSettings;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import com.github.prominence.openweathermap.api.request.RequestSettings;
import com.github.prominence.openweathermap.api.request.weather.single.SingleLocationCurrentWeatherRequester;
import com.github.prominence.openweathermap.api.request.weather.single.SingleResultCurrentWeatherRequestCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherForcastingAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(WeatherForcastingAppApplication.class, args);

	}

}
