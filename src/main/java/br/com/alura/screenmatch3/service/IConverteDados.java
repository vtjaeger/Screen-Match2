package br.com.alura.screenmatch3.service;

import br.com.alura.screenmatch3.model.DadosSerie;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
