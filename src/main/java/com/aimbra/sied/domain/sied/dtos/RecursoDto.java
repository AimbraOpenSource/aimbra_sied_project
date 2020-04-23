package com.aimbra.sied.domain.sied.dtos;

import com.aimbra.sied.domain.sied.enums.TipoRecurso;
import com.aimbra.sied.security.sied.dtos.UserDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecursoDto {
    private Integer id;
    private String nomeReal;
    private String nomeLogico;
    private String caminho;
    private TipoRecurso tipo;
    private UserDto user;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private AulaDto aula;
}
