package com.aimbra.sied.domain.sied.dtos;

import com.aimbra.sied.domain.sied.dtos.interfaces.Pessoa;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AlunoDto implements Pessoa {
    private Integer id;
    private String nome;
    private UserDto user;
    private List<TurmaDto> turmas = new ArrayList<>();

    @JsonIgnore
    @JsonProperty(value = "user")
    public UserDto getUser() {
        return user;
    }
}
