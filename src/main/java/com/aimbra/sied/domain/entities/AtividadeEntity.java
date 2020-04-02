package com.aimbra.sied.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "atividades")
public class AtividadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 64, nullable = false)
    private String titulo;

    @Column(length = 10000, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    private LocalDateTime liberadoEm;

    @ManyToOne
    private AulaEntity aula;

}

