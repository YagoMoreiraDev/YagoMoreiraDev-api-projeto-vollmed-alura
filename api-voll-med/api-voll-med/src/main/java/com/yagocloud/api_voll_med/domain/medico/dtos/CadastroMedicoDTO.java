package com.yagocloud.api_voll_med.domain.medico.dtos;

import com.yagocloud.api_voll_med.domain.endereco.CadastroEnderecoDTO;
import com.yagocloud.api_voll_med.domain.medico.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroMedicoDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid //Para atributos do tipo classe/objeto
        CadastroEnderecoDTO cadastroEnderecoDTO) {
}
