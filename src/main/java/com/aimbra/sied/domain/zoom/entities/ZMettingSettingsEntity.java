package com.aimbra.sied.domain.zoom.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

//@Entity
//@Data
//@Table(name = "settings", schema = "zoom")
public class ZMettingSettingsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private Boolean hostVideo;

    @Column
    private Boolean participantVideo;

    @Column
    private Boolean cnMeeting;

    @Column
    private Boolean inMeeting;

    @Column
    private Boolean joinBeforeHost;

    @Column
    private Boolean muteUponEntry;

    @Column
    private Boolean watermark;

    @Column
    private Boolean usePmi;

    @Column
    private Integer approvalType;

    @Column
    private Boolean registrationType;

    @Column
    private String audio;

    @Column
    private String autoRecording;

    @Column
    private Boolean enforceLogin;

    @Column
    private String enforceLoginDomains;

    @Column
    private String alternativeHosts;

    @ElementCollection
    private List<String> globalDialInCountries;

    @Column
    private Boolean registrantsEmailNotification;
}
