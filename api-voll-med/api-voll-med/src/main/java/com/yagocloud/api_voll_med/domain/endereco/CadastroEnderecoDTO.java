package com.yagocloud.api_voll_med.domain.endereco;

import jakarta.validation.constraints.NotBlank;

public record CadastroEnderecoDTO(
        @NotBlank
        String logradouro,
        @NotBlank
        String numero,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,

        String complemento,
        @NotBlank
        String cidade,
        @NotBlank
        String uf) {
}
