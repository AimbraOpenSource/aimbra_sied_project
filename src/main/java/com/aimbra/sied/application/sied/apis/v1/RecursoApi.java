package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.FileService;
import com.aimbra.sied.business.sied.services.RecursoService;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.domain.sied.validators.RecursoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/recursos")
public class RecursoApi {

    @Qualifier("recursoServiceImpl")
    @Autowired
    private RecursoService service;

    @Qualifier("fileServiceImpl")
    @Autowired
    private FileService fileService;

    @Autowired
    private RecursoValidator validator;

    @GetMapping(value = "/aulas/{aulaId}")
    public ResponseEntity<List<RecursoDto>> findAllPerguntasByAulaId(@PathVariable("aulaId") Integer aulaId) {
        validator.cannotFindById(aulaId);
        List<RecursoDto> response = service.findAllByAulaIdByTipoExercicioProposto(aulaId);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathParam("recursoId") Integer recursoId) {
        validator.cannotFindById(recursoId);
        RecursoDto recursoDto = service.findById(recursoId);
        fileService.deleteByRecurso(recursoDto);
        this.service.deleteById(recursoId);
        return ResponseEntity.ok(true);
    }

    @GetMapping(value = "/respostas")
    public ResponseEntity<List<RecursoDto>> findAllByAulaId(
            @PathParam("aulaId") Integer aulaId,
            @AuthenticationPrincipal UserDetails userDetails) {
        validator.cannotFindById(aulaId);
        List<RecursoDto> response = service.findRespostaByUsernameAndAulaId(userDetails.getUsername(), aulaId);
        return ResponseEntity.ok(response);
    }
}
