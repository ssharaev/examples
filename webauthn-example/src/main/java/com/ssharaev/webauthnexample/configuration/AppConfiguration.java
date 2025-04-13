package com.ssharaev.webauthnexample.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.web.webauthn.jackson.WebauthnJackson2Module;

@Configuration
public class AppConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .modules(new WebauthnJackson2Module())
                .failOnUnknownProperties(false)
                .build();
    }
}
