package com.smartcity.weather.exception;

public class TooManyRequestsException extends WeatherApiException {

    public TooManyRequestsException() {
        super("Límite de peticiones excedido en OpenWeather");
    }
}