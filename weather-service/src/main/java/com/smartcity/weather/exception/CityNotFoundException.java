package com.smartcity.weather.exception;

public class CityNotFoundException extends WeatherApiException {

    public CityNotFoundException(String city) {
        super("Ciudad no encontrada: " + city);
    }
}