package com.aimbra.sied.controllers.v1;

import com.aimbra.sied.business.services.AulaService;
import com.aimbra.sied.domain.dtos.AulaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/aulas")
public class AulaController {

    @Qualifier("aulaServiceImpl")
    @Autowired
    private AulaService service;

    @GetMapping
    public ResponseEntity<List<AulaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
