package com.aimbra.sied.domain.dtos;

import com.aimbra.sied.security.dtos.UserDto;
import lombok.Data;

@Data
public class ProfessorDto {
    private Integer id;
    private UserDto user;
    private String nome;
}
