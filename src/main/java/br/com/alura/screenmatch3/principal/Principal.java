package br.com.alura.screenmatch3.principal;

import br.com.alura.screenmatch3.model.DadosEpisodio;
import br.com.alura.screenmatch3.model.DadosSerie;
import br.com.alura.screenmatch3.model.DadosTemporada;
import br.com.alura.screenmatch3.service.ConsumoApi;
import br.com.alura.screenmatch3.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=eb0038c1";
    Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    public void exibeMenu(){
        System.out.println("Digite a série desejada:");
        var nomeSerie = scanner.nextLine();

        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for(int i = 1; i <= dados.totalTemporadas(); i++){
			json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+")
                    + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
        temporadas.forEach(System.out::println);

//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));



        List<DadosEpisodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());
    }
}
