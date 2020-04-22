package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.AulaService;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/aulas")
public class AulaApi {

    @Qualifier("aulaServiceImpl")
    @Autowired
    private AulaService service;

    @GetMapping
    public ResponseEntity<List<AulaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{aulaId}")
    public ResponseEntity<AulaDto> findById(@PathVariable("aulaId") Integer aulaId) {
        return ResponseEntity.ok(service.findById(aulaId));
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping(value = "/professores/turmas/{turmaId}")
    public ResponseEntity<List<AulaDto>> findAllByTurmaIdOfProfessor(@PathVariable("turmaId") Integer turmaId, @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.findAllByTurmaIdAndProfessorUserLoggedIn(turmaId, userDetails.getUsername()));
    }

    @PreAuthorize("hasRole('ALUNO')")
    @GetMapping(value = "/turmas/{turmaId}")
    public ResponseEntity<List<AulaDto>> findAllByTurmaIdOfAluno(@PathVariable("turmaId") Integer turmaId) {
        return ResponseEntity.ok(service.findAllByTurmaId(turmaId));
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @DeleteMapping
    @Transactional
    public ResponseEntity<?> deleteById(@PathParam("aulaId") Integer aulaId) {
        service.deleteById(aulaId);
        return ResponseEntity.ok(true);
    }
}
