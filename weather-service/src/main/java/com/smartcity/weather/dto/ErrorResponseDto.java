package com.smartcity.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "Respuesta de error estándar")
public class ErrorResponseDto {

    @Schema(example = "Ciudad no encontrada: asdf")
    private String message;

    @Schema(example = "404")
    private int status;

    @Schema(example = "2025-01-03T20:30:00Z")
    private Instant timestamp;

    public ErrorResponseDto(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = Instant.now();
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
