package com.aimbra.sied.domain.sied.utils;

import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

public class Utils {
    public static String encodePassoword(String value) {
        if (value == null || value.isEmpty()) {
            throw new BadRequestException("Não é possível encriptar a senha. O Campo de senha esta vazio");
        }
        BCryptPasswordEncoder password = new BCryptPasswordEncoder();
        return password.encode(value);
    }

    public static String tokenGenerator(Integer length) {
        if (length == null) {
            throw new BadRequestException("Valor do tamanho que formata o token esta vazio");
        }
        return UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, length);
    }

    public static String formatLocalDateToPtBrDate(LocalDate date) {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
    }
}
