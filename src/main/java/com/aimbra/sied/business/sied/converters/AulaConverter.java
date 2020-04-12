package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.entities.AulaEntity;
import org.springframework.stereotype.Service;


@Service
public class AulaConverter extends Converter<AulaDto, AulaEntity> {
    public AulaConverter() {
        super(fromDto -> {
            var entity = new AulaEntity();
            entity.setId(fromDto.getId());
            entity.setDescricao(fromDto.getDescricao());
            entity.setObservacao(fromDto.getObservacao());
            entity.setOrdem(fromDto.getOrdem());
            entity.setReuniao(new ReuniaoConverter().toEntity(fromDto.getReuniao()));
            entity.setTemDiscursao(fromDto.getTemDiscursao());
            entity.setTemReuniao(fromDto.getTemReuniao());
            entity.setTitulo(fromDto.getTitulo());
            entity.setTurma(new TurmaConverter().toEntity(fromDto.getTurma()));
            entity.setUrlVideoGravado(fromDto.getUrlVideoGravado());
            return entity;
        }, fromEntity -> {
            var dto = new AulaDto();
            dto.setId(fromEntity.getId());
            dto.setDescricao(fromEntity.getDescricao());
            dto.setObservacao(fromEntity.getObservacao());
            dto.setOrdem(fromEntity.getOrdem());
            if (fromEntity.getReuniao() != null) {
                dto.setReuniao(new ReuniaoConverter().toDto(fromEntity.getReuniao()));
            }
            dto.setTemDiscursao(fromEntity.getTemDiscursao());
            dto.setTemReuniao(fromEntity.getTemReuniao());
            dto.setTitulo(fromEntity.getTitulo());
            dto.setTurma(new TurmaConverter().toDto(fromEntity.getTurma()));
            dto.setUrlVideoGravado(fromEntity.getUrlVideoGravado());
            return dto;
        });
    }
}
