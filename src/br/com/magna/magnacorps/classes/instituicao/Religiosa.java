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

public class Religiosa extends Instituicao {

	private String representante;
	private String nomeReligiao;

	// Construtor
	public Religiosa(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador, String diretor,
			String sede, String representante, String nomeReligiao) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, diretor, sede);
		this.representante = representante;
		this.nomeReligiao = nomeReligiao;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	public String fundarCorporacaoInstituicaoReligiosa()  {
		fundarCorporacaoInstituicao();

		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o nome do representante: ");
		representante = scan.nextLine();

		System.out.print("Digite o nome da Religião: ");
		nomeReligiao = scan.next();

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return nomeReligiao;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Familiar: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Fundador: " + getFundador()
				+ ", Diretor: " + getDiretor() + ", Sede: " + getSede() + ", Representante: " + representante
				+ ", NomeReligiao: " + nomeReligiao + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoInstituicaoReligiosa() throws IOException {
		List<Religiosa> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoReligiosa.txt";
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
				representante = vect[12];
				nomeReligiao = vect[13];

				Religiosa religiosa = new Religiosa(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(),
						tipo, multinacional, finsLucrativos, fundador, diretor, sede, representante, nomeReligiao);

				list.add(religiosa);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Instituição Regiliosa: \n");

			if (!list.isEmpty()) {
				for (Religiosa f : list) {
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
	public void outputCorporacaoInstituicaoReligiosa() {
		List<Religiosa> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoReligiosa.txt";

		Religiosa religiosa1 = new Religiosa(path, path, path, numFuncionarios, getFaturamento(), porte, path,
				getMultinacional(), getFinsLucrativos(), path, path, path, path, path);
		religiosa1.fundarCorporacaoInstituicaoReligiosa();
		list.add(religiosa1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (Religiosa religiosa : list) {
				out.append(religiosa.getNome());
				out.append(',');

				out.append(religiosa.getNomeFantasia());
				out.append(',');

				out.append(religiosa.getCnpj());
				out.append(',');

				out.append(Integer.toString(religiosa.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(religiosa.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(religiosa.getTipo());
				out.append(',');

				out.append(Boolean.toString(religiosa.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(religiosa.getFinsLucrativos()));
				out.append(',');

				out.append(religiosa.getFundador());
				out.append(',');

				out.append(religiosa.getDiretor());
				out.append(',');

				out.append(religiosa.getSede());
				out.append(',');

				out.append(religiosa.getRepresentante());
				out.append(',');

				out.append(religiosa.getNomeReligiao());
				out.append(',');
				out.append('\n');
			}
			out.flush();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getNomeReligiao() {
		return nomeReligiao;
	}

	public void setNomeReligiao(String nomeReligiao) {
		this.nomeReligiao = nomeReligiao;
	}

}
