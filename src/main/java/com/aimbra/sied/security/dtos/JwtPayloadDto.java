package com.aimbra.sied.security.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtPayloadDto {

    private String username;
    private String password;
    private UserDto user;
    private String token;


}
