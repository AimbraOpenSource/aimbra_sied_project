package com.aimbra.sied.business.zoom.converters;

import com.aimbra.sied.business.sied.converters.Converter;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingSettingResponseDto;
import com.aimbra.sied.domain.zoom.entities.ZMettingSettingsEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ZMeetingSettingsConverter extends Converter<ZMeetingSettingResponseDto, ZMettingSettingsEntity> {
    public ZMeetingSettingsConverter() {
        super(fromDto -> {
            var entity = new ZMettingSettingsEntity();
            return null;
        }, fromEntity -> {
            return null;
        });
    }
}
