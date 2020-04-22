package com.aimbra.sied.domain.zoom.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ZUserDto {
    private String id;

    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    private String lastName;

    @JsonProperty(value = "last_login_time")
    private String last_login_time;

    @JsonProperty(value = "last_client_version")
    private String lastClientVersion;

    @JsonProperty(value = "pic_url")
    private String picUrl;

    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @JsonProperty(value = "settings")
    private ZMeetingSettingDto settings;

    private String email;
    private float type;
    private float pmi;
    private String timezone;
    private float verified;
    private String created_at;
    private String language;
    private String status;
}
