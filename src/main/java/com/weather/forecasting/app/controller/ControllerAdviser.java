package com.weather.forecasting.app.controller;

import com.weather.forecasting.app.common.ErrorResponse;
import com.weather.forecasting.app.common.exception.InvalidZipCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviser {

    @ExceptionHandler(InvalidZipCodeException.class)
    public ErrorResponse handleException(InvalidZipCodeException ex){
        return ErrorResponse.builder().errorMassage(ex.getMessage()).errorCode(HttpStatus.NOT_FOUND.name()).build();
    }
}
