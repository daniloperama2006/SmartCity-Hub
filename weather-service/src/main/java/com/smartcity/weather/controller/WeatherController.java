package com.smartcity.weather.controller;

import com.smartcity.weather.dto.WeatherResponseDto;
import com.smartcity.weather.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/weather")
@Validated
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Operation(
            summary = "Consultar clima por ciudad",
            description = "Obtiene la información climática actual de una ciudad específica"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Clima obtenido correctamente"),
            @ApiResponse(responseCode = "400", description = "Parámetro de ciudad inválido"),
            @ApiResponse(responseCode = "404", description = "Ciudad no encontrada"),
            @ApiResponse(responseCode = "401", description = "API Key inválida"),
            @ApiResponse(responseCode = "429", description = "Límite de peticiones excedido"),
            @ApiResponse(responseCode = "502", description = "Error del proveedor externo")
    })
    @GetMapping("/{city}")
    public Mono<WeatherResponseDto> getWeatherByCity(
            @Parameter(
                    description = "Nombre de la ciudad a consultar",
                    example = "Bogotá"
            )
            @PathVariable
            @NotBlank(message = "La ciudad no puede estar vacía")
            @Size(min = 2, max = 50, message = "La ciudad debe tener entre 2 y 50 caracteres")
            @Pattern(
                    regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$",
                    message = "La ciudad solo puede contener letras y espacios"
            )
            String city
    ) {
        return weatherService.getWeatherByCity(city);
    }
}
