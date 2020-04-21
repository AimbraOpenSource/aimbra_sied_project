package com.aimbra.sied.domain.sied.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "turmas")
@Data
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private UUID uuid = UUID.randomUUID();

    @Column(length = 128, nullable = false, unique = true)
    private String senha;

    @ManyToOne(cascade = CascadeType.ALL)
    private CursoEntity curso;

    @ManyToMany
    @JoinTable(
            name = "inscricoes",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"),
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {
                            "turma_id",
                            "aluno_id"
                    })
            }
    )
    private List<AlunoEntity> alunos = new ArrayList<>();

    @ManyToOne
    private ProfessorEntity professor;

    public void addAluno(AlunoEntity alunoEntity) {
        alunos.add(alunoEntity);
        alunoEntity.getTurmas().add(this);
    }

    public void removeAluno(AlunoEntity alunoEntity) {
        alunoEntity.getTurmas().remove(this);
        alunos.remove(alunoEntity);
    }
}
