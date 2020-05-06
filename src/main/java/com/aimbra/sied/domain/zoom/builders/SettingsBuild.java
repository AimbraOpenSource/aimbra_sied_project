package com.aimbra.sied.domain.zoom.builders;

import com.aimbra.sied.domain.sied.dtos.AulaConfiguracaoDto;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingSettingRequestDto;

import java.util.ArrayList;

public abstract class SettingsBuild {
    public static ZMeetingSettingRequestDto builderFromAulaConfiguracaoDto(AulaConfiguracaoDto configDto) {
        var settings = new ZMeetingSettingRequestDto();
        settings.setHostVideo(true);
        settings.setParticipantVideo(true);
        settings.setCnMeeting(false);
        settings.setInMeeting(false);
        settings.setJoinBeforeHost(true);
        settings.setMuteUponEntry(true);
        settings.setWatermark(true);
        settings.setUsePmi(true);
        settings.setApprovalType(null);
        settings.setAudio("both");
        settings.setAutoRecording("none");
        settings.setEnforceLogin(false);
        settings.setGlobalDialInCountries(new ArrayList<>());
        settings.setRegistrantsEmailNotification(false);
        return settings;
    }
}
