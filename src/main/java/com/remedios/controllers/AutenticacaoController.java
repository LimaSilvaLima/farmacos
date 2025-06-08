package com.remedios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.remedios.infra.DadosTokenJWT;
import com.remedios.infra.TokenService;
import com.remedios.usuarios.DadosAutenticacao;
import com.remedios.usuarios.Usuario;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(token);
        
        var tokenJWT =tokenService.gerarToken((Usuario) autenticacao.getPrincipal()); 
        //return ResponseEntity.ok(tokenService.gerarToken((Usuario) autenticacao.getPrincipal()));
        return ResponseEntity.ok( new DadosTokenJWT(tokenJWT)); 

    }
}

