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

    @Column(length = 255, nullable = false)
    private String topico;

    @Column(length = 10000, nullable = false)
    private String descricao;

    @Column(length = 16, nullable = false)
    private String duracao;

    @Column(nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(length = 16, nullable = false)
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
