package com.aimbra.sied.domain.sied.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public abstract class DateUtils {

    LocalDateTime stringToDate(String dateString) {
        Instant instant = Instant.parse(dateString);
        return LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
    }

}
