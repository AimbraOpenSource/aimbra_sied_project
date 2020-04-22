package com.aimbra.sied.domain.sied.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AulaConfiguracaoDto {
    private Integer id;
    private boolean temAgendamento;
    private boolean alunoFazUpload;
    private boolean respostaTemTexto;
    private boolean temAulaAoVivo;
    private boolean temDiscusao;
}
