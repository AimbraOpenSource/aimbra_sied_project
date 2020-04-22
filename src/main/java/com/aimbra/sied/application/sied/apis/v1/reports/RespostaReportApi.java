package com.aimbra.sied.application.sied.apis.v1.reports;

import com.aimbra.sied.business.sied.services.RespostaReportService;
import com.aimbra.sied.domain.sied.dtos.RespostaReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/respostas/relatorios")
public class RespostaReportApi {

    @Qualifier("respostaReportServiceImpl")
    @Autowired
    private RespostaReportService service;

    @GetMapping(value = "/aulas/{aulaId}")
    public ResponseEntity<RespostaReportDto> getByUsernameAndAulaId(@PathVariable("aulaId") Integer aulaId, @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.getReportByUsernameAndAulaId(userDetails.getUsername(), aulaId));
    }

    @GetMapping(value = "/turmas/{turmaId}")
    public ResponseEntity<RespostaReportDto> getByUsernameAndTurmaId(@PathVariable("turmaId") Integer turmaId, @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(service.getReportByUsernameAndTurmaId(userDetails.getUsername(), turmaId));
    }
}
