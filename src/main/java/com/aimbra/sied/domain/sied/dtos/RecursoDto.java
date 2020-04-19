package com.aimbra.sied.domain.sied.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecursoDto {
    private Integer id;
    private String nomeReal;
    private String nomeLogico;
    private String caminho;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private AulaDto aula;
}
