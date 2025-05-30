package com.remedios.remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(Long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade, int quantidade  ) {
    public DadosListagemRemedio(Remedio remedio) {
        this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(),  remedio.getLaboratorio(), remedio.getValidade(), remedio.getQuantidade());
    }
}