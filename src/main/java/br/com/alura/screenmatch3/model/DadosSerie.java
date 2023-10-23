package br.com.alura.screenmatch3.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTempoeradas,
                         @JsonAlias("imdbRating") String avaliacao) {

    @Override
    public String toString() {
        return  "titulo='" + titulo  +
                ", totalTempoeradas=" + totalTempoeradas +
                ", avaliacao='" + avaliacao;
    }
}
