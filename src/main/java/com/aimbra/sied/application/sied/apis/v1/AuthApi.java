package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.AlunoService;
import com.aimbra.sied.business.sied.services.ProfessorService;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.domain.sied.dtos.interfaces.Pessoa;
import com.aimbra.sied.domain.sied.validators.AlunoValidator;
import com.aimbra.sied.domain.sied.validators.ProfessorValidator;
import com.aimbra.sied.security.sied.dtos.JwtPayloadDto;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;
import com.aimbra.sied.security.sied.services.AuthService;
import com.aimbra.sied.domain.sied.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/security/auth")
public class AuthApi {

    @Autowired
    private AuthService authService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ProfessorValidator professorValidator;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private AlunoValidator alunoValidator;

    @GetMapping(path = "/logout")
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok(true);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<JwtPayloadDto> login(@RequestBody JwtPayloadDto payloadDto) {
        payloadDto = authService.login(payloadDto);
        return ResponseEntity.ok(payloadDto);
    }

    @PostMapping(path = "/register/professores")
    @Transactional
    public ResponseEntity<Pessoa> professorRegister(@RequestBody ProfessorDto dto) {
        dto.getUser().setRole(UserRole.PROFESSOR);

        userValidator.cannotRegister(dto.getUser());

        UserDto userDto = authService.register(dto.getUser());
        dto.setUser(userDto);

        professorValidator.cannotCreate(dto);
        dto = professorService.save(dto);

        return ResponseEntity.ok(dto);
    }

    @PostMapping(path = "/register/alunos")
    public ResponseEntity<Pessoa> alunoRegister(@RequestBody AlunoDto dto) {
        dto.getUser().setRole(UserRole.ALUNO);

        userValidator.cannotRegister(dto.getUser());
        UserDto userDto = authService.register(dto.getUser());

        dto.setUser(userDto);
        alunoValidator.cannotRegister(dto);

        dto = alunoService.save(dto);
        return ResponseEntity.ok(dto);
    }

}
