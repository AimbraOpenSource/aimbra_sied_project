package com.aimbra.sied.builders.impls;

import com.aimbra.sied.builders.interfaces.ReuniaoBuilder;
import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;

import java.time.LocalDateTime;

public class ReuniaoBuilderImpl implements ReuniaoBuilder {

    private ReuniaoDto reuniaoDto;

    public ReuniaoBuilderImpl() {
        reuniaoDto = new ReuniaoDto();
        reuniaoDto.setFoiRealizada(false);
        reuniaoDto.setVideoParticipanteAtivado(true);
        reuniaoDto.setVideoAnfitriaoAtivado(true);
        reuniaoDto.setSenha("123123123");
        reuniaoDto.setFusoHorario("America/Sao_Paulo");
        reuniaoDto.setDataHoraInicio(LocalDateTime.now());
        reuniaoDto.setLink("Link example a ser adicionado");
        reuniaoDto.setDuracao("60");
        reuniaoDto.setDescricao("Aqui vai uma descrição a ser adicionada como exemplo a cunho de teste.");
        reuniaoDto.setTopico("Aqui vai o topico a ser dicutido na reunião");
        reuniaoDto.setId(1);
    }

    @Override
    public ReuniaoDto build() {
        return reuniaoDto;
    }

    @Override
    public ReuniaoBuilder withIdNull() {
        reuniaoDto.setId(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withTopicoNull() {
        reuniaoDto.setTopico(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withDescricaoNull() {
        reuniaoDto.setDescricao(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withDuracaoNull() {
        reuniaoDto.setDuracao(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withLinkNull() {
        reuniaoDto.setLink(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withDataHoraInicioNull() {
        reuniaoDto.setDataHoraInicio(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withFusoHorarioNull() {
        reuniaoDto.setFusoHorario(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withSenhaNull() {
        reuniaoDto.setSenha(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withVideoAnfitriaoAtividadeNull() {
        reuniaoDto.setVideoAnfitriaoAtivado(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withVideoParticipanteAtividadeNull() {
        reuniaoDto.setVideoParticipanteAtivado(null);
        return this;
    }

    @Override
    public ReuniaoBuilder withFoiRealizadaNull() {
        reuniaoDto.setFoiRealizada(null);
        return this;
    }
}
