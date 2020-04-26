package com.aimbra.sied.business.zoom.services;

import com.aimbra.sied.domain.zoom.dtos.ZMeetingRequestDto;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface ZMeetingService {

    List<ZMeetingRequestDto> findAll();
    ZMeetingRequestDto findById(BigInteger id);
    ZMeetingResponseDto create(ZMeetingRequestDto dto);

}
