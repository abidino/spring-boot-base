package dev.abidino.nami.auth.domain;

import dev.abidino.nami.auth.application.api.LoginDto;
import dev.abidino.nami.auth.application.api.SignUpDto;
import dev.abidino.nami.exception.BadRequestException;
import dev.abidino.nami.exception.ErrorMessageType;
import dev.abidino.nami.user.application.api.UserDto;
import dev.abidino.nami.user.application.api.UserResource;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl implements AuthService {

    private final UserExternalApiClient userExternalApiClient;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserExternalApiClient userExternalApiClient, PasswordEncoder passwordEncoder) {
        this.userExternalApiClient = userExternalApiClient;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Token createToken(LoginDto loginDto) {
        UserResource userResource = userExternalApiClient.findByUsername(loginDto.username());
        if (passwordEncoder.matches(loginDto.password(), userResource.password())) {
            Token token = new Token();
            token.initialize(loginDto.username());
            return token;
        }
        throw new BadRequestException(ErrorMessageType.USERNAME_AND_PASSWORD_NOT_MATCH.getMessage());
    }

    @Override
    public UserResource register(SignUpDto signUpDto) {
        String encodedPassword = passwordEncoder.encode(signUpDto.password());
        return userExternalApiClient.save(new UserDto(signUpDto.username(), encodedPassword, signUpDto.role()));
    }
}
