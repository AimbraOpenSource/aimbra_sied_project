package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.entities.AulaEntity;
import org.springframework.stereotype.Service;


@Service
public class AulaConverter extends Converter<AulaDto, AulaEntity> {
    public AulaConverter() {
        super(fromDto -> {
            var entity = new AulaEntity();
            if (fromDto.getId() != null) {
                entity.setId(fromDto.getId());
            }

            if (fromDto.getDescricao() != null) {
                entity.setDescricao(fromDto.getDescricao());
            }

            if (fromDto.getObservacao() != null) {
                entity.setObservacao(fromDto.getObservacao());
            }

            if (fromDto.getOrdem() != null) {
                entity.setOrdem(fromDto.getOrdem());
            }

            if (fromDto.getReuniao() != null) {
                entity.setReuniao(new ReuniaoConverter().toEntity(fromDto.getReuniao()));
            }

            if (fromDto.getTitulo() != null) {
                entity.setTitulo(fromDto.getTitulo());
            }

            if (fromDto.getTurma() != null) {
                entity.setTurma(new TurmaConverter().toEntity(fromDto.getTurma()));
            }

            if (fromDto.getUrlVideoGravado() != null) {
                entity.setUrlVideoGravado(fromDto.getUrlVideoGravado());
            }

            if (fromDto.getUrlVideoGravado() != null) {
                entity.setConfiguracao(new AulaConfiguracaoConverter().toEntity(fromDto.getConfiguracao()));
            }

            return entity;
        }, fromEntity -> {
            var dto = new AulaDto();
            if (fromEntity.getId() != null) {
                dto.setId(fromEntity.getId());
            }
            dto.setDescricao(fromEntity.getDescricao());
            dto.setObservacao(fromEntity.getObservacao());
            dto.setOrdem(fromEntity.getOrdem());
            if (fromEntity.getReuniao() != null) {
                dto.setReuniao(new ReuniaoConverter().toDto(fromEntity.getReuniao()));
            }
            dto.setTitulo(fromEntity.getTitulo());
            dto.setTurma(new TurmaConverter().toDto(fromEntity.getTurma()));
            dto.setUrlVideoGravado(fromEntity.getUrlVideoGravado());

                dto.setConfiguracao(new AulaConfiguracaoConverter().toDto(fromEntity.getConfiguracao()));

            return dto;
        });
    }
}
