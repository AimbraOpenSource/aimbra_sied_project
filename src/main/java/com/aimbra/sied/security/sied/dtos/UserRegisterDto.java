package com.aimbra.sied.security.sied.dtos;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import lombok.Data;

@Data
public class UserRegisterDto {
    private ProfessorDto professor;
    private AlunoDto aluno;
}
