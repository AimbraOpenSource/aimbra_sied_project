package com.aimbra.sied.domain.zoom.builders;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingRequestDto;

public abstract class MeetingBuild {
    public static ZMeetingRequestDto builderFromAulaDto(AulaDto aulaDto) {
        var meeting = new ZMeetingRequestDto();
        meeting.setAgenda(aulaDto.getReuniao().getDescricao());
        meeting.setDuration(60);
        meeting.setPassword(aulaDto.getReuniao().getSenha());
        meeting.setStartTime(aulaDto.getReuniao().getDataHoraInicio().toString());
        meeting.setTimezone("America/Sao_Paulo");
        meeting.setTopic(aulaDto.getReuniao().getTopico());
        meeting.setType(2);
        meeting.setSettings(SettingsBuild.builderFromAulaConfiguracaoDto(aulaDto.getConfiguracao()));
        meeting.setRecurrence(RecurrenceBuilder.builder());
        return meeting;
    }
}
