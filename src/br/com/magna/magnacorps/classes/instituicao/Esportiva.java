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

public class Esportiva extends Instituicao {

	private String area;
	private Integer atletas;

	// Construtor
	public Esportiva(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador, String diretor,
			String sede, String area, Integer atletas) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, diretor, sede);
		this.area = area;
		this.atletas = atletas;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	public String fundarCorporacaoInstituicaoEsportiva() {
		fundarCorporacaoInstituicao();

		Scanner scan = new Scanner(System.in);

		System.out.print("Digite a area de atuação: ");
		this.area = scan.nextLine();

			System.out.print("Digite a quantidade de atletas (Apenas números): ");
			this.atletas = scan.nextInt();
	
		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return area;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Economica: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Fundador: " + getFundador()
				+ ", Diretor: " + getDiretor() + ", Sede: " + getSede() + ", Area: " + area + ", QuantAtletas: "
				+ atletas + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoInstituicaoEsportiva() throws IOException{
		List<Esportiva> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoEsportiva.txt";

		// Criando reader e utilizando padrão UTF-8
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
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
				area = vect[12];
				atletas = Integer.parseInt(vect[13]);

				Esportiva esportiva = new Esportiva(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(),
						tipo, multinacional, finsLucrativos, fundador, diretor, sede, area, atletas);

				list.add(esportiva);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Instituição Esportiva: \n");

			if (!list.isEmpty()) {
				for (Esportiva f : list) {
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
	public void outputCorporacaoInstituicaoEsportiva() {
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoEsportiva.txt";
		List<Esportiva> list = new ArrayList<>();

		Esportiva esportiva1 = new Esportiva(path, path, path, atletas, getFaturamento(), porte, path,
				getMultinacional(), getFinsLucrativos(), path, path, path, path, atletas);

		esportiva1.fundarCorporacaoInstituicaoEsportiva();

		list.add(esportiva1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (Esportiva esportiva : list) {
				out.append(esportiva.getNome());
				out.append(',');

				out.append(esportiva.getNomeFantasia());
				out.append(',');

				out.append(esportiva.getCnpj());
				out.append(',');

				out.append(Integer.toString(esportiva.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(esportiva.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(esportiva.getTipo());
				out.append(',');

				out.append(Boolean.toString(esportiva.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(esportiva.getFinsLucrativos()));
				out.append(',');

				out.append(esportiva.getFundador());
				out.append(',');

				out.append(esportiva.getDiretor());
				out.append(',');

				out.append(esportiva.getSede());
				out.append(',');

				out.append(esportiva.getArea());
				out.append(',');

				out.append(Integer.toString(esportiva.getAtletas()));
				out.append(',');
				out.append('\n');
			}
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getAtletas() {
		return atletas;
	}

	public void setAtletas(Integer atletas) {
		this.atletas = atletas;
	}
}
