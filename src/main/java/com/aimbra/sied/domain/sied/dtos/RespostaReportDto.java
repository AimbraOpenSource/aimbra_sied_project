package com.aimbra.sied.domain.sied.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaReportDto {
    private Integer quantidadeTotal;
    private Integer quantidadeDispachado;
    private Integer emFalta;
    private AlunoDto aluno;
    private AulaDto aula;
}
