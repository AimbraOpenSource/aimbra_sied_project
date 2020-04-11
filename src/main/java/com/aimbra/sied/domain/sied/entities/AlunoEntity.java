package com.aimbra.sied.domain.sied.entities;

import com.aimbra.sied.security.sied.entities.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "alunos")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 128, nullable = false)
    private String nome;

    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @ManyToMany(mappedBy = "alunos")
    private List<TurmaEntity> turmas = new ArrayList<>();
}
