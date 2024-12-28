package com.yagocloud.api_voll_med.domain.medico;

import com.yagocloud.api_voll_med.domain.endereco.CadastroEnderecoDTO;
import com.yagocloud.api_voll_med.domain.endereco.Endereco;
import com.yagocloud.api_voll_med.domain.medico.dtos.CadastroMedicoDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico() {
    }

    public Medico(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public Medico(CadastroMedicoDTO cadastroMedicoDTO) {
        this.nome = cadastroMedicoDTO.nome();
        this.email = cadastroMedicoDTO.email();
        this.crm = cadastroMedicoDTO.crm();
        this.especialidade = cadastroMedicoDTO.especialidade();
        this.endereco = new Endereco(cadastroMedicoDTO.cadastroEnderecoDTO());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
