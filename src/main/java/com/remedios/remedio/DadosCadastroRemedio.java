package com.remedios.remedio;

public record DadosCadastroRemedio(
    String nome,
    Via via,
    Integer lote,
    Integer  quantidade,
    String validade,
    Laboratorio laboratorio ) {

}
