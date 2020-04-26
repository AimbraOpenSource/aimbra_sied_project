package com.aimbra.sied.domain.sied.validators;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.business.sied.services.RespostaService;
import com.aimbra.sied.domain.sied.dtos.AlunoDto;
import com.aimbra.sied.domain.sied.dtos.AtividadeDto;
import com.aimbra.sied.domain.sied.dtos.RespostaDto;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.aimbra.sied.domain.sied.exceptions.RespostaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RespostaValidator {
    @Autowired
    private TextValidator textValidator;

    @Autowired
    private AtividadeValidator atividadeValidator;

    @Autowired
    private AlunoValidator alunoValidator;

    @Autowired
    private RespostaService respostaService;

    private void respostaIsInvalid(String caminho, String descricao) {
        if ((caminho == null || descricao.isEmpty()) && (descricao == null || descricao.isEmpty())) {
            throw new BadRequestException("É preciso ter pelo menos uma forma de resposta, sendo descritivo ou em arquivo");
        }
    }

    private void caminhoIsInvalid(String caminho) {
        if (caminho != null) {
            textValidator.whereValueIs(caminho)
                    .whereMessageErrorIs("Caminho esta vazio")
                    .isEmpty()
                    .whereRangeLengthIs(5, 255)
                    .whereMessageErrorIs("Caminho precisa ter entre 5 a 255 caracteres")
                    .hasInvalidLength()
                    .isValid();
        }
    }

    private void descricaoIsInvalid(String descricao) {
        if (descricao != null) {
            textValidator.whereValueIs(descricao)
                    .whereMessageErrorIs("Descrição esta vazio")
                    .isEmpty()
                    .whereRangeLengthIs(10, 100000)
                    .whereMessageErrorIs("Caminho precisa ter entre 10 a 10000 caracteres")
                    .hasInvalidLength()
                    .isValid();
        }
    }

    private void criadoEmIsInvalid(LocalDateTime criadoEm) {
        if (criadoEm == null) {
            throw new BadRequestException("A data de criação esta vazio");
        }
    }

    private void atualizadoEmIsInvalid(LocalDateTime atualizadoEm) {
        if (atualizadoEm == null) {
            throw new BadRequestException("A data de atualização esta vazio");
        }
    }

    private void atividadeIsInvalid(AtividadeDto atividadeDto) {
        if (atividadeDto == null) {
            throw new BadRequestException("Atividade esta nula");
        }
        atividadeValidator.cannotCreate(atividadeDto);
    }

    private void alunoIsInvalid(AlunoDto aluno) {
        if (aluno == null) {
            throw new BadRequestException("Aluno esta nulo");
        }
        alunoValidator.cannotRegister(aluno);
    }

    public void cannotCreate(RespostaDto dto) {
        respostaIsInvalid(dto.getCaminho(), dto.getDescricao());
        caminhoIsInvalid(dto.getCaminho());
        descricaoIsInvalid(dto.getDescricao());
        criadoEmIsInvalid(dto.getCriadoEm());
        atualizadoEmIsInvalid(dto.getAtualizadoEm());
        atividadeIsInvalid(dto.getAtividade());
        alunoIsInvalid(dto.getAluno());
    }

    public void cannotFindById(Integer id) {
        if (id == null) {
            throw new BadRequestException("Id esta nulo");
        }
    }

    public void cannotDelete(Integer id) {
        if (id == null) {
            throw new BadRequestException("Id esta nulo");
        }
        if (!respostaService.existsById(id)) {
            throw new RespostaNotFoundException("Não foi possível encontrar essa resposta por id");
        }
    }
}
