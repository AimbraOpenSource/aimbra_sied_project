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

    @Column(length = 255)
    private String topico;

    @Column(length = 10000)
    private String descricao;

    @Column(length = 16)
    private String duracao;

    @Column()
    private LocalDateTime dataHoraInicio;

    @Column(length = 16)
    private String fusoHorario;

    @Column(length = 16)
    private String senha;

    @Column()
    private Boolean videoAnfitriaoAtivado;

    @Column()
    private Boolean videoParticipanteAtivado;

    @Column()
    private Boolean foiRealizada;
}
