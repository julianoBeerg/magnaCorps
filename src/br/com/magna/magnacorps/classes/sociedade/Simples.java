package br.com.magna.magnacorps.classes.sociedade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.magna.magnacorps.interfaces.Porte;
import br.com.magna.magnacorps.main.TratamentoException;

public class Simples extends Sociedade {

	private Integer crea;
	private String area;

	// Construtor
	public Simples(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String sede, Integer sociosQuant,
			Integer crea, String area) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos, sede,
				sociosQuant);
		this.crea = crea;
		this.area = area;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	@SuppressWarnings("resource")
	public String fundarCorporacaoSociedadeSimples() throws Exception, TratamentoException {
		fundarCorporacaoSociedade();
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite a area de atuação: ");
		this.area = scan.nextLine();

		try {
			System.out.print("Digite o CREA (Apenas números): ");
			this.crea = scan.nextInt();
		} catch (Exception e) {
			throw new TratamentoException("O tipo deve ser númerico");
		}

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
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Sede: " + getSede()
				+ ", QuantSocios: " + getSociosQuant() + ", CREA: " + getCrea() + ", Area: " + getArea() + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoSociedadeSimples() throws IOException, TratamentoException {
		List<Simples> list = new ArrayList<Simples>();

		String path = "C:\\dev\\csvArchives\\Sociedade\\CorporacaoSociedadeSimples.txt";

		// Criando reader e utilizando padrão UTF-8
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
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
				String sede = vect[9];
				Integer sociosQuant = Integer.parseInt(vect[10]);
				Integer crea = Integer.parseInt(vect[11]);
				String area = vect[12];

				Simples simples = new Simples(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(), tipo,
						multinacional, finsLucrativos, sede, sociosQuant, crea, area);

				list.add(simples);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Sociedade Simples: \n");

			if (list.isEmpty() != true) {
				for (Simples f : list) {
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
	public void outputCorporacaoSociedadeSimples() throws Exception {
		String path = "C:\\dev\\csvArchives\\Sociedade\\CorporacaoSociedadeSimples.txt";
		List<Simples> list = new ArrayList<Simples>();

		Simples simples1 = new Simples(path, path, path, crea, getFaturamento(), porte, path, getMultinacional(),
				getFinsLucrativos(), path, crea, crea, path);

		simples1.fundarCorporacaoSociedadeSimples();

		list.add(simples1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"))) {

			for (Simples simples : list) {
				out.append(simples.getNome());
				out.append(',');

				out.append(simples.getNomeFantasia());
				out.append(',');

				out.append(simples.getCnpj());
				out.append(',');

				out.append(Integer.toString(simples.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(simples.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(simples.getTipo());
				out.append(',');

				out.append(Boolean.toString(simples.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(simples.getFinsLucrativos()));
				out.append(',');

				out.append(simples.getSede());
				out.append(',');

				out.append(Integer.toString(simples.getSociosQuant()));
				out.append(',');

				out.append(Integer.toString(simples.getCrea()));
				out.append(',');

				out.append(simples.getArea());
				out.append(',');
				out.append('\n');
			}
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public Integer getCrea() {
		return crea;
	}

	public void setCrea(Integer crea) {
		this.crea = crea;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
