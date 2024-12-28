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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Page<ListarMedicoDTO>> listarMedicoDTOS(@PageableDefault(size = 5) Pageable page) {
        var result = medicoRepository.findAllByAtivoTrue(page).map(ListarMedicoDTO::new);
        return ResponseEntity.ok(result);//Deve Retorna um 200 ok
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new InformacaoMedicoDTO(medico));//Deve Retorna um 200 ok
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarDadosMedico(@RequestBody @Valid AtualizarDadosMedicoDTO dadosMedicoDTO) {
        var dadosNovos = medicoRepository.getReferenceById(dadosMedicoDTO.id());
        dadosNovos.atualizarDados(dadosMedicoDTO);

        return ResponseEntity.ok(new InformacaoMedicoDTO(dadosNovos));//Deve Retorna um 200 ok
    }

    @PostMapping
    @Transactional
    public ResponseEntity<InformacaoMedicoDTO> adicionarMedico(@RequestBody @Valid CadastroMedicoDTO cadastroMedicoDTO,
                                                               UriComponentsBuilder uriBuild) {
        var result = medicoRepository.save(new Medico(cadastroMedicoDTO));

        var URI = uriBuild.path("/medicos/{id}").buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(URI).body(new InformacaoMedicoDTO(result));//Deve Retorna 201 Created
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirMedico(@PathVariable Long id) {
        var medicoInativo = medicoRepository.getReferenceById(id);
        medicoInativo.inativarCadastro();
        return ResponseEntity.noContent().build();//Deve Retorna um 204 No Content
    }
}
