package com.aimbra.sied.domain.controllers.v1;

import com.aimbra.sied.business.services.RespostaService;
import com.aimbra.sied.domain.dtos.RespostaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/respostas")
public class RespostaController {

    @Qualifier("respostaServiceImpl")
    @Autowired
    private RespostaService service;

    @GetMapping
    public ResponseEntity<List<RespostaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
