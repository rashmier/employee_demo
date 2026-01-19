package com.rashmier.employee.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI employeeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management API")
                        .description("RESTful API for managing employees")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Employee API Support")
                                .email("rashmier@demo.example.com")));
    }
}