package com.aimbra.sied.domain.sied.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "aula_configuracoes")
@Data
public class AulaConfiguracaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private boolean temAgendamento;

    @Column
    private boolean alunoFazUpload;

    @Column
    private boolean respostaTemTexto;

    @Column
    private boolean temAulaAoVivo;

    @Column
    private boolean temDiscusao;
}
