package com.weather.forecasting.app.common.exception;

public class InvalidZipCodeException extends RuntimeException{
    private String errorMassage;
    public InvalidZipCodeException(String errorMassage){
        super();
        this.errorMassage=errorMassage;
    }
}
