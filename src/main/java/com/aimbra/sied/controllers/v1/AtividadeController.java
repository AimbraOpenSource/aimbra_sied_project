package com.aimbra.sied.controllers.v1;

import com.aimbra.sied.business.services.AtividadeService;
import com.aimbra.sied.domain.dtos.AtividadeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/atividades")
public class AtividadeController {

    @Qualifier("atividadeServiceImpl")
    @Autowired
    private AtividadeService service;

    @GetMapping
    public ResponseEntity<List<AtividadeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
