package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface RespostaService {
    List<RespostaDto> findAll();
    RespostaDto save(RespostaDto respostaDto);
    RespostaDto update(RespostaDto respostaDto);
    RespostaDto findByAtividadeIdAndUsername(Integer id, String username);
    List<RespostaDto> findByAtividadeId(Integer atividadeId);
    List<RespostaDto> findAllByAulaId(Integer aulaId);
    RespostaDto findByAlunoAndAtividade(AlunoDto aluno, AtividadeDto atividade);
    RespostaDto saveFile(MultipartFile file, Integer atividadeId, String username);

    void deleteFileByAtividadeIdAndUsername(Integer atividadeId, String username);

    Boolean existsById(Integer id);
}
