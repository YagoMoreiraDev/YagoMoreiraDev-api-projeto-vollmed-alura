package com.yagocloud.api_voll_med.domain.medico.dtos;

import com.yagocloud.api_voll_med.domain.endereco.CadastroEnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizarDadosMedicoDTO(
        @NotNull
        Long id,

        String nome,
        String email,
        String telefone,
        CadastroEnderecoDTO cadastroEnderecoDTO) {
}
