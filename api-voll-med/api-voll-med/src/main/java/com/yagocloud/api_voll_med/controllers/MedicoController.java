package com.yagocloud.api_voll_med.controllers;

import com.yagocloud.api_voll_med.domain.medico.Medico;
import com.yagocloud.api_voll_med.domain.medico.MedicoRepository;
import com.yagocloud.api_voll_med.domain.medico.dtos.AtualizarDadosMedicoDTO;
import com.yagocloud.api_voll_med.domain.medico.dtos.CadastroMedicoDTO;
import com.yagocloud.api_voll_med.domain.medico.dtos.InformacaoMedicoDTO;
import com.yagocloud.api_voll_med.domain.medico.dtos.ListarMedicoDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<ListarMedicoDTO> listarMedicoDTOS(@PageableDefault(size = 5) Pageable page) {
        return medicoRepository.findAllByAtivoTrue(page).map(ListarMedicoDTO::new);
    }

    @GetMapping("/{id}")
    public InformacaoMedicoDTO buscarPorId(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return new InformacaoMedicoDTO(medico);
    }

    @PutMapping
    @Transactional
    public void atualizarDadosMedico(@RequestBody @Valid AtualizarDadosMedicoDTO dadosMedicoDTO) {
        var dadosNovos = medicoRepository.getReferenceById(dadosMedicoDTO.id());
        dadosNovos.atualizarDados(dadosMedicoDTO);
    }

    @PostMapping
    @Transactional
    public void adicionarMedico(@RequestBody @Valid CadastroMedicoDTO cadastroMedicoDTO) {
        medicoRepository.save(new Medico(cadastroMedicoDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        var medicoInativo = medicoRepository.getReferenceById(id);
        medicoInativo.inativarCadastro();
    }
}
