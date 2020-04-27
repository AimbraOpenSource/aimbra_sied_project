package com.aimbra.sied.builders.interfaces;

import com.aimbra.sied.domain.sied.dtos.ReuniaoDto;

public interface ReuniaoBuilder {
    ReuniaoDto build();
    ReuniaoBuilder withIdNull();
    ReuniaoBuilder withTopicoNull();
    ReuniaoBuilder withDescricaoNull();
    ReuniaoBuilder withDuracaoNull();
    ReuniaoBuilder withLinkNull();
    ReuniaoBuilder withDataHoraInicioNull();
    ReuniaoBuilder withFusoHorarioNull();
    ReuniaoBuilder withSenhaNull();
    ReuniaoBuilder withVideoAnfitriaoAtividadeNull();
    ReuniaoBuilder withVideoParticipanteAtividadeNull();
    ReuniaoBuilder withFoiRealizadaNull();
}
