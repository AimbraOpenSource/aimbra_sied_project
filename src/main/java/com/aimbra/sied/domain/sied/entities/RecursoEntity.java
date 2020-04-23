package com.aimbra.sied.domain.sied.entities;

import com.aimbra.sied.domain.sied.enums.TipoRecurso;
import com.aimbra.sied.security.sied.entities.UserEntity;
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

    @Column
    @Enumerated(EnumType.STRING)
    private TipoRecurso tipo;

    @Column(nullable = false)
    private LocalDateTime atualizadoEm;

    @ManyToOne
    private AulaEntity aula;

    @ManyToOne
    private UserEntity user;
}
