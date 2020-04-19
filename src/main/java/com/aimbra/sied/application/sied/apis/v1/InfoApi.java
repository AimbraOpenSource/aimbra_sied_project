package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.impls.InfoServiceImpl;
import com.aimbra.sied.domain.sied.entities.InfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class InfoApi {

    @Autowired
    private InfoServiceImpl service;

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
