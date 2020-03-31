package com.aimbra.sied.domain.entities;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "info")
@Data
public class InfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "title", length = 32)
    private String title;

    @Column(name = "version", length = 6)
    private String version;

    @Column(name = "author", length = 64)
    private String author;

    @Column(name = "git_repository", length = 255)
    private String gitRepository;
}
