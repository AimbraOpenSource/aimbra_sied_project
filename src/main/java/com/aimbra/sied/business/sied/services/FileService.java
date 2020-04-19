package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {
    public void init();
    public RecursoDto save(MultipartFile file, AulaDto aulaDto);
    public Resource load(String filename);
    public void deleteAll();
    public void deleteByRecurso(RecursoDto recursoDto);
    public Stream<Path> loadAll();
}
