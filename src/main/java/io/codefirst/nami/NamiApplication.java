package io.codefirst.nami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NamiApplication {

    public static final String API_PREFIX = "api";

    public static void main(String[] args) {
        SpringApplication.run(NamiApplication.class, args);
    }
}
