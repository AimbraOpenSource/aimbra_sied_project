package com.aimbra.sied.application.sied.apis.v1;

import com.aimbra.sied.business.sied.services.AtividadeService;
import com.aimbra.sied.business.sied.services.FileService;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.utils.DateDeserializer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/atividades")
public class AtividadeApi {

    @Qualifier("atividadeServiceImpl")
    @Autowired
    private AtividadeService service;

    @Qualifier("fileServiceImpl")
    @Autowired
    private FileService fileService;

    @Autowired
    private DateDeserializer dateDeserializer;

    @GetMapping
    public ResponseEntity<List<AtividadeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{atividadeId}")
    public ResponseEntity<AtividadeDto> findById(@PathVariable("atividadeId") Integer atividadeId) {
        return ResponseEntity.ok(service.findById(atividadeId));
    }

    @GetMapping(path = "/aulas/{aulaId}")
    public ResponseEntity<AtividadeDto> findByAulaId(@PathVariable("aulaId") Integer aulaId) {
        AtividadeDto response = service.findByAulaId(aulaId);
        return ResponseEntity.ok(response);
    }

    @PostMapping @Transactional
    public ResponseEntity<?> insert(@RequestParam MultipartFile[] files, @RequestParam String atividade, ModelMap modelMap) {
        Gson gson = dateDeserializer.deserialize().create();
        AtividadeDto atividadeDto = gson.fromJson(atividade, AtividadeDto.class);
        AtividadeDto response = service.insert(atividadeDto);
        Set<RecursoDto> recursos = new HashSet<>();
        for(int i = 0; i < files.length; i++) {
            RecursoDto recursoResponse = fileService.save(files[i], response.getAula());
            recursos.add(recursoResponse);
        }
        return ResponseEntity.ok(atividadeDto);
    }
}
