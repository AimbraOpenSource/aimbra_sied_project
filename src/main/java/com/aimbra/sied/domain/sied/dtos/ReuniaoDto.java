package com.aimbra.sied.domain.sied.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReuniaoDto {
    private Integer id;
    private String topico;
    private String descricao;
    private String duracao;
    private LocalDateTime dataHoraInicio;
    private String fusoHorario;
    private String senha;
    private Boolean videoAnfitriaoAtivado;
    private Boolean videoParticipanteAtivado;
    private Boolean foiRealizada;
}
