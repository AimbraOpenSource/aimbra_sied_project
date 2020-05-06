package com.aimbra.sied.domain.zoom.entities;

import com.aimbra.sied.domain.sied.entities.AulaEntity;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingSettingResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "meetings", schema = "zoom")
public class ZMeetingEntity {

    @Id
    private BigInteger id;

    @Column
    private String uuid;

    @Column
    private String hostId;

    @Column
    private String topic;

    @Column
    private Integer type;

    @Column
    private String status;

    @Column
    private LocalDateTime startTime;

    @Column
    private Integer duration;

    @Column
    private String timezone;

    @Column
    private String agenda;

    @Column
    private String created_at;

    @Column
    private String startUrl;

    @Column
    private String joinUrl;

    @Column
    private String pmi;

//    @ManyToOne
//    private ZMettingSettingsEntity settings;

}
