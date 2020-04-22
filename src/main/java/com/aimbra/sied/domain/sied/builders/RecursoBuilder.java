package com.aimbra.sied.domain.sied.builders;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;

import java.time.LocalDateTime;

public abstract class RecursoBuilder {
    public static RecursoDto create(String caminho, LocalDateTime criadoEm, String nomeLogico, String nomeReal, LocalDateTime atualizadoEm, AulaDto aulaDto) {
        var recurso = new RecursoDto();
        recurso.setAtualizadoEm(atualizadoEm);
        recurso.setAula(aulaDto);
        recurso.setCriadoEm(criadoEm);
        recurso.setCaminho(caminho);
        recurso.setNomeLogico(nomeLogico);
        recurso.setNomeReal(nomeReal);
        return recurso;
    }
}
