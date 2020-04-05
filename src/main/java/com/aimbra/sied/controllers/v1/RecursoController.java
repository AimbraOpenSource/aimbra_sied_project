package com.aimbra.sied.controllers.v1;

import com.aimbra.sied.business.services.RecursoService;
import com.aimbra.sied.domain.dtos.RecursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/recursos")
public class RecursoController {

    @Qualifier("recursoServiceImpl")
    @Autowired
    private RecursoService service;

    @GetMapping
    public ResponseEntity<List<RecursoDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}