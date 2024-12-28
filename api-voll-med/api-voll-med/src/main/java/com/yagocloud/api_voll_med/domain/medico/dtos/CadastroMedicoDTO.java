package com.yagocloud.api_voll_med.domain.medico.dtos;

import com.yagocloud.api_voll_med.domain.endereco.CadastroEnderecoDTO;
import com.yagocloud.api_voll_med.domain.medico.Especialidade;

public record CadastroMedicoDTO(String nome, String email, String telefone, String crm, Especialidade especialidade, CadastroEnderecoDTO cadastroEnderecoDTO) {
}
