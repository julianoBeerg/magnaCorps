package br.com.magna.magnacorps.classes.instituicao;

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

public class Ensino extends Instituicao {

	private String grau;
	private Integer quantAlunos;

	// Construtor
	public Ensino(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador, String diretor,
			String sede, String grau, Integer quantAlunos) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, diretor, sede);
		this.grau = grau;
		this.quantAlunos = quantAlunos;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main

	public String fundarCorporacaoInstituicaoEnsino() {
		fundarCorporacaoInstituicao();
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o grau que a instituição ensina: ");
		this.grau = scan.nextLine();

		System.out.print("Digite a quantidade de Alunos: ");
		this.quantAlunos = scan.nextInt();

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return grau;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Economica: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Fundador: " + getFundador()
				+ ", Diretor: " + getDiretor() + ", Sede: " + getSede() + ", Grau: " + grau + ", QuantAlunos: "
				+ quantAlunos + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoInstituicaoEnsino() throws IOException{
		List<Ensino> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoEnsino.txt";

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
				String diretor = vect[10];
				String sede = vect[11];
				grau = vect[12];
				quantAlunos = Integer.parseInt(vect[13]);

				Ensino ensino = new Ensino(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(), tipo,
						multinacional, finsLucrativos, fundador, diretor, sede, grau, quantAlunos);

				list.add(ensino);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Instituição Ensino: \n");

			if (!list.isEmpty()) {
				for (Ensino f : list) {
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
	public void outputCorporacaoInstituicaoEnsino() {
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoEnsino.txt";
		List<Ensino> list = new ArrayList<>();

		Ensino ensino1 = new Ensino(path, path, path, quantAlunos, getFaturamento(), porte, path, getMultinacional(),
				getFinsLucrativos(), path, path, path, path, quantAlunos);

		ensino1.fundarCorporacaoInstituicaoEnsino();

		list.add(ensino1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (Ensino ensino : list) {
				out.append(ensino.getNome());
				out.append(',');

				out.append(ensino.getNomeFantasia());
				out.append(',');

				out.append(ensino.getCnpj());
				out.append(',');

				out.append(Integer.toString(ensino.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(ensino.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(ensino.getTipo());
				out.append(',');

				out.append(Boolean.toString(ensino.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(ensino.getFinsLucrativos()));
				out.append(',');

				out.append(ensino.getFundador());
				out.append(',');

				out.append(ensino.getDiretor());
				out.append(',');

				out.append(ensino.getSede());
				out.append(',');

				out.append(ensino.getGrau());
				out.append(',');

				out.append(Integer.toString(ensino.getQuantAlunos()));
				out.append(',');
				out.append('\n');
			}
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

	public Integer getQuantAlunos() {
		return quantAlunos;
	}

	public void setQuantAlunos(Integer quantAlunos) {
		this.quantAlunos = quantAlunos;
	}
}
