package com.aimbra.sied.domain.zoom.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "meetings", schema = "zoom")
public class ZMeetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private String topic;

    /**
     * 1 - Reuniao Instantânea
     * 2 - Agendar Reunião
     * 3 - Reunião recorrente sem tempo fixo
     * 8 - Reunião recorrente com tempo fixo
     */
    @Column
    private Integer type;

    @Column
    private LocalDateTime startTime;

    @Column
    private Integer duration;

    @Column
    private String timezone;

    @Column
    private String password;

    @Column
    private String agenda;

    @ManyToOne
    private ZRecurrenceEntity recurrence;

    @ManyToOne
    private ZMettingSettingsEntity settings;

}
