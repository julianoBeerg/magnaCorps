package br.com.magna.magnacorps.classes.associacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.magna.magnacorps.interfaces.Porte;

public class Desportivo extends Associacao {

	private Integer quantInstalacoes;
	private Integer associados;

	public Desportivo(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador,
			Integer arrecadacao, Integer quantInstalacoes, Integer associados) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, arrecadacao);
		this.quantInstalacoes = quantInstalacoes;
		this.associados = associados;
	}

	// M?todo que utiliza metodo da classe Institui??o para criar um objeto do tipo:
	// (Corpora??o > Institui??o > Familiar)
	// N?o pode ser instaciado direto na Main
	public String fundarCorporacaoAssociacaoDesportivo() {
		fundarCorporacaoAssociacao();
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite a quantidade de instala??es (Apenas n?meros): ");
		this.quantInstalacoes = scan.nextInt();

		System.out.print("Digite a quantidade de associados (Apenas n?meros): ");
		this.associados = scan.nextInt();

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return nome;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Institui??o Economica: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Fundador: " + getFundador()
				+ ", Arrecada??o: " + getArrecadacao() + ", QuantInstala??es: " + getQuantInstacoes() + ", Associados: "
				+ getAssociados() + " ]";
	}

	// M?todo de input para ler arquivos CSV
	public void inputCorporacaoAssociacaoDesportivo() throws IOException {
		List<Desportivo> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Associacao\\CorporacaoAssociacaoDesportivo.txt";

		// Criando reader e utilizando padr?o UTF-8
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
			String line = br.readLine();

			// L? cada linha e adciona na list
			while (line != null) {
				String[] vect = line.split(",");
				String nome = vect[0];
				String nomeFantasia = vect[1];
				String cnpj = vect[2];
				Integer numFuncionarios = Integer.parseInt(vect[3]);
				Double faturamento = Double.parseDouble(vect[4]);
				@SuppressWarnings("unused")
				String porte = vect[5];
				String tipo = vect[6];
				Boolean multinacional = Boolean.parseBoolean(vect[7]);
				Boolean finsLucrativos = Boolean.parseBoolean(vect[8]);
				String fundador = vect[9];
				Integer arrecadacao = Integer.parseInt(vect[10]);
				quantInstalacoes = Integer.parseInt(vect[11]);
				associados = Integer.parseInt(vect[12]);

				Desportivo desportivo = new Desportivo(nome, nomeFantasia, cnpj, numFuncionarios, faturamento,
						getPorte(), tipo, multinacional, finsLucrativos, fundador, arrecadacao, quantInstalacoes,
						associados);

				list.add(desportivo);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corpara??o Associa??o Desportivo: \n");

			if (!list.isEmpty()) {
				for (Desportivo f : list) {
					System.out.println(f + "\n");
				}
			} else {
				System.out.println("A lista n?o cont?m nenhuma corpora??o cadastrada");
			}

		} catch (IOException e) {
			throw new NullPointerException();
		}
	}

	// Output para escrita dos objetos no CSV
	public void outputCorporacaoAssociacaoDesportivo() throws IOException {
		List<Desportivo> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Associacao\\CorporacaoAssociacaoDesportivo.txt";

		Desportivo desportivo1 = new Desportivo(path, path, path, associados, getFaturamento(), porte, path,
				getMultinacional(), getFinsLucrativos(), path, associados, quantInstalacoes, associados);

		desportivo1.fundarCorporacaoAssociacaoDesportivo();

		list.add(desportivo1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (Desportivo desportivo : list) {
				out.append(desportivo.getNome());
				out.append(',');

				out.append(desportivo.getNomeFantasia());
				out.append(',');

				out.append(desportivo.getCnpj());
				out.append(',');

				out.append(Integer.toString(desportivo.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(desportivo.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(desportivo.getTipo());
				out.append(',');

				out.append(Boolean.toString(desportivo.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(desportivo.getFinsLucrativos()));
				out.append(',');

				out.append(desportivo.getFundador());
				out.append(',');

				out.append(Integer.toString(desportivo.getArrecadacao()));
				out.append(',');

				out.append(Integer.toString(desportivo.getQuantInstacoes()));
				out.append(',');

				out.append(Integer.toString(desportivo.getAssociados()));
				out.append(',');
				out.append('\n');
			}
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public Integer getQuantInstacoes() {
		return quantInstalacoes;
	}

	public void setQuantInstacoes(Integer quantInstacoes) {
		this.quantInstalacoes = quantInstacoes;
	}

	public Integer getAssociados() {
		return associados;
	}

	public void setAssociados(Integer associados) {
		this.associados = associados;
	}

}
