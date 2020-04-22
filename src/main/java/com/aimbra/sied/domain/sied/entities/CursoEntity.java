package com.aimbra.sied.domain.sied.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
@Data
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 64, nullable = false)
    private String nome;
}
