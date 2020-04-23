package com.aimbra.sied.business.zoom.services;

import com.aimbra.sied.domain.zoom.dtos.ZMeetingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZMeetingService {

    List<ZMeetingDto> findAll(String username);
    ZMeetingDto findById(Integer id, String username);

}
