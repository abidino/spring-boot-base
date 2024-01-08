package dev.abidino.nami.auth.application.config;

import dev.abidino.nami.auth.domain.UserExternalApiClient;
import dev.abidino.nami.user.application.api.UserResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserExternalApiClient userExternalApiClient;

    public UserDetailService(UserExternalApiClient userExternalApiClient) {
        this.userExternalApiClient = userExternalApiClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserResource userResource = userExternalApiClient.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(userResource.username(), userResource.password(), Collections.emptyList());
    }
}

