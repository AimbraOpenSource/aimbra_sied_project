package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.AlunoService;
import com.aimbra.sied.business.sied.services.RespostaService;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/respostas")
public class RespostaApi {

    @Qualifier("respostaServiceImpl")
    @Autowired
    private RespostaService service;

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<RespostaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/atividades/{id}")
    public ResponseEntity<RespostaDto> findByAtividadeIdAndUserLoggedIn(
            @PathVariable("id") Integer id,
            @AuthenticationPrincipal UserDetails userDetails) {

        RespostaDto response = service.findByAtividadeIdAndUsername(id, userDetails.getUsername());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<RespostaDto> insert(
            @RequestBody RespostaDto respostaDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        AlunoDto aluno = alunoService.findByUsername(userDetails.getUsername());
        respostaDto.setAluno(aluno);
        respostaDto = service.save(respostaDto);
        return ResponseEntity.ok(respostaDto);
    }

    @PutMapping
    public ResponseEntity<RespostaDto> update(
            @RequestBody RespostaDto respostaDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        AlunoDto aluno = alunoService.findByUsername(userDetails.getUsername());
        respostaDto.setAluno(aluno);
        respostaDto = service.update(respostaDto);
        return ResponseEntity.ok(respostaDto);
    }
}
