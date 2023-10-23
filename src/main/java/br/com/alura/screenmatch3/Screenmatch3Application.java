package br.com.alura.screenmatch3;

import br.com.alura.screenmatch3.model.DadosEpisodio;
import br.com.alura.screenmatch3.model.DadosSerie;
import br.com.alura.screenmatch3.service.ConsumoApi;
import br.com.alura.screenmatch3.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Screenmatch3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Screenmatch3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=eb0038c1");
		System.out.println(json);

		ConverteDados converteDados = new ConverteDados();


		DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		DadosEpisodio dadosEpisodio = converteDados.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

	}
}
