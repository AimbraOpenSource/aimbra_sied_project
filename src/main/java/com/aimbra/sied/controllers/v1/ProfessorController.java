package com.aimbra.sied.controllers.v1;

import com.aimbra.sied.business.services.ProfessorService;
import com.aimbra.sied.domain.dtos.ProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/professores")
public class ProfessorController {

    @Qualifier("professorServiceImpl")
    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


}
