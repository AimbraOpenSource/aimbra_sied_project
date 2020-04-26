package com.aimbra.sied.domain.zoom.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter @Setter
public class ZMeetingSettingRequestDto {
    @JsonProperty(value = "id")
    private BigInteger id;

    @JsonProperty(value = "host_video")
    private Boolean hostVideo;

    @JsonProperty(value = "participant_video")
    private Boolean participantVideo;

    @JsonProperty(value = "cn_meeting")
    private Boolean cnMeeting;

    @JsonProperty(value = "in_meeting")
    private Boolean inMeeting;

    @JsonProperty(value = "join_before_host")
    private Boolean joinBeforeHost;

    @JsonProperty(value = "mute_upon_entry")
    private Boolean muteUponEntry;

    @JsonProperty(value = "watermark")
    private Boolean watermark;

    @JsonProperty(value = "use_pmi")
    private Boolean usePmi;

    @JsonProperty(value = "approval_type")
    private Integer approvalType;

    @JsonProperty(value = "registration_type")
    private Boolean registrationType;

    @JsonProperty(value = "audio")
    private Boolean audio;

    @JsonProperty(value = "auto_recording")
    private Boolean autoRecording;

    @JsonProperty(value = "enforce_login")
    private Boolean enforceLogin;

    @JsonProperty(value = "enforce_login_domains")
    private String enforceLoginDomains;

    @JsonProperty(value = "alternative_hosts")
    private String alternativeHosts;

    @JsonProperty(value = "global_dial_in_countries")
    private List<String> globalDialInCountries;

    @JsonProperty(value = "registrants_email_notification")
    private Boolean registrantsEmailNotification;
}
