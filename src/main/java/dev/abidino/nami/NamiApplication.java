package dev.abidino.nami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NamiApplication {

    public static final String API_PREFIX = "/api/v1";

    public static void main(String[] args) {
        SpringApplication.run(NamiApplication.class, args);
    }
}
