package com.aimbra.sied.domain.entities;

import com.aimbra.sied.security.entities.User;
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

    @OneToOne
    private User user;

    @ManyToMany(mappedBy = "alunos")
    private List<TurmaEntity> turmas = new ArrayList<>();
}
