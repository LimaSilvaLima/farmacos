package com.remedios.remedio;

public record DadosCadastroRemedio(
    String nome,
    Via via,
    String lote,
    Integer  quantidade,
    String validade,
    Laboratorio laboratorio ) {

}
