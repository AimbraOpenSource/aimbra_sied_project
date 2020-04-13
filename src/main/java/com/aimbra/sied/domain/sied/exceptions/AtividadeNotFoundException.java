package com.aimbra.sied.domain.sied.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AtividadeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 6593557148865469323L;

    public AtividadeNotFoundException(String message) {
        super(message);
    }

    public AtividadeNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
