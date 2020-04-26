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
        settings.setUsePmi(true);
        settings.setApprovalType(0);
        settings.setAudio(true);
        settings.setAutoRecording(false);
        settings.setEnforceLogin(false);
        settings.setGlobalDialInCountries(new ArrayList<>());
        return settings;
    }
}
