package com.aimbra.sied.domain.sied.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "aulas")
@Data
public class AulaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private Integer ordem;

    @Column(length = 128, nullable = false)
    private String titulo;

    @Column(length = 1024, nullable = false)
    private String urlVideoGravado;

    @Column(length = 10000, nullable = false)
    private String descricao;

    @Column(length = 10000, nullable = false)
    private String observacao;

    @ManyToOne
    private TurmaEntity turma;

    @OneToOne(cascade = CascadeType.ALL)
    private ReuniaoEntity reuniao;

    @OneToOne(cascade = CascadeType.ALL)
    private AulaConfiguracaoEntity configuracao;

}
