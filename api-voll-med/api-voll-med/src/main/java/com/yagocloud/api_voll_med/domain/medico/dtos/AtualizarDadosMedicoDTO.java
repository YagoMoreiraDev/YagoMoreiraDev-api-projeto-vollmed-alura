package com.yagocloud.api_voll_med.domain.medico.dtos;

import com.yagocloud.api_voll_med.domain.endereco.CadastroEnderecoDTO;

public record AtualizarDadosMedicoDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        CadastroEnderecoDTO cadastroEnderecoDTO) {
}
