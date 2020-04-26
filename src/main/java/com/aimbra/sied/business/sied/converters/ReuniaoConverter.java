package com.aimbra.sied.business.sied.converters;

import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
import com.aimbra.sied.domain.sied.entities.ReuniaoEntity;
import org.springframework.stereotype.Service;

@Service
public class ReuniaoConverter extends Converter<ReuniaoDto, ReuniaoEntity> {
    public ReuniaoConverter() {
        super(fromDto -> {
            var entity = new ReuniaoEntity();
            entity.setId(fromDto.getId());
            entity.setDataHoraInicio(fromDto.getDataHoraInicio());
            entity.setDescricao(fromDto.getDescricao());
            entity.setDuracao(fromDto.getDuracao());
            entity.setFoiRealizada(fromDto.getFoiRealizada());
            entity.setFusoHorario(fromDto.getFusoHorario());
            entity.setLink(fromDto.getLink());
            entity.setSenha(fromDto.getSenha());
            entity.setTopico(fromDto.getTopico());
            entity.setVideoAnfitriaoAtivado(fromDto.getVideoAnfitriaoAtivado());
            entity.setVideoParticipanteAtivado(fromDto.getVideoParticipanteAtivado());
            return entity;
        }, fromEntity -> {
            var dto = new ReuniaoDto();
            if (fromEntity.getId() != null) {
                dto.setId(fromEntity.getId());
            }
            dto.setDataHoraInicio(fromEntity.getDataHoraInicio());
            dto.setDescricao(fromEntity.getDescricao());
            dto.setDuracao(fromEntity.getDuracao());
            dto.setFoiRealizada(fromEntity.getFoiRealizada());
            dto.setFusoHorario(fromEntity.getFusoHorario());
            dto.setLink(fromEntity.getLink());
            dto.setSenha(fromEntity.getSenha());
            dto.setTopico(fromEntity.getTopico());
            dto.setVideoAnfitriaoAtivado(fromEntity.getVideoAnfitriaoAtivado());
            dto.setVideoParticipanteAtivado(fromEntity.getVideoParticipanteAtivado());
            return dto;
        });
    }
}
