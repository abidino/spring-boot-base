package dev.abidino.nami.auth.application.config;

import dev.abidino.nami.auth.domain.AuthService;
import dev.abidino.nami.auth.domain.AuthServiceImpl;
import dev.abidino.nami.auth.domain.UserExternalApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthService authService(UserExternalApiClient userExternalApiClient, PasswordEncoder passwordEncoder) {
        return new AuthServiceImpl(userExternalApiClient, passwordEncoder);
    }

    @Bean
    public UserDetailsService userDetailsService(UserExternalApiClient userExternalApiClient) {
        return new UserDetailService(userExternalApiClient);
    }
}
