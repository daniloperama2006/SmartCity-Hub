package com.smartcity.weather.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI weatherServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SmartCity Hub - Weather Service API")
                        .description("Microservicio para consultar el clima por ciudad usando OpenWeather")
                        .version("v1.0.0"));
    }
}
