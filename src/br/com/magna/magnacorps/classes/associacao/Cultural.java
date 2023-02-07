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
import br.com.magna.magnacorps.main.TratamentoException;

public class Cultural extends Associacao {

	private Double ativos;
	private Integer voluntarios;

	public Cultural(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador,
			Integer arrecadacao, Double ativos, Integer voluntarios) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, arrecadacao);
		this.ativos = ativos;
		this.voluntarios = voluntarios;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main

	public String fundarCorporacaoAssociacaoCultural() {
		fundarCorporacaoAssociacao();
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite a quantidade de ativos (Apenas números): ");
		this.ativos = scan.nextDouble();

		System.out.print("Digite a quantidade de voluntários (Apenas números): ");
		this.voluntarios = scan.nextInt();

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
				+ ", Arrecadação: " + getArrecadacao() + ", Ativos: " + getAtivos() + ", Voluntários: "
				+ getVoluntarios() + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoAssociacaoCultural() throws IOException, TratamentoException {
		List<Cultural> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Associacao\\CorporacaoAssociacaoCultural.txt";

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
				ativos = Double.parseDouble(vect[11]);
				voluntarios = Integer.parseInt(vect[12]);

				Cultural cultural = new Cultural(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(),
						tipo, multinacional, finsLucrativos, fundador, arrecadacao, ativos, voluntarios);

				list.add(cultural);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Associação Cultural: \n");

			if (!list.isEmpty()) {
				for (Cultural f : list) {
					System.out.println(f + "\n");
				}
			} else {
				throw new TratamentoException("A lista não contém nenhuma corporação cadastrada");
			}

		} catch (IOException e) {
			throw new TratamentoException("Erro ao criar lista");
		}
	}

	// Output para escrita dos objetos no CSV
	public void outputCorporacaoAssociacaoCultural() throws IOException {
		List<Cultural> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Associacao\\CorporacaoAssociacaoCultural.txt";

		Cultural cultural1 = new Cultural(path, path, path, voluntarios, ativos, porte, path, getMultinacional(),
				getFinsLucrativos(), path, voluntarios, ativos, voluntarios);

		cultural1.fundarCorporacaoAssociacaoCultural();

		list.add(cultural1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (Cultural cultural : list) {
				out.append(cultural.getNome());
				out.append(',');

				out.append(cultural.getNomeFantasia());
				out.append(',');

				out.append(cultural.getCnpj());
				out.append(',');

				out.append(Integer.toString(cultural.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(cultural.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(cultural.getTipo());
				out.append(',');

				out.append(Boolean.toString(cultural.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(cultural.getFinsLucrativos()));
				out.append(',');

				out.append(cultural.getFundador());
				out.append(',');

				out.append(Integer.toString(cultural.getArrecadacao()));
				out.append(',');

				out.append(Double.toString(cultural.getAtivos()));
				out.append(',');

				out.append(Integer.toString(cultural.getVoluntarios()));
				out.append(',');
				out.append('\n');
			}
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public Double getAtivos() {
		return ativos;
	}

	public void setAtivos(Double ativos) {
		this.ativos = ativos;
	}

	public Integer getVoluntarios() {
		return voluntarios;
	}

	public void setVoluntarios(Integer voluntarios) {
		this.voluntarios = voluntarios;
	}
}
