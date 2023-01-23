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

public class Comandita extends Sociedade {
	private String diretor;
	private String area;
	private Integer quantAcoes;

	public Comandita(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String sede, Integer sociosQuant,
			String diretor, String area, Integer quantAcoes) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos, sede,
				sociosQuant);
		this.diretor = diretor;
		this.area = area;
		this.quantAcoes = quantAcoes;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	@SuppressWarnings("resource")
	public String fundarCorporacaoSociedadeComandita() throws Exception, TratamentoException {
		fundarCorporacaoSociedade();
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o diretor: ");
		this.diretor = scan.nextLine();

		System.out.print("Digite a area de atuação: ");
		this.area = scan.nextLine();

		try {
			System.out.print("Digite a quantidade de ações (Apenas números): ");
			this.quantAcoes = scan.nextInt();
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
				+ ", QuantSocios: " + getSociosQuant() + ", Diretor: " + getDiretor() + ", Area: " + getArea()
				+ ", QuantAcoes: " + getQuantAcoes() + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoSociedadeComandita() throws IOException, TratamentoException {
		List<Comandita> list = new ArrayList<Comandita>();

		String path = "C:\\dev\\csvArchives\\Sociedade\\CorporacaoSociedadeComandita.txt";

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
				String diretor = vect[11];
				String area = vect[12];
				Integer quantAcoes = Integer.parseInt(vect[13]);

				Comandita comandita = new Comandita(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(),
						tipo, multinacional, finsLucrativos, sede, sociosQuant, diretor, area, quantAcoes);

				list.add(comandita);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Sociedade Comandita: \n");

			if (list.isEmpty() != true) {
				for (Comandita f : list) {
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
	public void outputCorporacaoSociedadeComandita() throws Exception {
		List<Comandita> list = new ArrayList<Comandita>();

		String path = "C:\\dev\\csvArchives\\Sociedade\\CorporacaoSociedadeComandita.txt";

		Comandita comandita1 = new Comandita(path, path, path, quantAcoes, getFaturamento(), porte, path,
				getMultinacional(), getFinsLucrativos(), path, quantAcoes, path, path, quantAcoes);

		comandita1.fundarCorporacaoSociedadeComandita();

		list.add(comandita1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"))) {

			for (Comandita comandita : list) {
				out.append(comandita.getNome());
				out.append(',');

				out.append(comandita.getNomeFantasia());
				out.append(',');

				out.append(comandita.getCnpj());
				out.append(',');

				out.append(Integer.toString(comandita.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(comandita.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(comandita.getTipo());
				out.append(',');

				out.append(Boolean.toString(comandita.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(comandita.getFinsLucrativos()));
				out.append(',');

				out.append(comandita.getSede());
				out.append(',');

				out.append(Integer.toString(comandita.getSociosQuant()));
				out.append(',');

				out.append(comandita.getDiretor());
				out.append(',');

				out.append(comandita.getArea());
				out.append(',');

				out.append(Integer.toString(comandita.getQuantAcoes()));
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
	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getQuantAcoes() {
		return quantAcoes;
	}

	public void setQuantAcoes(Integer quantAcoes) {
		this.quantAcoes = quantAcoes;
	}

}
