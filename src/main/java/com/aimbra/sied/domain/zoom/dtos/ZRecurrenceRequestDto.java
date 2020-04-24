package com.aimbra.sied.domain.zoom.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter @Setter
public class ZRecurrenceRequestDto {

    @JsonProperty(value = "id")
    private BigInteger id;

    @JsonProperty(value = "type")
    private Integer type;

    @JsonProperty(value = "repeat_interval")
    private Integer repeatInterval;

    @JsonProperty(value = "weekly_days")
    private String weeklyDays;

    @JsonProperty(value = "monthly_day")
    private Integer monthlyDay;

    @JsonProperty(value = "monthly_week")
    private Integer monthlyWeek;

    @JsonProperty(value = "monthly_week_day")
    private Integer monthlyWeekDay;

    @JsonProperty(value = "end_times")
    private Integer endTimes;

    @JsonProperty(value = "end_date_time")
    private String endDateTime;
}
