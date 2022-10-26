package io.codefirst.nami.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NamiConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}