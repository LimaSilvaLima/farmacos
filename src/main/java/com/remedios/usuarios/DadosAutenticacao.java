package com.remedios.usuarios;

public record DadosAutenticacao(String login, String senha) {
     public DadosAutenticacao(String login, String senha) {
         this.login = login;
         this.senha = senha;
     }

}
