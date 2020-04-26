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

    @Column(nullable = false)
    private boolean temAgendamento;

    @Column(nullable = false)
    private boolean alunoFazUpload;

    @Column(nullable = false)
    private boolean respostaTemTexto;

    @Column(nullable = false)
    private boolean temAulaAoVivo;

    @Column(nullable = false)
    private boolean temDiscusao;
}
