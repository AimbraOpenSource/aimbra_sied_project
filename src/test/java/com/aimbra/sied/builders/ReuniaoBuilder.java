package com.aimbra.sied.builders;

import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;

import java.time.LocalDateTime;

public class ReuniaoBuilder {

    private ReuniaoDto reuniaoDto;

    private ReuniaoBuilder() {
    }

    public static ReuniaoBuilder init() {
        ReuniaoBuilder rb = new ReuniaoBuilder();
        rb.reuniaoDto = new ReuniaoDto();
        rb.reuniaoDto.setFoiRealizada(false);
        rb.reuniaoDto.setVideoParticipanteAtivado(true);
        rb.reuniaoDto.setVideoAnfitriaoAtivado(true);
        rb.reuniaoDto.setSenha("123123123");
        rb.reuniaoDto.setFusoHorario("America/Sao_Paulo");
        rb.reuniaoDto.setDataHoraInicio(LocalDateTime.now());
        rb.reuniaoDto.setLink("Link example a ser adicionado");
        rb.reuniaoDto.setDuracao("60");
        rb.reuniaoDto.setDescricao("Aqui vai uma descrição a ser adicionada como exemplo a cunho de teste.");
        rb.reuniaoDto.setTopico("Aqui vai o topico a ser dicutido na reunião");
        rb.reuniaoDto.setId(1);
        return rb;
    }

    public ReuniaoDto build() {
        return reuniaoDto;
    }

    public ReuniaoBuilder withIdNull() {
        reuniaoDto.setId(null);
        return this;
    }

    public ReuniaoBuilder withTopicoNull() {
        reuniaoDto.setTopico(null);
        return this;
    }

    public ReuniaoBuilder withDescricaoNull() {
        reuniaoDto.setDescricao(null);
        return this;
    }

    public ReuniaoBuilder withDuracaoNull() {
        reuniaoDto.setDuracao(null);
        return this;
    }

    public ReuniaoBuilder withLinkNull() {
        reuniaoDto.setLink(null);
        return this;
    }

    public ReuniaoBuilder withDataHoraInicioNull() {
        reuniaoDto.setDataHoraInicio(null);
        return this;
    }

    public ReuniaoBuilder withFusoHorarioNull() {
        reuniaoDto.setFusoHorario(null);
        return this;
    }

    public ReuniaoBuilder withSenhaNull() {
        reuniaoDto.setSenha(null);
        return this;
    }

    public ReuniaoBuilder withVideoAnfitriaoAtividadeNull() {
        reuniaoDto.setVideoAnfitriaoAtivado(null);
        return this;
    }

    public ReuniaoBuilder withVideoParticipanteAtividadeNull() {
        reuniaoDto.setVideoParticipanteAtivado(null);
        return this;
    }

    public ReuniaoBuilder withFoiRealizadaNull() {
        reuniaoDto.setFoiRealizada(null);
        return this;
    }
}
