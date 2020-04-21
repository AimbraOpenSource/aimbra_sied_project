package com.aimbra.sied.domain.sied.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 6593557148865469323L;

    public AlunoNotFoundException(String message) {
        super(message);
    }

    public AlunoNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
