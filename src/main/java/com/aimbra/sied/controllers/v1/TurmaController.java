package com.aimbra.sied.controllers.v1;

import com.aimbra.sied.business.services.TurmaService;
import com.aimbra.sied.domain.dtos.TurmaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/turmas")
public class TurmaController {

    @Qualifier("turmaServiceImpl")
    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<List<TurmaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
