package com.aimbra.sied.domain.sied.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AtividadeNotAuthorizedException extends RuntimeException {
    private static final long serialVersionUID = 6593557148865469323L;

    public AtividadeNotAuthorizedException(String message) {
        super(message);
    }

    public AtividadeNotAuthorizedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
