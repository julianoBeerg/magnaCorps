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

public class Familiar extends Instituicao {

	private String familia;
	private String presidente;

	// Construtor
	public Familiar(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador, String diretor,
			String sede, String familia, String presidente) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, diretor, sede);
		this.familia = familia;
		this.presidente = presidente;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	public String fundarCorporacaoInstituicaoFamiliar(){
		fundarCorporacaoInstituicao();

		Scanner scan = new Scanner(System.in);

		System.out.print("Digite familia: ");
		familia = scan.nextLine();

		System.out.print("Digite presidente: ");
		presidente = scan.nextLine();

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return familia;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Familiar: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Fundador: " + getFundador()
				+ ", Diretor: " + getDiretor() + ", Sede: " + getSede() + ", Familia: " + familia + ", Presidente: "
				+ presidente + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoInstituicaoFamiliar() throws IOException{
		List<Familiar> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoFamiliar.txt";
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
				familia = vect[12];
				presidente = vect[13];

				Familiar familiar = new Familiar(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(),
						tipo, multinacional, finsLucrativos, fundador, diretor, sede, familia, presidente);

				list.add(familiar);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Instituição Familiar: \n");

			if (!list.isEmpty()) {
				for (Familiar f : list) {
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
	public void outputCorporacaoInstituicaoFamiliar() {
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoFamiliar.txt";
		List<Familiar> list = new ArrayList<>();

		Familiar familiar = new Familiar(familia, familia, familia, getNumFuncionarios(), getFaturamento(), porte,
				familia, getMultinacional(), getFinsLucrativos(), familia, familia, familia, familia, presidente);
		familiar.fundarCorporacaoInstituicaoFamiliar();
		list.add(familiar);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (Familiar familiarList : list) {
				out.append(familiarList.getNome());
				out.append(',');

				out.append(familiarList.getNomeFantasia());
				out.append(',');

				out.append(familiarList.getCnpj());
				out.append(',');

				out.append(Integer.toString(familiarList.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(familiarList.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(familiarList.getTipo());
				out.append(',');

				out.append(Boolean.toString(familiarList.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(familiarList.getFinsLucrativos()));
				out.append(',');

				out.append(familiarList.getFundador());
				out.append(',');

				out.append(familiarList.getDiretor());
				out.append(',');

				out.append(familiarList.getSede());
				out.append(',');

				out.append(familiarList.getFamilia());
				out.append(',');

				out.append(familiarList.getPresidente());
				out.append(',');
				out.append('\n');
			}
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
}
