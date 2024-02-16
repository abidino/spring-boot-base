package dev.abidino.nami.auth.application.config;

import dev.abidino.nami.auth.domain.UserExternalApiClient;
import dev.abidino.nami.user.application.api.UserResource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public class UserDetailService implements UserDetailsService {

    private final UserExternalApiClient userExternalApiClient;

    public UserDetailService(UserExternalApiClient userExternalApiClient) {
        this.userExternalApiClient = userExternalApiClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserResource userResource = userExternalApiClient.findByUsername(username);
        return new User(userResource.username(), userResource.password(), List.of(new SimpleGrantedAuthority(userResource.role().name())));
    }
}

