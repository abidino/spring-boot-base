package dev.abidino.nami.auth.application.api;

import dev.abidino.nami.NamiApplication;
import dev.abidino.nami.auth.application.config.CookieUtil;
import dev.abidino.nami.auth.domain.AuthService;
import dev.abidino.nami.auth.domain.Token;
import dev.abidino.nami.user.application.api.UserResource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(NamiApplication.API_PREFIX + "/auth")
record AuthController(AuthService authService) {

    @PostMapping(value = "/login")
    void login(@RequestBody @Valid LoginDto loginDto, HttpServletResponse response) {
        Token token = authService.createToken(loginDto);
        Cookie cookie = CookieUtil.generateCookie(CookieUtil.TOKEN_COOKIE_NAME, token.getValue());
        response.addCookie(cookie);
    }

    @PostMapping(value = "/logout")
    void logout(HttpServletResponse response) {
        Cookie cookie = CookieUtil.generateCookie(CookieUtil.TOKEN_COOKIE_NAME, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @PostMapping("/register")
    UserResource save(@RequestBody @Valid SignUpDto signUpDto) {
        return authService.register(signUpDto);
    }
}
