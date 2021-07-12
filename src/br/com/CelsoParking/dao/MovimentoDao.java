package br.com.CelsoParking.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;

import br.com.CelsoParking.model.Movimento;
import br.com.CelsoParking.model.Veiculo;

public class MovimentoDao {

	private Movimento movimento;

	private static final String LOCAL_FILE = "C:/Users/gabri/movimentacao.ds1";

	public MovimentoDao(Movimento movimento) {
		this.movimento = movimento;

	}

	public MovimentoDao() {
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void salvar() {
		Path path = Paths.get(LOCAL_FILE);

		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.WRITE,
					StandardOpenOption.APPEND);

			writer.write(movimento.toString());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			System.out.println("Ocorreu um erro inesperado, e não foi possível gravar os dados.");
		}

	}

	public ArrayList<Movimento> listarMovimentos() {
		Path path = Paths.get("C:/Users/gabri/movimentacao.ds1");

		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

			String linha = reader.readLine();
			ArrayList<Movimento> movimentos = new ArrayList<Movimento>();

			while (linha != null) {
				
				String[] vetorMovimento = linha.split(";");

				Movimento movimento = new Movimento();
				Veiculo veiculo = new Veiculo();
					
				

					veiculo.setModelo(vetorMovimento[2]);
					veiculo.setPlaca(vetorMovimento[0]);
					movimento.setVeiculo(veiculo);

					movimento.setTempoSaida(LocalDateTime.now());
					movimento.setDataSaidaContainer();
					movimento.setHoraSaidaContainer();
					movimento.setCodigo(vetorMovimento[1]);
					movimento.setDataEntradaContainer(vetorMovimento[3]);
					movimento.setHoraEntradaContainer(vetorMovimento[4]);
					
					if (vetorMovimento[9].equals("false")) {
					movimentos.add(movimento);
					}

					linha = reader.readLine();
			}

			reader.close();

			return movimentos;

		} catch (Exception e) {
			System.out.println("Não foi possível ler o arquivo!!");
			e.printStackTrace();
			return null;

		}

	}

	public Movimento buscarMovimento(String placa) {

		Path path = Paths.get("C:/Users/gabri/movimentacao.ds1");

		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

			String linha = reader.readLine();
			Movimento movimento = new Movimento();
			Veiculo veiculo = new Veiculo();

			while (linha != null) {
				String[] vetorMovimento = linha.split(";");
				
				if (vetorMovimento[9].equals("true")) {
					movimento.setPago(true);
				}

				if (vetorMovimento[0].equals(placa.toUpperCase().replaceAll(" ",""))) {

					veiculo.setModelo(vetorMovimento[2]);
					veiculo.setPlaca(vetorMovimento[0]);
					movimento.setVeiculo(veiculo);

					movimento.setTempoSaida(LocalDateTime.now());
					movimento.setDataSaidaContainer();
					movimento.setHoraSaidaContainer();
					movimento.setCodigo(vetorMovimento[1]);
					movimento.setDataEntradaContainer(vetorMovimento[3]);
					movimento.setHoraEntradaContainer(vetorMovimento[4]);
					break;
				}

				linha = reader.readLine();
			}

			reader.close();

			return movimento;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace();
			return null;
		}
	}

}
