package com.smartcity.weather.client;

import com.smartcity.weather.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WeatherClient {

    private final WebClient webClient;

    public WeatherClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getWeatherFromApi(String city, String apiKey) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", city)
                        .queryParam("appid", apiKey)
                        .queryParam("units", "metric")
                        .build()
                )
                .retrieve()
                .onStatus(
                        status -> status == HttpStatus.UNAUTHORIZED,
                        response -> Mono.error(new ApiKeyInvalidException())
                )
                .onStatus(
                        status -> status == HttpStatus.NOT_FOUND,
                        response -> Mono.error(new CityNotFoundException(city))
                )
                .onStatus(
                        status -> status == HttpStatus.TOO_MANY_REQUESTS,
                        response -> Mono.error(new TooManyRequestsException())
                )
                .onStatus(
                        status -> status.is5xxServerError(),
                        response -> Mono.error(
                                new ProviderException("Error del proveedor de clima")
                        )
                )
                .bodyToMono(String.class);
    }
}
