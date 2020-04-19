package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.FileService;
import com.aimbra.sied.business.sied.services.RecursoService;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/aulas/{aulaId}")
    public ResponseEntity<List<RecursoDto>> findAllByAulaId(@PathVariable("aulaId") Integer aulaId) {
        return ResponseEntity.ok(service.findAllByAulaId(aulaId));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathParam("recursoId") Integer recursoId) {
        RecursoDto recursoDto = service.findById(recursoId);
        fileService.deleteByRecurso(recursoDto);
        this.service.deleteById(recursoId);
        return ResponseEntity.ok(true);
    }
}
