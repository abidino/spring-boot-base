package dev.abidino.nami.auth.domain;

import dev.abidino.nami.user.application.api.UserDto;
import dev.abidino.nami.user.application.api.UserResource;

public interface UserExternalApiClient {
    UserResource save(UserDto userDto);

    UserResource findByUsername(String username);
}
