package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.AlunoService;
import com.aimbra.sied.business.sied.services.AtividadeService;
import com.aimbra.sied.business.sied.services.RespostaService;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import com.aimbra.sied.domain.sied.utils.DateDeserializer;
import com.aimbra.sied.domain.sied.validators.RespostaValidator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/respostas")
public class RespostaApi {

    @Qualifier("respostaServiceImpl")
    @Autowired
    private RespostaService service;

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService alunoService;

    @Qualifier("atividadeServiceImpl")
    @Autowired
    private AtividadeService atividadeService;

    @Autowired
    private RespostaValidator respostaValidator;

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping
    public ResponseEntity<List<RespostaDto>> findAllByAulaId(@PathParam("aulaId") Integer aulaId) {
        respostaValidator.cannotFindById(aulaId);
        return ResponseEntity.ok(service.findAllByAulaId(aulaId));
    }

    @PreAuthorize("hasRole('ALUNO')")
    @GetMapping(value = "/atividades/{id}")
    public ResponseEntity<RespostaDto> findByAtividadeIdAndUserLoggedIn(
            @PathVariable("id") Integer id,
            @AuthenticationPrincipal UserDetails userDetails) {
        respostaValidator.cannotFindById(id);
        RespostaDto response = service.findByAtividadeIdAndUsername(id, userDetails.getUsername());
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ALUNO')")
    @PostMapping
    @Transactional
    public ResponseEntity<RespostaDto> insert(
            @RequestBody RespostaDto respostaDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        AlunoDto aluno = alunoService.findByUsername(userDetails.getUsername());
        respostaDto.setAluno(aluno);

        AtividadeDto atividadeDto = atividadeService.findById(respostaDto.getAtividade().getId());
        respostaDto.setAtividade(atividadeDto);

        respostaDto.setCriadoEm(LocalDateTime.now());
        respostaDto.setAtualizadoEm(LocalDateTime.now());

        respostaValidator.cannotCreate(respostaDto);

        respostaDto = service.save(respostaDto);
        return ResponseEntity.ok(respostaDto);
    }

    @PreAuthorize("hasRole('ALUNO')")
    @PutMapping
    public ResponseEntity<RespostaDto> update(
            @RequestBody RespostaDto respostaDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        AlunoDto aluno = alunoService.findByUsername(userDetails.getUsername());
        respostaDto.setAluno(aluno);
        respostaDto = service.update(respostaDto);
        return ResponseEntity.ok(respostaDto);
    }

    @PreAuthorize("hasRole('ALUNO')")
    @Transactional
    @PostMapping(value = "/files")
    public ResponseEntity<RespostaDto> saveFile(
            @RequestParam MultipartFile file,
            @RequestParam("atividadeId") String atividadeId,
            @AuthenticationPrincipal UserDetails userDetails) {
        var respostaDto = service.saveFile(file, Integer.parseInt(atividadeId), userDetails.getUsername());
        return ResponseEntity.ok(respostaDto);
    }

    @PreAuthorize("hasRole('ALUNO')")
    @Transactional
    @DeleteMapping(value = "/files")
    public ResponseEntity<?> deleteFile(
            @PathParam("atividadeId") Integer atividadeId,
            @AuthenticationPrincipal UserDetails userDetails) {
        respostaValidator.cannotDelete(atividadeId);
        service.deleteFileByAtividadeIdAndUsername(atividadeId, userDetails.getUsername());
        return ResponseEntity.ok(true);
    }

}
