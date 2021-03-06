package com.aimbra.sied.domain.sied.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AulaNotAuthorizedException extends RuntimeException {
    private static final long serialVersionUID = 6593557148865469323L;

    public AulaNotAuthorizedException(String message) {
        super(message);
    }

    public AulaNotAuthorizedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
