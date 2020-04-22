package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AlunoConverter;
import com.aimbra.sied.business.sied.converters.AtividadeConverter;
import com.aimbra.sied.business.sied.converters.RespostaConverter;
import com.aimbra.sied.business.sied.services.AlunoService;
import com.aimbra.sied.business.sied.services.ProfessorService;
import com.aimbra.sied.business.sied.services.RespostaService;
import com.aimbra.sied.domain.sied.dtos.ProfessorDto;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import com.aimbra.sied.domain.sied.entities.AtividadeEntity;
import com.aimbra.sied.domain.sied.entities.RespostaEntity;
import com.aimbra.sied.infra.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RespostaServiceImpl implements RespostaService {

    @Autowired
    private RespostaRepository repository;

    @Qualifier("professorServiceImpl")
    @Autowired
    private ProfessorService professorService;

    @Autowired
    private RespostaConverter converter;

    @Qualifier("alunoServiceImpl")
    @Autowired
    private AlunoService alunoService;

    @Override
    public List<RespostaDto> findAll() {
        return converter.toDtoList(repository.findAll());
    }

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
}
