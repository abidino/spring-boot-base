package dev.abidino.nami.auth.domain;

import dev.abidino.nami.exception.ErrorMessageType;
import dev.abidino.nami.exception.GenericException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Token {

    private static final String SECRET = "!44VeRy$3cUr3S3creT";
    private static final String SECRET_KEY_ALGORITHM = "HmacSHA512";
    private String value;

    void initialize(String username) {
        this.value = username + "&" + calculateHmac(username);
    }

    public String getValue() {
        return value;
    }

    public static String calculateHmac(String username) {
        byte[] secretBytes = SECRET.getBytes(StandardCharsets.UTF_8);
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
}
