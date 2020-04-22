package com.aimbra.sied.domain.sied.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recursos")
@Data
public class RecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nomeReal;

    @Column(unique = true, nullable = false)
    private String nomeLogico;

    @Column(nullable = false)
    private String caminho;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    private LocalDateTime atualizadoEm;

    @ManyToOne
    private AulaEntity aula;
}
