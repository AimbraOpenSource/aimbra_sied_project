package com.aimbra.sied.api;

import com.aimbra.sied.domain.entities.InfoEntity;
import com.aimbra.sied.domain.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class InfoApi {

    @Autowired
    private InfoService service;

    @GetMapping
    public ResponseEntity<List<InfoEntity>> findInformation() {
        return ResponseEntity.ok(service.findAll());
    }
}
