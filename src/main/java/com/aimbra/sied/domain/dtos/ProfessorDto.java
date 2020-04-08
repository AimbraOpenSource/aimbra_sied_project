package com.aimbra.sied.domain.dtos;

import com.aimbra.sied.domain.Pessoa;
import com.aimbra.sied.security.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;

@Data
public class ProfessorDto implements Pessoa {
    private Integer id;
    private UserDto user;
    @Setter
    private String nome;

    @JsonIgnore
    @JsonProperty(value = "user")
    public UserDto getUser() {
        return user;
    }
}
