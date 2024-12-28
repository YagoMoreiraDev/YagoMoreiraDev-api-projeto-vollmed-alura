package com.yagocloud.api_voll_med.domain.medico.dtos;

import com.yagocloud.api_voll_med.domain.endereco.Endereco;
import com.yagocloud.api_voll_med.domain.medico.Especialidade;
import com.yagocloud.api_voll_med.domain.medico.Medico;

public record InformacaoMedicoDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        Endereco endereco) {

    public InformacaoMedicoDTO(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}
