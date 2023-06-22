package com.tutoring.review.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Adjust the allowed origin(s) accordingly
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Adjust the allowed HTTP methods accordingly
                .allowedHeaders("*"); // Adjust the allowed headers accordingly
    }
}
