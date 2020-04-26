package com.aimbra.sied.domain.zoom.dtos;

import com.aimbra.sied.domain.zoom.entities.ZMettingSettingsEntity;
import com.aimbra.sied.domain.zoom.entities.ZRecurrenceEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZMeetingRequestDto {

    @JsonProperty(value = "id")
    private BigInteger id;

    @JsonProperty(value = "topic")
    private String topic;

    @JsonProperty(value = "type")
    private Integer type;

    @JsonProperty(value = "start_time")
    private String startTime;

    @JsonProperty(value = "duration")
    private Integer duration;

    @JsonProperty(value = "timezone")
    private String timezone;

    @JsonProperty(value = "password")
    private String password;

    @JsonProperty(value = "agenda")
    private String agenda;

    @JsonProperty(value = "recurrence")
    private ZRecurrenceRequestDto recurrence;

    @JsonProperty(value = "settings")
    private ZMeetingSettingRequestDto settings;

}
