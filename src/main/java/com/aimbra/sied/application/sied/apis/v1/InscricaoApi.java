package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.InscricaoService;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/inscricoes")
public class InscricaoApi {

    @Qualifier("inscricaoServiceImpl")
    @Autowired
    private InscricaoService service;

    @GetMapping
    public ResponseEntity<List<TurmaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PreAuthorize("hasRole('ALUNO')")
    @GetMapping(path = "/turmas/{uuid}")
    public ResponseEntity<TurmaDto> insertAluno(
            @PathParam("senha") String senha,
            @PathVariable("uuid") String uuidTurma,
            @AuthenticationPrincipal UserDetails userDetails
            ) {

        return ResponseEntity.ok(service.insertAluno(
                userDetails.getUsername(),
                uuidTurma,
                senha
        ));
    }
}
