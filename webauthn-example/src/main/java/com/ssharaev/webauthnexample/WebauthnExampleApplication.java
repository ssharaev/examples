package com.ssharaev.webauthnexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class WebauthnExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebauthnExampleApplication.class, args);
    }
}
