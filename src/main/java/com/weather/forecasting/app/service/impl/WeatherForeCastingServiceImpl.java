package com.weather.forecasting.app.service.impl;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import com.weather.forecasting.app.common.LRUCache;
import com.weather.forecasting.app.common.WeatherInfo;
import com.weather.forecasting.app.common.exception.InvalidZipCodeException;
import com.weather.forecasting.app.service.WeatherForecastingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
@Slf4j
public class WeatherForeCastingServiceImpl implements WeatherForecastingService {


    @Value("${weather.api_key:e61217dde0270480a425b7e715543cc4}")
    private String apiKey;

    private static final LRUCache lrucache = new LRUCache(1000);
    @Override
    public WeatherInfo fetchWeatherDetails(String zipCode) {
        log.info("Zip code : {}",zipCode);
        WeatherInfo weatherInfo = null;
        Weather weather = null;
        if (lrucache.containsKey(zipCode)){
            weatherInfo = lrucache.get(zipCode);
            weatherInfo.setDataFromCache(Boolean.TRUE);

            int timeDeff = LocalDateTime.now().atZone(ZoneOffset.systemDefault()).getMinute()-weatherInfo.getCalculationTime().atZone(ZoneOffset.systemDefault()).getMinute();
            log.info("time Difference :{}",timeDeff);
          if(timeDeff >30){
              weather = getWeather(zipCode).orElseThrow(()->new InvalidZipCodeException("Invalid ZipCode"+zipCode));
              weatherInfo = getWeatherInfo(weather,zipCode);
              weatherInfo.setDataFromCache(Boolean.FALSE);
              lrucache.set(zipCode,weatherInfo);
          }
        }else{
            weather = getWeather(zipCode).orElseThrow(()->new InvalidZipCodeException("Invalid ZipCode"+zipCode));
            weatherInfo = getWeatherInfo(weather,zipCode);
            weatherInfo.setDataFromCache(Boolean.FALSE);
            lrucache.set(zipCode,weatherInfo);

        }
        return weatherInfo;
    }

    private Optional<Weather> getWeather(String zipCode){
        log.info("api key :{}",apiKey);
        OpenWeatherMapClient openWeatherMapClient = new OpenWeatherMapClient(apiKey);
        Weather weather = openWeatherMapClient.currentWeather()
                .single()
                .byZipCodeInUSA("10002")
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.IMPERIAL)
                .retrieve()
                .asJava();
        log.info("weather : {}",weather);
        return Optional.of(weather);
    }

    private WeatherInfo getWeatherInfo(Weather weather,String zipCode){
        return WeatherInfo.builder()
                .weatherState(weather.getWeatherState())
                .atmosphericPressure(weather.getAtmosphericPressure())
                .calculationTime(weather.getCalculationTime())
                .zipcode(zipCode)
                .location(weather.getLocation())
                .temperature(weather.getTemperature())
                .rain(weather.getRain())
                .clouds(weather.getClouds())
                .wind(weather.getWind())
                .humidity(weather.getHumidity())
                .build();
    }
}
