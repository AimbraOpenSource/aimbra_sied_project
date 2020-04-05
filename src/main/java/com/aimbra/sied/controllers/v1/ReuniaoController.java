package com.aimbra.sied.controllers.v1;

import com.aimbra.sied.business.services.ReuniaoService;
import com.aimbra.sied.domain.dtos.ReuniaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/reunioes")
public class ReuniaoController {

    @Qualifier("reuniaoServiceImpl")
    @Autowired
    private ReuniaoService service;

    @GetMapping
    public ResponseEntity<List<ReuniaoDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}