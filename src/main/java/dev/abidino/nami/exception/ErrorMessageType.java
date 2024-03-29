package dev.abidino.nami.exception;

public enum ErrorMessageType {

    UNAUTHORIZED("Lütfen giriş yapınız."),
    USERNAME_NOT_FOUND("Username bulunamadı."),
    USERNAME_ALREADY_EXIST("Kullanıcı adı daha önceden alınmış."),
    USERNAME_AND_PASSWORD_NOT_MATCH("Kullanıcı adı veya parola doğru değil."),
    ERROR_MAIL_SEND("Mail gönderilirken hata meydana geldi."),
    EXPIRE_TOKEN("Oturumunuzun süresi dolmuş, lütfen tekrar giriş yapınız."),
    GENERIC_ERROR("Sistem kaynakli bir sorun olustu. Lutfen daha sonra tekrar deneyiniz."),
    FORBIDDEN("Yetkiniz yoktur.");
    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
