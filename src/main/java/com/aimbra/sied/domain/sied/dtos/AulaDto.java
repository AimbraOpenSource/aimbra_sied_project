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
    private Boolean temReuniao;
    private Boolean temDiscursao;
    private TurmaDto turma;
    private ReuniaoDto reuniao;
}
