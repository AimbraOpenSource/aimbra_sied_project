package com.aimbra.sied.business.zoom.services;

import com.aimbra.sied.domain.zoom.dtos.ZAppConfigurationDto;
import org.springframework.stereotype.Service;

@Service
public interface ZAppconfigurationService {
    ZAppConfigurationDto save(ZAppConfigurationDto dto);
    ZAppConfigurationDto findByUsername(String username);
}
