package com.aimbra.sied.domain.zoom.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "currences", schema = "zoom")
public class ZRecurrenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private Integer type;

    @Column
    private Integer repeatInterval;

    @Column
    private String weeklyDays;

    @Column
    private Integer monthlyDay;

    @Column
    private Integer monthlyWeek;

    @Column
    private Integer monthlyWeekDay;

    @Column
    private Integer endTimes;

    @Column
    private LocalDateTime endDateTime;

}
