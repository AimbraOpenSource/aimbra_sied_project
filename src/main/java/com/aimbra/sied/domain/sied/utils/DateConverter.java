package com.aimbra.sied.domain.sied.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;


public class DateConverter {
	
	
	public static LocalDateTime toLocalDateTime(String date) {
		final DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
		dtfb.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSX"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"))
				.parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
				.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
				.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0);
		return LocalDateTime.parse(date, dtfb.toFormatter());
	}
    
	public static LocalDate parseFromStrToLocalDate(String strDate, String mask) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mask);
		return LocalDate.parse(strDate, formatter);
	}
	

}
