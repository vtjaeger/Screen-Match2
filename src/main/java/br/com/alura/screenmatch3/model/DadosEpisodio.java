package br.com.alura.screenmatch3.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") Integer numeroEpisodio,
                            @JsonAlias("imdbRating") String avaliacao,
                            @JsonAlias("Released") String dataLancamento){

//    @Override
//    public String toString() {
//        return  "Numero ep: " + numeroEpisodio +
//                "\nTitulo: " + titulo +
//                "\nAvaliacao: " + avaliacao +
//                "\n";
//    }
}
