package dev.abidino.nami.auth.domain;

import dev.abidino.nami.auth.application.api.LoginDto;
import dev.abidino.nami.auth.application.api.SignUpDto;
import dev.abidino.nami.user.application.api.UserResource;

public interface AuthService {
    Token createToken(LoginDto loginDto);

    UserResource register(SignUpDto signUpDto);
}
