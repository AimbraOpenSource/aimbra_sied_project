package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.AtividadeService;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{atividadeId}")
    public ResponseEntity<AtividadeDto> findById(@PathVariable("atividadeId") Integer atividadeId) {
        return ResponseEntity.ok(service.findById(atividadeId));
    }

    @GetMapping(path = "/aulas/{aulaId}")
    public ResponseEntity<AtividadeDto> findByAulaId(@PathVariable("aulaId") Integer aulaId) {
        AtividadeDto response = service.findByAulaId(aulaId);
        return ResponseEntity.ok(response);
    }

    @PostMapping @Transactional
    public ResponseEntity<AtividadeDto> insert(@RequestBody AtividadeDto dto) {
        return ResponseEntity.ok(service.insert(dto));
    }
}
