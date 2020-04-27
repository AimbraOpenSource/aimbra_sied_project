package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.builders.AlunoBuilder;
import com.aimbra.sied.business.sied.converters.AlunoConverter;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.infra.repositories.AlunoRepository;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;

/**
 * Os testes são baseados numa tecnica classica:
 * 1. Cenário
 * 2. Ação
 * 3. Verificação
 * Autor: Thiago Cunha
 */
@SpringBootTest
class AlunoServiceTest {

    private AlunoDto alunoDto;

    @Autowired
    private AlunoConverter converter;

    @Mock
    private AlunoRepository repository;

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService service;

    @BeforeEach
    void setUp() {
        List<AlunoDto> alunos = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            alunos.add(AlunoBuilder.init().fromId(i).build());
        }

        Mockito.when(repository.findAll()).thenReturn(converter.toEntityList(alunos));
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Busca tudo com sucesso")
    @Test
    void findAllWithSuccess() {

        List<AlunoDto> alunos = service.findAll();

        MatcherAssert.assertThat(alunos, hasSize(3));
    }

    @Test
    void findAllTurmasByUsername() {
    }

    @Test
    void findAllAlunosOfProfessor() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void existsOnTurmaUuidAndUsername() {
    }
}
