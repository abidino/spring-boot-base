package dev.abidino.nami.auth.application.config;

import jakarta.servlet.http.Cookie;

public class CookieUtil {
    private CookieUtil() {
    }

    public static final String TOKEN_COOKIE_NAME = "token";

    public static Cookie generateCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }
}