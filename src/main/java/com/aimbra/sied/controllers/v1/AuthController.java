package com.aimbra.sied.controllers.v1;

import com.aimbra.sied.domain.Pessoa;
import com.aimbra.sied.domain.entities.RespostaEntity;
import com.aimbra.sied.security.dtos.JwtPayloadDto;
import com.aimbra.sied.security.dtos.UserDto;
import com.aimbra.sied.security.dtos.UserRegisterDto;
import com.aimbra.sied.security.services.AuthService;
import com.aimbra.sied.security.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/security/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserValidator validator;

    @PostMapping(path = "/login")
    public ResponseEntity<JwtPayloadDto> login(@RequestBody JwtPayloadDto payloadDto) {
        payloadDto = authService.login(payloadDto);
        return ResponseEntity.ok(payloadDto);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Pessoa> register(@RequestBody UserRegisterDto user) {
        validator.cannotRegister(user);
        Pessoa pessoa = authService.register(user);
        return ResponseEntity.ok(pessoa);
    }

}
