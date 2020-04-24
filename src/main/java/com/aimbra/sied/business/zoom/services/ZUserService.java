package com.aimbra.sied.business.zoom.services;

import com.aimbra.sied.domain.zoom.dtos.ZUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZUserService {
    List<ZUserDto> findAll();
}
