package dev.abidino.nami.user.application.config;

import dev.abidino.nami.user.domain.UserRepository;
import dev.abidino.nami.user.domain.UserService;
import dev.abidino.nami.user.domain.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
