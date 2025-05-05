package com.remedios.infra;

public record DadosTokenJWT(String token) { 
    public DadosTokenJWT(String token) {
        this.token = token;
    }
}
