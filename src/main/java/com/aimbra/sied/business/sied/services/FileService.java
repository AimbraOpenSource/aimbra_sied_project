package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.security.sied.dtos.UserDto;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {
    void init();
    void initRespostaRepository();
    RecursoDto savePerguntaDoProfessor(MultipartFile file, AulaDto aulaDto, UserDto user);
    RecursoDto saveRespostaDoAluno(MultipartFile file, AulaDto aulaDto, UserDto user);
    Resource load(String filename);
    void deleteAll();
    void deleteByRecurso(RecursoDto recursoDto);
    Stream<Path> loadAll();
}
