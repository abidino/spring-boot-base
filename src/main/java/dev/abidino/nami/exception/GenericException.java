package dev.abidino.nami.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends AbstractException {
    public GenericException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
