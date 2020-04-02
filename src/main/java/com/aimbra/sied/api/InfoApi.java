package com.aimbra.sied.api;

import com.aimbra.sied.domain.entities.InfoEntity;
import com.aimbra.sied.business.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<InfoEntity> insert(@RequestBody InfoEntity entity) {
        entity = service.save(entity);
        return ResponseEntity.ok(entity);
    }
}
