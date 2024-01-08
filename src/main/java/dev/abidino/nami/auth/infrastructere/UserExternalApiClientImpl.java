package dev.abidino.nami.auth.infrastructere;

import dev.abidino.nami.auth.domain.UserExternalApiClient;
import dev.abidino.nami.user.application.api.UserClient;
import dev.abidino.nami.user.application.api.UserDto;
import dev.abidino.nami.user.application.api.UserResource;
import org.springframework.stereotype.Service;

@Service
public class UserExternalApiClientImpl implements UserExternalApiClient {
    private final UserClient userClient;

    public UserExternalApiClientImpl(UserClient userClient) {
        this.userClient = userClient;
    }


    public UserResource save(UserDto userDto) {
        return userClient.save(userDto);
    }

    public UserResource findByUsername(String username) {
        return userClient.findByUsername(username);
    }
}
