package com.remedios.infra;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.remedios.usuarios.Usuario;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String gerarToken(Usuario usuario) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
            .withIssuer("farmacos")
            .withSubject(usuario.getLogin())
            .withExpiresAt(dataExpiracao())
            .sign(algorithm);
         } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
         }
    }

    public String getSubjetc(String TokenJWT){
        
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                 .withIssuer("farmacos")
                 .build()
                 .verify(TokenJWT)
                 .getSubject();
           
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado");
        }
    }

    private Instant dataExpiracao() {
       return Instant.now().plusSeconds(2 * 60 * 60); // 2 horas
    }
}
