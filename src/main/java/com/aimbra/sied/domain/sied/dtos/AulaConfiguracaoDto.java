package com.aimbra.sied.domain.sied.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AulaConfiguracaoDto {
    private Integer id;
    private Boolean temAgendamento;
    private Boolean alunoFazUpload;
    private Boolean respostaTemTexto;
    private Boolean temAulaAoVivo;
    private Boolean temDiscusao;
}
