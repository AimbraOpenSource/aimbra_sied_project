package com.aimbra.sied.domain.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AtividadeDto {
    private Integer id;
    private String titulo;
    private String descricao;
    private LocalDateTime criadoEm;
    private LocalDateTime liberadoEm;
    private AulaDto aula;
}
