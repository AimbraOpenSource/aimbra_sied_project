package com.aimbra.sied.security.entities;

import com.aimbra.sied.security.enums.UserRole;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", schema = "security")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 32)
    private String username;

    @Column(length = 128)
    private String passoword;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime lastAccessIn;

}
