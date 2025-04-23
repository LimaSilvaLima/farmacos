package com.remedios.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.remedio.DadosCadastroRemedio;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @RequestMapping
    public void casdastrar(@RequestBody DadosCadastroRemedio dados){
        System.out.println("Cadastrando remedio...");
        System.out.println("Remedio cadastrado com sucesso!");
        System.out.println(dados);
        System.out.println("Nome: " + dados.nome());  
    }
}
