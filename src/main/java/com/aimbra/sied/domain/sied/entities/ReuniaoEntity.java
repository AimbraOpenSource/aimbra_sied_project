package com.aimbra.sied.domain.sied.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reunioes")
@Data
public class ReuniaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 64)
    private String topico;

    @Column(length = 10000, nullable = false)
    private String descricao;

    @Column(nullable = false)
    String link;

    @Column(length = 3, nullable = false)
    private String duracao;

    @Column(nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(length = 32, nullable = false)
    private String fusoHorario;

    @Column(length = 16)
    private String senha;

    @Column(nullable = false)
    private Boolean videoAnfitriaoAtivado;

    @Column(nullable = false)
    private Boolean videoParticipanteAtivado;

    @Column(nullable = false)
    private Boolean foiRealizada;
}
