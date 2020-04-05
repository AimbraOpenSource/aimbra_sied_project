package com.aimbra.sied.domain.dtos;

import com.aimbra.sied.domain.Pessoa;
import com.aimbra.sied.security.dtos.UserDto;
import lombok.Data;

@Data
public class ProfessorDto implements Pessoa {
    private Integer id;
    private UserDto user;
    private String nome;
}
