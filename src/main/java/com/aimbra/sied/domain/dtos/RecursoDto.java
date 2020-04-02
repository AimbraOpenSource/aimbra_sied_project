package com.aimbra.sied.domain.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecursoDto {
    private Integer id;
    private String nome;
    private String caminho;
    private String icone;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private AulaDto aula;
}
