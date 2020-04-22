package com.aimbra.sied.domain.zoom.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ZMeetingSettingDto {
    @JsonProperty(value = "host_video")
    private boolean host_video;

    @JsonProperty(value = "participant_video")
    private boolean participantVideo;

    @JsonProperty(value = "cn_meeting")
    private boolean cnMeeting;

    @JsonProperty(value = "in_meeting")
    private boolean inMeeting;

    @JsonProperty(value = "join_before_host")
    private boolean joinBeforeHost;

    @JsonProperty(value = "mute_upon_entry")
    private boolean muteUponEntry;

    @JsonProperty(value = "use_pmi")
    private boolean usePmi;

    @JsonProperty(value = "approval_type")
    private float approvalType;

    @JsonProperty(value = "auto_recording")
    private String autoRecording;

    @JsonProperty(value = "enforce_login")
    private boolean enforceLogin;

    @JsonProperty(value = "enforce_login_domains")
    private String enforceLoginDomains;

    @JsonProperty(value = "alternative_hosts")
    private String alternativeHosts;

    @JsonProperty(value = "close_registration")
    private boolean closeRegistration;

    @JsonProperty(value = "registrants_confirmation_email")
    private boolean registrantsConfirmationEmail;

    @JsonProperty(value = "waiting_room")
    private boolean waitingRoom;

    @JsonProperty(value = "registrants_email_notification")
    private boolean registrantsEmailNotification;

    @JsonProperty(value = "meeting_authentication")
    private boolean meetingAuthentication;

    private boolean watermark;
    private String audio;
}
