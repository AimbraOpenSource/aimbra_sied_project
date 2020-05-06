package com.aimbra.sied.business.zoom.services.impls;

import com.aimbra.sied.business.zoom.converters.ZAppConfigurationConverter;
import com.aimbra.sied.business.zoom.services.ZAppconfigurationService;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.domain.zoom.dtos.ZAppConfigurationDto;
import com.aimbra.sied.domain.zoom.entities.ZAppConfigurationEntity;
import com.aimbra.sied.infra.zoom.repositories.ZAppConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ZAppConfigurationServiceImpl implements ZAppconfigurationService {

    @Autowired
    private ZAppConfigurationRepository repository;

    @Autowired
    private ZAppConfigurationConverter converter;


    @Override
    public ZAppConfigurationDto save(ZAppConfigurationDto dto) {
        ZAppConfigurationEntity zAppConfigurationEntity = converter.toEntity(dto);
        zAppConfigurationEntity.setExpiredAt(LocalDateTime.now().plusDays(7));
        ZAppConfigurationEntity save = repository.save(zAppConfigurationEntity);
        return converter.toDto(save);
    }

    @Override
    public ZAppConfigurationDto findByUsername(String username) {
        return repository.findFirstByUser_Username(username)
                .map(c -> {
                    ZAppConfigurationDto configurationDto = converter.toDto(c);
                    return configurationDto;
                })
                .orElseThrow(() -> new BadRequestException("Configuração não encontrada"));
    }
}
