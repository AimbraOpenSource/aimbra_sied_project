package com.aimbra.sied.domain.entities;

import com.aimbra.sied.security.entities.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "professores")
@Data
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne
    private User user;

    @Column(length = 64, nullable = false)
    private String nome;
}