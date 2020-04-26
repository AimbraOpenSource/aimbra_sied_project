package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.AlunoService;
import com.aimbra.sied.business.sied.services.InscricaoService;
import com.aimbra.sied.business.sied.services.TurmaService;
import com.aimbra.sied.domain.sied.dtos.InscricaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.validators.InscricaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/inscricoes")
public class InscricaoApi {

    @Qualifier("inscricaoServiceImpl")
    @Autowired
    private InscricaoService service;

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService alunoService;

    @Qualifier("turmaServiceImpl")
    @Autowired
    private TurmaService turmaService;

    @Autowired
    private InscricaoValidator inscricaoValidator;

    @GetMapping
    public ResponseEntity<List<TurmaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @DeleteMapping
    public ResponseEntity<?> removeAluno(
            @PathParam("alunoId") Integer alunoId,
            @PathParam("turmaId") Integer turmaId
    ) {
        var alunoDto = alunoService.findById(alunoId);
        var turmaDto = turmaService.findById(turmaId);

        InscricaoDto dto = new InscricaoDto();
        dto.setAluno(alunoDto);
        dto.setTurma(turmaDto);

        service.removeByInscricao(dto);
        return ResponseEntity.ok(true);
    }

    @PreAuthorize("hasRole('ALUNO')")
    @GetMapping(path = "/turmas/{uuid}")
    public ResponseEntity<TurmaDto> insertAluno(
            @PathParam("senha") String senha,
            @PathVariable("uuid") String uuidTurma,
            @AuthenticationPrincipal UserDetails userDetails
            ) {

        var alunoDto = alunoService.findByUsername(userDetails.getUsername());
        var turmaDto = turmaService.findByUuid(UUID.fromString(uuidTurma));

        InscricaoDto dto = new InscricaoDto();
        dto.setAluno(alunoDto);
        dto.setTurma(turmaDto);

        inscricaoValidator.cannotCreate(dto);

        TurmaDto turma = service.insertAlunoWithSenha(dto, senha);
        return ResponseEntity.ok(turma);
    }
}
