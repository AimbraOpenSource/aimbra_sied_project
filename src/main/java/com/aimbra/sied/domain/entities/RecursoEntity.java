package com.aimbra.sied.domain.entities;

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

    @Column(length = 255, unique = true, nullable = false)
    private String nome;

    @Column(length = 255, unique = true, nullable = false)
    private String caminho;

    @Column(length = 32, nullable = false)
    private String icone;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    private LocalDateTime atualizadoEm;

    @ManyToOne
    private AulaEntity aula;
}
