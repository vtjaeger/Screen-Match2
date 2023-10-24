package br.com.alura.screenmatch3.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {

    @Override
    public String toString() {
        return  "\nTitulo: " + titulo +
                "\nTotal de temporadas: " + totalTemporadas +
                "\nAvaliacao: " + avaliacao;
    }
}
