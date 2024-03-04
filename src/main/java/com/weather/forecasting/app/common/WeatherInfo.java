package com.weather.forecasting.app.common;

import com.github.prominence.openweathermap.api.model.*;
import com.github.prominence.openweathermap.api.model.weather.Location;
import com.github.prominence.openweathermap.api.model.weather.Rain;
import com.github.prominence.openweathermap.api.model.weather.Snow;
import com.github.prominence.openweathermap.api.model.weather.Wind;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
public class WeatherInfo {
    private String zipcode;
    private LocalDateTime calculationTime;
    private WeatherState weatherState;
    private Temperature temperature;
    private AtmosphericPressure atmosphericPressure;
    private Humidity humidity;
    private Wind wind;
    private Rain rain;
    private Snow snow;
    private Clouds clouds;
    private Location location;
    private boolean isDataFromCache;

}
