package com.aimbra.sied.domain.sied.dtos;

import lombok.Data;

@Data
public class AulaDto {
    private Integer id;
    private Integer ordem;
    private String titulo;
    private String urlVideoGravado;
    private String descricao;
    private String observacao;
    private TurmaDto turma;
    private ReuniaoDto reuniao;
    private AulaConfiguracaoDto configuracao;
}
