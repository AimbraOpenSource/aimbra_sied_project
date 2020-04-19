package com.aimbra.sied.domain.zoom.entities;

import com.aimbra.sied.security.sied.entities.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "configurations", schema = "zoom")
public class ZAppConfigurationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String apiKey;

    @Column(nullable = false, unique = true)
    private String apiSecret;

    @Column(nullable = false, unique = true)
    private String imChatHistoryToken;

    @Column(nullable = false, unique = true)
    private String jwtToken;

    @Column(nullable = false, unique = true)
    private LocalDateTime expiredAt;

    @ManyToOne
    private UserEntity user;

}
