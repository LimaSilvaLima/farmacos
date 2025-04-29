package com.remedios.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.remedio.DadosAtualizarRemedio;
import com.remedios.remedio.DadosCadastroRemedio;
import com.remedios.remedio.DadosListagemRemedio;
import com.remedios.remedio.Remedio;
import com.remedios.remedio.RemedioRepository;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.experimental.var;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;
    @PostMapping
    @Transactional
    public void casdastrar(@RequestBody @Valid DadosCadastroRemedio dados){
       repository.save(new Remedio(dados));
    }
    
    @GetMapping
    public List<DadosListagemRemedio> listar() {
        return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar( @RequestBody @Valid DadosAtualizarRemedio dados) {
       var remedio = repository.getReferenceById(dados.id());
       remedio.atualizarInformacoes(dados);     
        
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
