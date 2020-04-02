package com.aimbra.sied.domain.dtos;

import com.aimbra.sied.security.dtos.UserDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AlunoDto {
    private Integer id;
    private String nome;
    private UserDto user;
    private List<TurmaDto> turmas = new ArrayList<>();
}
