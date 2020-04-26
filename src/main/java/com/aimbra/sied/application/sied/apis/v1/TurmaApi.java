package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.ProfessorService;
import com.aimbra.sied.business.sied.services.TurmaService;
import com.aimbra.sied.business.sied.services.UserService;
import com.aimbra.sied.domain.sied.builders.TurmaCreateFactory;
import com.aimbra.sied.domain.sied.dtos.CursoDto;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.domain.sied.dtos.TurmaAlunoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.domain.sied.validators.TurmaValidator;
import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.enums.UserRole;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.JsonPath;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/turmas")
public class TurmaApi {

    @Qualifier("turmaServiceImpl")
    @Autowired
    private TurmaService service;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private TurmaValidator turmaValidator;

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<TurmaDto> findByUUid(@PathVariable("uuid") String uuid) {
        turmaValidator.cannotFindByUUID(uuid);
        TurmaDto turmaResponse = service.findByUuid(UUID.fromString(uuid));
        return ResponseEntity.ok(turmaResponse);
    }

    @GetMapping()
    public ResponseEntity<TurmaDto> findById(@PathParam("turmaId") Integer turmaId) {
        turmaValidator.cannotFindById(turmaId);
        return ResponseEntity.ok(service.findById(turmaId));
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping(value = "/professor")
    public ResponseEntity<List<TurmaDto>> findAllByProfessorLoggedIn(@AuthenticationPrincipal UserDetails userDetails) {
        List<TurmaDto> turma = service.findAllByProfessorUsername(userDetails.getUsername());
        return ResponseEntity.ok(turma);
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @PostMapping(value = "/professor")
    @Transactional
    public ResponseEntity<TurmaDto> create(@RequestBody CursoDto cursoDto, @AuthenticationPrincipal UserDetails userDetails) {
        ProfessorDto professorDto = professorService.findByUsername(userDetails.getUsername());
        TurmaDto dto = TurmaCreateFactory.create(cursoDto, professorDto);
        TurmaDto turmaResponse = service.create(dto);
        return ResponseEntity.ok(turmaResponse);
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @PutMapping(value = "/professor/removeAll")
    public ResponseEntity<?> removeAll(@RequestBody List<TurmaDto> turmas, @AuthenticationPrincipal UserDetails userDetails) {
        ProfessorDto professorDto = professorService.findByUsername(userDetails.getUsername());
        service.deleteAll(turmas);
        return ResponseEntity.ok(true);
    }

    @PreAuthorize("hasRole('ALUNO')")
    @GetMapping(value = "/aluno")
    public ResponseEntity<List<TurmaAlunoDto>> findAllByAluno(@AuthenticationPrincipal UserDetails userDetails) {
        List<TurmaAlunoDto> turmas = service.findAllByAlunoUsername(userDetails.getUsername());
        return ResponseEntity.ok(turmas);
    }





}
