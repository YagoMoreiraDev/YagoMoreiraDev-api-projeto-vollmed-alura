package com.yagocloud.api_voll_med.intra.security;

import com.yagocloud.api_voll_med.domain.usuario.UsuarioControllerDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioControllerDTO usuarioControllerDTO) {
        var autenticaToken = new UsernamePasswordAuthenticationToken(
                usuarioControllerDTO.login(),
                usuarioControllerDTO.senha());
        var autenticacao = authenticationManager.authenticate(autenticaToken);

        return ResponseEntity.ok().build();
    }
}
