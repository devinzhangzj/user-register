package com.devin.emailservice.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("email-public")
                .pathsToMatch("/api/emails/**")
                .build();
    }

    @Bean
    public Info apiInfo() {
        return new Info().title("Email Service API")
                .description("Email Service API document")
                .version("v1.0");
    }
}