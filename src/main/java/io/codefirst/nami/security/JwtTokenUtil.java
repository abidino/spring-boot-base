package io.codefirst.nami.security;

import io.codefirst.nami.auth.TokenResource;
import io.codefirst.nami.exception.ErrorMessageType;
import io.codefirst.nami.exception.GenericException;
import io.codefirst.nami.user.User;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public interface JwtTokenUtil {

    String SECRET_KEY_ALGORITHM = "HmacSHA512";
    static TokenResource generateToken(User user) {
        String token = user.getUsername() + "&" + calculateHmac(user.getUsername());
        return new TokenResource(token, null);
    }

    static String calculateHmac(String username) {
        byte[] secretBytes = SecurityConstant.SECRET.getBytes(StandardCharsets.UTF_8);
        byte[] valueBytes = username.getBytes(StandardCharsets.UTF_8);

        try {
            Mac mac = Mac.getInstance(SECRET_KEY_ALGORITHM);
            SecretKeySpec sec = new SecretKeySpec(secretBytes, SECRET_KEY_ALGORITHM);
            mac.init(sec);
            byte[] hmacBytes = mac.doFinal(valueBytes);
            return Base64.getEncoder().encodeToString(hmacBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new GenericException(ErrorMessageType.GENERIC_ERROR.getMessage());
        }
    }

    static Cookie generateCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }
}