package com.smartcity.weatherservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcity.weather.client.WeatherClient;
import com.smartcity.weather.dto.WeatherResponseDto;
import com.smartcity.weather.exception.ProviderException;
import com.smartcity.weather.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

    @Mock
    private WeatherClient weatherClient;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private WeatherService weatherService;

    private static final String API_RESPONSE = """
        {
          "name": "Bogotá",
          "main": {
            "temp": 18.5,
            "humidity": 72
          },
          "weather": [
            { "description": "cielo parcialmente nublado" }
          ]
        }
        """;

    @Before
    public void setUp() {
        // apiKey viene por @Value → Mockito lo deja en null, pero NO afecta el test
    }

    @Test
    public void shouldReturnWeatherWhenCityIsValid() {

        when(weatherClient.getWeatherFromApi(anyString(), anyString()))
                .thenReturn(Mono.just(API_RESPONSE));

        WeatherResponseDto result =
                weatherService.getWeatherByCity("Bogotá").block();

        assertEquals("Bogotá", result.getCity());
        assertEquals(18.5, result.getTemperature(), 0.1);
        assertEquals(72, result.getHumidity());
        assertEquals("cielo parcialmente nublado", result.getDescription());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhenClientFails() {

        when(weatherClient.getWeatherFromApi(anyString(), anyString()))
                .thenReturn(Mono.error(new ProviderException("Proveedor caído")));

        weatherService.getWeatherByCity("Bogotá").block();
    }
}
