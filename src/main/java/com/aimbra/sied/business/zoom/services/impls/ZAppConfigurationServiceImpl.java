package com.aimbra.sied.business.zoom.services.impls;

import com.aimbra.sied.business.zoom.converters.ZAppConfigurationConverter;
import com.aimbra.sied.business.zoom.services.ZAppconfigurationService;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.domain.zoom.dtos.ZAppConfigurationDto;
import com.aimbra.sied.infra.zoom.repositories.ZAppConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZAppConfigurationServiceImpl implements ZAppconfigurationService {

    @Autowired
    private ZAppConfigurationRepository repository;

    @Autowired
    private ZAppConfigurationConverter converter;


    @Override
    public ZAppConfigurationDto save(ZAppConfigurationDto dto) {
        return converter.toDto(repository.save(converter.toEntity(dto)));
    }

    @Override
    public ZAppConfigurationDto findByUsername(String username) {
        return repository.findFirstByUser_Username(username)
                .map(c -> converter.toDto(c))
                .orElseThrow(() -> new BadRequestException("Configuração não encontrada"));
    }
}
