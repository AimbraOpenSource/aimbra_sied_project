package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AlunoConverter;
import com.aimbra.sied.business.sied.converters.AtividadeConverter;
import com.aimbra.sied.business.sied.converters.RespostaConverter;
import com.aimbra.sied.business.sied.services.*;
import com.aimbra.sied.domain.sied.RespostaFactory;
import com.aimbra.sied.domain.sied.dtos.*;
import com.aimbra.sied.domain.sied.entities.AtividadeEntity;
import com.aimbra.sied.domain.sied.entities.RespostaEntity;
import com.aimbra.sied.domain.sied.enums.TipoRecurso;
import com.aimbra.sied.infra.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RespostaServiceImpl implements RespostaService {

    @Autowired
    private RespostaRepository repository;

    @Qualifier("atividadeServiceImpl")
    @Autowired
    private AtividadeService atividadeService;

    @Autowired
    private RespostaConverter converter;

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService alunoService;

    @Qualifier("fileServiceImpl")
    @Autowired
    private FileService fileService;

    @Qualifier("recursoServiceImpl")
    @Autowired
    private RecursoService recursoService;

    @Override
    public List<RespostaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

    /**
     * TODO Problema na conversão de usuarios em um cascata enorme
     * @param respostaDto
     * @return
     */
    @Override
    public RespostaDto save(RespostaDto respostaDto) {
        RespostaEntity entity = new RespostaEntity();
        entity.setCriadoEm(LocalDateTime.now());
        entity.setAtualizadoEm(LocalDateTime.now());
        entity.setAluno(new AlunoConverter().toEntity(respostaDto.getAluno()));
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        atividadeEntity.setId(respostaDto.getAtividade().getId());
        entity.setAtividade(atividadeEntity);
        entity.setDescricao(respostaDto.getDescricao());
        entity.setCaminho(respostaDto.getCaminho());

        repository.save(entity);
        return respostaDto;
    }

    /**
     * TODO Problema na conversão de usuarios em um cascata enorme
     * @param respostaDto
     * @return
     */
    @Override
    public RespostaDto update(RespostaDto respostaDto) {
        RespostaEntity entity = new RespostaEntity();
        entity.setId(respostaDto.getId());
        entity.setCriadoEm(LocalDateTime.now());
        entity.setAtualizadoEm(respostaDto.getAtualizadoEm());
        entity.setAluno(new AlunoConverter().toEntity(respostaDto.getAluno()));
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        atividadeEntity.setId(respostaDto.getAtividade().getId());
        entity.setAtividade(atividadeEntity);
        entity.setDescricao(respostaDto.getDescricao());
        entity.setCaminho(respostaDto.getCaminho());

        repository.saveAndFlush(entity);
        return respostaDto;
    }

    @Override
    public RespostaDto findByAtividadeIdAndUsername(Integer id, String username) {
        return repository.findAllByAtividadeIdAndUsername(id, username)
                .map(a -> converter.toDto(a))
                .orElse(null);
    }

    @Override
    public List<RespostaDto> findByAtividadeId(Integer atividadeId) {
        return repository.findAllByAtividade_Id(atividadeId).map(
                a -> converter.toDtoList(a)
        ).orElse(new ArrayList<>());
    }

    @Override
    public List<RespostaDto> findAllByAulaId(Integer aulaId) {
        return repository.findAllByAulaId(aulaId).map(r -> converter.toDtoList(r)).orElse(new ArrayList<>());
    }

    @Override
    public RespostaDto findByAlunoAndAtividade(AlunoDto aluno, AtividadeDto atividade) {
        return repository.findFirstByAlunoAndAtividade(new AlunoConverter().toEntity(aluno), new AtividadeConverter().toEntity(atividade))
                .map(r -> converter.toDto(r))
                .orElse(null);
    }

    @Override
    public RespostaDto saveFile(MultipartFile file, Integer atividadeId, String username) {
        AlunoDto alunoDto = alunoService.findByUsername(username);
        AtividadeDto atividadeDto = atividadeService.findById(atividadeId);
        RecursoDto recursoDto = fileService.saveRespostaDoAluno(file, atividadeDto.getAula(), alunoDto.getUser());
        RespostaDto respostaDto = findByAlunoAndAtividade(alunoDto, atividadeDto);
        recursoDto.setTipo(TipoRecurso.EXERCICIO_RESPOSTA);
        RespostaEntity respostaEntity;
        if (respostaDto != null) {
            respostaEntity = converter.toEntity(respostaDto);
        } else {
            respostaEntity = new RespostaEntity();
        }
        respostaEntity.setCaminho(recursoDto.getCaminho());
        respostaEntity.setCriadoEm(LocalDateTime.now());
        respostaEntity.setAtualizadoEm(LocalDateTime.now());
        respostaEntity.setAluno(new AlunoConverter().toEntity(alunoDto));
        respostaEntity.setAtividade(new AtividadeConverter().toEntity(atividadeDto));
        repository.save(respostaEntity);
        return RespostaFactory.toDto(
                respostaEntity.getId(),
                new AlunoConverter().toDto(respostaEntity.getAluno()),
                new AtividadeConverter().toDto(respostaEntity.getAtividade()),
                respostaEntity.getCriadoEm(),
                respostaEntity.getAtualizadoEm(),
                respostaEntity.getCaminho(),
                respostaEntity.getDescricao());
    }



    @Override
    public void deleteFileByAtividadeIdAndUsername(Integer atividadeId, String username) {
        AtividadeDto atividadeDto = atividadeService.findById(atividadeId);
        AlunoDto aluno = alunoService.findByUsername(username);
        List<RecursoDto> recursos = recursoService.findByUserAndAula(aluno.getUser(), atividadeDto.getAula());
        RespostaDto resposta = findByAlunoAndAtividade(aluno, atividadeDto);
        if (recursos != null && recursos.size() > 0) {
            for (var recurso: recursos) {
                fileService.deleteByRecurso(recurso);
                recursoService.deleteByUserAndAula(aluno.getUser(), atividadeDto.getAula());
            }
        }
        resposta.setCaminho(null);
        RespostaEntity save = repository.saveAndFlush(converter.toEntity(resposta));
    }
}
