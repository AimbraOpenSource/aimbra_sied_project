package com.aimbra.sied.business.sied.services;

import com.aimbra.sied.domain.sied.dtos.RespostaReportDto;
import org.springframework.stereotype.Service;

@Service
public interface RespostaReportService {
    RespostaReportDto getReportByUsernameAndAulaId(String username, Integer aulaId);
    RespostaReportDto getReportByUsernameAndTurmaId(String username, Integer turmaId);
}
