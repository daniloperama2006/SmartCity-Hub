package com.smartcity.weather.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcity.weather.client.WeatherClient;
import com.smartcity.weather.dto.WeatherResponseDto;
import com.smartcity.weather.exception.ProviderException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;
    private final ObjectMapper objectMapper;
    private final String apiKey;

    public WeatherService(
            WeatherClient weatherClient,
            ObjectMapper objectMapper,
            @Value("${openweather.api.key}") String apiKey) {

        this.weatherClient = weatherClient;
        this.objectMapper = objectMapper;
        this.apiKey = apiKey;
    }

    public Mono<WeatherResponseDto> getWeatherByCity(String city) {
        return weatherClient.getWeatherFromApi(city, apiKey)
                .map(this::mapToDto)
                .onErrorMap(e -> {
                    if (e instanceof ProviderException) {
                        return e;
                    }
                    return new RuntimeException("Error al obtener el clima", e);
                });
    }


    private WeatherResponseDto mapToDto(String response) {
        try {
            JsonNode json = objectMapper.readTree(response);

            WeatherResponseDto dto = new WeatherResponseDto();
            dto.setCity(json.get("name").asText());
            dto.setTemperature(json.get("main").get("temp").asDouble());
            dto.setHumidity(json.get("main").get("humidity").asInt());
            dto.setDescription(json.get("weather").get(0).get("description").asText());

            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Error al parsear respuesta del clima", e);
        }
    }
}
