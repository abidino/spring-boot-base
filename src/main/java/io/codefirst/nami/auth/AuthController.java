package io.codefirst.nami.auth;

import io.codefirst.nami.NamiApplication;
import io.codefirst.nami.security.JwtTokenUtil;
import io.codefirst.nami.security.SecurityConstant;
import io.codefirst.nami.user.UserDto;
import io.codefirst.nami.user.UserResource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(NamiApplication.API_PREFIX + "/auth")
record AuthController(AuthClient authClient) {

    @PostMapping(value = "/login")
    void login(@RequestBody @Valid UserDto dto, HttpServletResponse response) {
        TokenResource token = authClient.getToken(dto);
        Cookie cookie = JwtTokenUtil.generateCookie(SecurityConstant.TOKEN_COOKIE_NAME, token.token());
        response.addCookie(cookie);
    }

    @PostMapping(value = "/logout")
    void logout(HttpServletResponse response) {
        Cookie cookie = JwtTokenUtil.generateCookie(SecurityConstant.TOKEN_COOKIE_NAME, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @PostMapping("/register")
    UserResource save(@RequestBody @Valid UserDto userDto) {
        return authClient.register(userDto);
    }
}
