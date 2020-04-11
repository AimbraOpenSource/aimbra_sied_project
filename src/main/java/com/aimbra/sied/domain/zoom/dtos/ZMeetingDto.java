package com.aimbra.sied.domain.zoom.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZMeetingDto {

    @JsonProperty(value = "host_id")
    private String hostId;

    @JsonProperty(value = "start_time")
    private String startTime;

    @JsonProperty(value = "start_url")
    private String startUrl;

    @JsonProperty(value = "join_url")
    private String joinUrl;

    @JsonProperty(value = "created_at")
    private String createdAt;

    @JsonProperty(value = "settings")
    private ZMeetingSettingDto settings;

    private String uuid;
    private Integer id;
    private String topic;
    private Integer type;
    private String status;
    private Integer duration;
    private String timezone;
    private String agenda;

}
