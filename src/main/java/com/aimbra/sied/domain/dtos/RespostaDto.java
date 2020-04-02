package com.aimbra.sied.domain.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RespostaDto {
    private Integer id;
    private String caminho;
    private String descricao;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private AtividadeDto atividade;
    private AlunoDto aluno;
}
