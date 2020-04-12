package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.AulaService;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/aulas")
public class AulaController {

    @Qualifier("aulaServiceImpl")
    @Autowired
    private AulaService service;

    @GetMapping
    public ResponseEntity<List<AulaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/turmas/{turmaId}")
    public ResponseEntity<List<AulaDto>> findAllByTurmaId(@PathVariable("turmaId") Integer turmaId, @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.findAllByTurmaIdAndUserLoggedIn(turmaId, userDetails.getUsername()));
    }
}
