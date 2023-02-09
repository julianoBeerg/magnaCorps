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

public class Social extends Associacao {

	private String areaAtuacao;
	private Integer instalacoes;
	private Integer associados;

	public Social(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador,
			Integer arrecadacao, String areaAtuacao, Integer instalacoes, Integer associados) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, arrecadacao);
		this.areaAtuacao = areaAtuacao;
		this.instalacoes = instalacoes;
		this.associados = associados;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	public String fundarCorporacaoAssociacaoSocial() {
		fundarCorporacaoAssociacao();
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite a área de atuação: ");
		this.areaAtuacao = scan.nextLine();

		System.out.print("Digite a quantidade de instalações (Apenas números): ");
		this.instalacoes = scan.nextInt();

		System.out.print("Digite a quantidade de associados (Apenas números): ");
		this.associados = scan.nextInt();

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return nome;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Economica: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Fundador: " + getFundador()
				+ ", Arrecadação: " + getArrecadacao() + ", Area: " + getAreaAtuacao() + ", Instalacoes: "
				+ getInstalacoes() + ", Associados: " + getAssociados() + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoAssociacaoSocial() throws IOException {
		List<Social> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Associacao\\CorporacaoAssociacaoSocial.txt";

		// Criando reader e utilizando padrão UTF-8
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
			String line = br.readLine();

			// Lê cada linha e adciona na list
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
				areaAtuacao = vect[11];
				instalacoes = Integer.parseInt(vect[12]);
				associados = Integer.parseInt(vect[13]);

				Social social = new Social(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(), tipo,
						multinacional, finsLucrativos, fundador, arrecadacao, areaAtuacao, instalacoes, associados);

				list.add(social);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Associação Social: \n");

			if (!list.isEmpty()) {
				for (Social f : list) {
					System.out.println(f + "\n");
				}
			} else {
				System.out.println("A lista não contém nenhuma corporação cadastrada");
			}

		} catch (IOException e) {
			throw new NullPointerException();
		}
	}

	// Output para escrita dos objetos no CSV
	public void outputCorporacaoAssociacaoSocial() throws IOException {
		List<Social> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Associacao\\CorporacaoAssociacaoSocial.txt";

		Social social1 = new Social(path, path, path, associados, getFaturamento(), porte, path, getMultinacional(),
				getFinsLucrativos(), path, associados, path, instalacoes, associados);

		social1.fundarCorporacaoAssociacaoSocial();

		list.add(social1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (Social social : list) {
				out.append(social.getNome());
				out.append(',');

				out.append(social.getNomeFantasia());
				out.append(',');

				out.append(social.getCnpj());
				out.append(',');

				out.append(Integer.toString(social.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(social.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(social.getTipo());
				out.append(',');

				out.append(Boolean.toString(social.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(social.getFinsLucrativos()));
				out.append(',');

				out.append(social.getFundador());
				out.append(',');

				out.append(Integer.toString(social.getArrecadacao()));
				out.append(',');

				out.append(social.getAreaAtuacao());
				out.append(',');

				out.append(Integer.toString(social.getInstalacoes()));
				out.append(',');

				out.append(Integer.toString(social.getAssociados()));
				out.append(',');
				out.append('\n');
			}
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public Integer getInstalacoes() {
		return instalacoes;
	}

	public void setInstalacoes(Integer instalacoes) {
		this.instalacoes = instalacoes;
	}

	public Integer getAssociados() {
		return associados;
	}

	public void setAssociados(Integer associados) {
		this.associados = associados;
	}

}
