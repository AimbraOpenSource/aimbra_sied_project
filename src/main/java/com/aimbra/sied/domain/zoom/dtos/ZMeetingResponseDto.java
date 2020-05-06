package com.aimbra.sied.domain.zoom.dtos;

import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZMeetingResponseDto {

    @JsonProperty(value = "id")
    private BigInteger id;

    @JsonProperty(value = "uuid")
    private String uuid;

    @JsonProperty(value = "host_id")
    private String hostId;

    @JsonProperty(value = "topic")
    private String topic;

    @JsonProperty(value = "type")
    private Integer type;

    @JsonProperty(value = "status")
    private String status;

    @JsonProperty(value = "start_time")
    private LocalDateTime startTime;

    @JsonProperty(value = "duration")
    private Integer duration;

    @JsonProperty(value = "timezone")
    private String timezone;

    @JsonProperty(value = "agenda")
    private String agenda;

    @JsonProperty(value = "created_at")
    private String created_at;

    @JsonProperty(value = "startUrl")
    private String startUrl;

    @JsonProperty(value = "join_url")
    private String joinUrl;

    @JsonProperty(value = "pmi")
    private String pmi;

    @JsonProperty(value = "settings")
    private ZMeetingSettingResponseDto settings;

}
