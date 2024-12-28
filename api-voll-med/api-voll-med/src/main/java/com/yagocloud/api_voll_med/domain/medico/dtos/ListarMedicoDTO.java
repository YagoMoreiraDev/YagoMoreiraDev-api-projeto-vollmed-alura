package com.yagocloud.api_voll_med.domain.medico.dtos;

import com.yagocloud.api_voll_med.domain.medico.Especialidade;
import com.yagocloud.api_voll_med.domain.medico.Medico;

public record ListarMedicoDTO(String nome, Especialidade especialidade) {

    public ListarMedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEspecialidade());
    }
}
