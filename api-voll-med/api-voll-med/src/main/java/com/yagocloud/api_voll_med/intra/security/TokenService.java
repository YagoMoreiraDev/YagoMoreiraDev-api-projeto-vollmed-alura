package com.yagocloud.api_voll_med.intra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.yagocloud.api_voll_med.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.password}")
    private String password;

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(password);
            return JWT.create()
                    .withIssuer("API Voll.med")//No geral aqui eu coloca a identificaçao da aplicacao
                    .withSubject(usuario.getLogin())//Aqui eu estou armazenando quem é o usuário logado
                    .withExpiresAt(dataExpiracaoToken( ))//Validade do token
                    .sign(algoritmo);
        } catch (JWTCreationException ex){
            throw new RuntimeException("Error ao gerar token jwt", ex);
        }
    }
    //Metodo para limitar o tempo que o token permanece valido
    private Instant dataExpiracaoToken( ) {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3:00"));
    }
}
