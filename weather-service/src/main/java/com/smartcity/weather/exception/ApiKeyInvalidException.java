package com.smartcity.weather.exception;

public class ApiKeyInvalidException extends WeatherApiException {

    public ApiKeyInvalidException() {
        super("API Key inválida o no autorizada");
    }
}