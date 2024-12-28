package com.yagocloud.api_voll_med.controllers;

import com.yagocloud.api_voll_med.domain.medico.MedicoRepository;
import com.yagocloud.api_voll_med.domain.medico.dtos.InformacaoMedicoDTO;
import com.yagocloud.api_voll_med.domain.medico.dtos.ListarMedicoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
