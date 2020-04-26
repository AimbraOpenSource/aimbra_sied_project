package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.InscricaoDto;
import com.aimbra.sied.domain.sied.dtos.TurmaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InscricaoService {
    List<TurmaDto> findAll();
    TurmaDto insertAlunoWithSenha(InscricaoDto inscricaoDto, String senhaTurma);
    void removeByInscricao(InscricaoDto dto);
}
