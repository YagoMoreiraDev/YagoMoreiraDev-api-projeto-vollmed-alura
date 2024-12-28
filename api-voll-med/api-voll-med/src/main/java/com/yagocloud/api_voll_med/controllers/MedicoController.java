package com.yagocloud.api_voll_med.controllers;

import com.yagocloud.api_voll_med.domain.medico.Medico;
import com.yagocloud.api_voll_med.domain.medico.MedicoRepository;
import com.yagocloud.api_voll_med.domain.medico.dtos.AtualizarDadosMedicoDTO;
import com.yagocloud.api_voll_med.domain.medico.dtos.CadastroMedicoDTO;
import com.yagocloud.api_voll_med.domain.medico.dtos.InformacaoMedicoDTO;
import com.yagocloud.api_voll_med.domain.medico.dtos.ListarMedicoDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //Meus repositories retornam EntidadeJPA e preciso converter para EntidadeDTO
    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @GetMapping
    public List<ListarMedicoDTO> listarMedicoDTOS() {
        return medicoRepository.findAll().stream().map(ListarMedicoDTO::new).toList();
    }

    @GetMapping("/{id}")
    public InformacaoMedicoDTO buscarPorId(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return new InformacaoMedicoDTO(medico);
    }

    @PutMapping
    @Transactional
    public void atualizarDadosMedico(@RequestBody AtualizarDadosMedicoDTO dadosMedicoDTO) {
        var dadosNovos = medicoRepository.getReferenceById(dadosMedicoDTO.id());
        dadosNovos.atualizarDados(dadosMedicoDTO);
    }

    @PostMapping
    @Transactional
    public void adicionarMedico(@RequestBody CadastroMedicoDTO cadastroMedicoDTO) {
        medicoRepository.save(new Medico(cadastroMedicoDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }
}
