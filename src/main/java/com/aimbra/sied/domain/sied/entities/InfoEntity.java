package com.aimbra.sied.domain.sied.entities;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "info")
@Data
public class InfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "title", length = 32, nullable = false, unique = true)
    private String title;

    @Column(name = "version", length = 6, nullable = false, unique = true)
    private String version;

    @Column(name = "author", length = 64, nullable = false)
    private String author;

    @Column(name = "git_repository", length = 255, nullable = false)
    private String gitRepository;
}
