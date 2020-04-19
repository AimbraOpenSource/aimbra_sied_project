package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.ProfessorService;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/professores")
public class ProfessorApi {

    @Qualifier("professorServiceImpl")
    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<ProfessorDto> findByUserLoggedIn(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        ProfessorDto professorResponse = service.findByUsername(username);
        return ResponseEntity.ok(professorResponse);
    }


}
