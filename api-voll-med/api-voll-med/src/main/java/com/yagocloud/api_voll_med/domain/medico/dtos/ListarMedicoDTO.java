package com.yagocloud.api_voll_med.domain.medico.dtos;

import com.yagocloud.api_voll_med.domain.medico.Especialidade;
import com.yagocloud.api_voll_med.domain.medico.Medico;

public record ListarMedicoDTO(Long id, String nome, String telefone, Especialidade especialidade) {

    public ListarMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEspecialidade());
    }
}
