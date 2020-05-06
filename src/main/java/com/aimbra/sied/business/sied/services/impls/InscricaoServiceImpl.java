package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.converters.AlunoConverter;
import com.aimbra.sied.business.sied.converters.TurmaConverter;
import com.aimbra.sied.business.sied.services.AlunoService;
import com.aimbra.sied.business.sied.services.InscricaoService;
import com.aimbra.sied.business.sied.services.TurmaService;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.InscricaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import com.aimbra.sied.domain.sied.entities.AlunoEntity;
import com.aimbra.sied.domain.sied.entities.TurmaEntity;
import com.aimbra.sied.domain.sied.exceptions.AlunoNotFoundException;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.domain.sied.exceptions.TurmaNotFoundException;
import com.aimbra.sied.infra.repositories.AlunoRepository;
import com.aimbra.sied.infra.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InscricaoServiceImpl implements InscricaoService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaConverter turmaConverter;

    @Autowired
    private AlunoConverter alunoConverter;

    @Override
    public List<TurmaDto> findAll() {
        List<TurmaEntity> all = turmaRepository.findAll();
        return turmaConverter.toDtoList(all);
    }

    @Override
    public TurmaDto insertAlunoWithSenha(InscricaoDto inscricaoDto, String senhaTurma) {
        senhaTurmaEqualsTo(senhaTurma, inscricaoDto.getTurma());

        var turma = turmaConverter.toEntity(inscricaoDto.getTurma());
        turma.addAluno(alunoConverter.toEntity(inscricaoDto.getAluno()));

        turma = turmaRepository.save(turma);
        return turmaConverter.toDto(turma);
    }

    @Override
    public void removeByInscricao(InscricaoDto dto) {
        dto.getTurma().removealuno(dto.getAluno());
        turmaRepository.save(turmaConverter.toEntity(dto.getTurma()));
    }

    private AlunoEntity findAlunoById(Integer alunoId) {
        return alunoRepository.findById(alunoId).orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado pelo Id"));
    }

    private TurmaEntity findTurmaById(Integer turmaId) {
        return turmaRepository.findById(turmaId).orElseThrow(() -> new TurmaNotFoundException("Turma não encontrada pelo Id"));
    }

    private void senhaTurmaEqualsTo(String senhaTurma, TurmaDto turma) {
        if (!senhaTurma.equalsIgnoreCase(turma.getSenha())) throw new BadRequestException("A Senha da Turma não se tem ingridade com a informada");
    }

    private TurmaEntity findTurmaByUuid(String turmaUuid) {
        return turmaRepository
                    .findFirstByUuid(UUID.fromString(turmaUuid))
                    .orElseThrow(() -> new AlunoNotFoundException("Turma não encontrado pelo ID"));
    }

    private AlunoEntity findAlunoByUsername(String username) {
        return alunoRepository
                .findFirstByUser_Username(username)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado pelo Username"));
    }
}
