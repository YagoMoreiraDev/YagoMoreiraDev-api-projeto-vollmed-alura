package com.yagocloud.api_voll_med.domain.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String bairro, String cep, String cidade, String uf, String complemento) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
    }

    public Endereco(CadastroEnderecoDTO cadastroEnderecoDTO) {
        this.logradouro = cadastroEnderecoDTO.logradouro();
        this.numero = cadastroEnderecoDTO.numero();
        this.bairro = cadastroEnderecoDTO.bairro();
        this.cep = cadastroEnderecoDTO.cep();
        this.cidade = cadastroEnderecoDTO.cidade();
        this.uf = cadastroEnderecoDTO.uf();
        this.complemento = cadastroEnderecoDTO.complemento();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
