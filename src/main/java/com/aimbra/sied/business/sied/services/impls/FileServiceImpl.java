package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.RecursoConverter;
import com.aimbra.sied.domain.sied.builders.RecursoBuilder;
import com.aimbra.sied.domain.sied.dtos.AulaDto;
import com.aimbra.sied.domain.sied.dtos.RecursoDto;
import com.aimbra.sied.domain.sied.entities.RecursoEntity;
import com.aimbra.sied.domain.sied.enums.TipoRecurso;
import com.aimbra.sied.infra.repositories.RecursoRepository;
import com.aimbra.sied.security.sied.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import com.aimbra.sied.business.sied.services.FileService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {

    private Path root;
    private Integer aulaId;

    @Autowired
    private RecursoRepository repository;

    @Autowired
    private RecursoConverter converter;

    @Override
    public void init() {
        try {
            this.root = Paths.get("storage/recursos/" + this.aulaId);
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void initRespostaRepository() {
        try {
            this.root = Paths.get("storage/respostas/" + this.aulaId);
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public RecursoDto savePerguntaDoProfessor(MultipartFile file, AulaDto aulaDto, UserDto user) {
        try {
            aulaId = aulaDto.getId();
            init();

            String[] stringType = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
            String extensionType = stringType[stringType.length - 1];
            String logicName = aulaId + "_" + UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "") + "." + extensionType;

            var fullPath = this.root.resolve(logicName);

            RecursoDto recursoDto = RecursoBuilder.create(
                    "storage/recursos/" + this.aulaId.toString(),
                    TipoRecurso.EXERCICIO_PROPOSTO,
                    user,
                    LocalDateTime.now(),
                    logicName,
                    file.getOriginalFilename(),
                    LocalDateTime.now(),
                    aulaDto);

            RecursoEntity recursoResponse = repository.save(converter.toEntity(recursoDto));
            Files.copy(file.getInputStream(), fullPath);

            return converter.toDto(recursoResponse);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public RecursoDto saveRespostaDoAluno(MultipartFile file, AulaDto aulaDto, UserDto user) {
        try {
            aulaId = aulaDto.getId();
            initRespostaRepository();

            String[] stringType = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
            String extensionType = stringType[stringType.length - 1];
            String logicName = aulaId + "_" + UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "") + "." + extensionType;

            var fullPath = this.root.resolve(logicName);

            RecursoDto recursoDto = RecursoBuilder.create(
                    "storage/respostas/" + this.aulaId.toString(),
                    TipoRecurso.EXERCICIO_RESPOSTA,
                    user,
                    LocalDateTime.now(),
                    logicName,
                    file.getOriginalFilename(),
                    LocalDateTime.now(),
                    aulaDto);

            RecursoEntity recursoResponse = repository.save(converter.toEntity(recursoDto));
            Files.copy(file.getInputStream(), fullPath);

            return converter.toDto(recursoResponse);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public void deleteByRecurso(RecursoDto recursoDto) {
        root = Paths.get(recursoDto.getCaminho() + "/" + recursoDto.getNomeLogico());
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
