package com.aimbra.sied.domain.sied.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class AtividadeDto {
    private Integer id;
    private String titulo;
    private String descricao;
    private AulaDto aula;

    @Getter
    private LocalDateTime criadoEm;

    @Getter
    private LocalDateTime liberadoEm;

    public AulaConfiguracaoDto getConfiguracao() {
        return aula.getConfiguracao();
    }

    public ReuniaoDto getReuniao() {
        return aula.getReuniao();
    }

    public void setReuniao(ReuniaoDto reuniao) {
        aula.setReuniao(reuniao);
    }
}
