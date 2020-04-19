package com.aimbra.sied.domain.sied.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class AtividadeDto {
    private Integer id;
    private String titulo;
    private String descricao;
    private AulaDto aula;
    private LocalDateTime criadoEm;
    private LocalDateTime liberadoEm;
}
