package com.remedios.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.remedios.remedio.DadosCadastroRemedio;
import com.remedios.remedio.Remedio;
import com.remedios.remedio.RemedioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;
    @PostMapping
    public void casdastrar(@RequestBody DadosCadastroRemedio dados){
       
        repository.save(new Remedio(dados));
          
    }
}
