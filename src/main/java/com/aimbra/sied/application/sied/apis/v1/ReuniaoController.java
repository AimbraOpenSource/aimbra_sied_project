package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.ReuniaoService;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;
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
