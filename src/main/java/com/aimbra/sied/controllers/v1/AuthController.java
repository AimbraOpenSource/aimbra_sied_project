package com.aimbra.sied.controllers.v1;

import com.aimbra.sied.business.services.AlunoService;
import com.aimbra.sied.business.services.ProfessorService;
import com.aimbra.sied.domain.Pessoa;
import com.aimbra.sied.domain.dtos.AlunoDto;
import com.aimbra.sied.domain.dtos.ProfessorDto;
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
    private ProfessorService professorService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private UserValidator validator;


    @PostMapping(path = "/login")
    public ResponseEntity<JwtPayloadDto> login(@RequestBody JwtPayloadDto payloadDto) {
        payloadDto = authService.login(payloadDto);
        return ResponseEntity.ok(payloadDto);
    }

    @PostMapping(path = "/register/professor")
    public ResponseEntity<Pessoa> professorRegister(@RequestBody ProfessorDto dto) {
        UserDto userDto = authService.register(dto.getUser());
        dto.setUser(userDto);
        dto = professorService.save(dto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(path = "/register/aluno")
    public ResponseEntity<Pessoa> alunoRegister(@RequestBody AlunoDto dto) {
        UserDto userDto = authService.register(dto.getUser());
        dto.setUser(userDto);
        dto = alunoService.save(dto);
        return ResponseEntity.ok(dto);
    }

}
