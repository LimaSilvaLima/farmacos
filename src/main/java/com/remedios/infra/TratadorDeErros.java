package com.remedios.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import lombok.experimental.var;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratador404() {
        return ResponseEntity.notFound().build();
        //var erros = ex.getFieldErrors();
        //return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(MethodArgumentNotValidException ex)   {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacao::new).toList());
    }
    public record DadosErros(String message, String field ) {
        public DadosErros(FieldError erro) {
            this(erro.getDefaultMessage(), erro.getField());
        }
    }
    public record DadosErrosValidacao( String message, String field) {
        public DadosErrosValidacao(FieldError erro) {
            this(erro.getDefaultMessage(), erro.getField());
        }
    }   

}
