package com.aimbra.sied.security.dtos;

import com.aimbra.sied.domain.Pessoa;
import com.aimbra.sied.domain.dtos.AlunoDto;
import com.aimbra.sied.domain.dtos.ProfessorDto;
import com.aimbra.sied.security.enums.UserRole;
import lombok.Data;

@Data
public class UserRegisterDto {
    private ProfessorDto professor;
    private AlunoDto aluno;
}
