package com.aimbra.sied.business.sied.services.impls;

import com.aimbra.sied.business.sied.services.RespostaReportService;
import com.aimbra.sied.domain.sied.dtos.RespostaReportDto;
import com.aimbra.sied.infra.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaReportServiceImpl implements RespostaReportService {

    @Autowired
    private RespostaRepository repository;

    @Override
    public RespostaReportDto getReportByUsernameAndAulaId(String username, Integer aulaId) {
        Integer quantidadeTotal = repository.countAllByAtividade_Aula_Id(aulaId);
        Integer quantidadeEntregue = repository.countAllByAtividade_Aula_IdAndAluno_User_Username(aulaId, username);
        Integer quantidadeEmFalta = quantidadeTotal - quantidadeEntregue;
        RespostaReportDto dto = new RespostaReportDto();
        dto.setQuantidadeTotal(quantidadeTotal);
        dto.setEmFalta(quantidadeEmFalta);
        dto.setQuantidadeDispachado(quantidadeEntregue);
        return dto;
    }

    @Override
    public RespostaReportDto getReportByUsernameAndTurmaId(String username, Integer turmaId) {
        Integer quantidadeTotal = repository.countAllByAtividade_Aula_Turma_Id(turmaId);
        Integer quantidadeEntregue = repository.countAllByAtividade_Aula_Turma_IdAndAluno_User_Username(turmaId, username);
        Integer quantidadeEmFalta = quantidadeTotal - quantidadeEntregue;
        RespostaReportDto dto = new RespostaReportDto();
        dto.setQuantidadeTotal(quantidadeTotal);
        dto.setEmFalta(quantidadeEmFalta);
        dto.setQuantidadeDispachado(quantidadeEntregue);
        return dto;
    }
}
