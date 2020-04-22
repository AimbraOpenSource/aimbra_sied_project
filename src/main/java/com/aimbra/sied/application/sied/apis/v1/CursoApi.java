package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.CursoService;
import com.aimbra.sied.domain.sied.dtos.CursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/cursos")
public class CursoApi {

    @Qualifier("cursoServiceImpl")
    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<CursoDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
