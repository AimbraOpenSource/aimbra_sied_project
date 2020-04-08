package com.aimbra.sied.domain.controllers.v1;

import com.aimbra.sied.business.services.AlunoService;
import com.aimbra.sied.domain.dtos.AlunoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/alunos")
public class AlunoController {

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<AlunoDto> findByUserLoggedIn(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        return ResponseEntity.ok(service.findByUsername(username));
    }

}
