package com.smartcity.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class WeatherResponseDto {

    @Schema(example = "Bogotá")
    private String city;

    @Schema(example = "18.5")
    private double temperature;

    @Schema(example = "72")
    private int humidity;

    @Schema(example = "cielo parcialmente nublado")
    private String description;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
