package br.com.magna.magnacorps.classes.instituicao;

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

public class Economica extends Instituicao {

	private Integer clientes;
	private Integer acionistas;

	// Construtor
	public Economica(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador, String diretor,
			String sede, Integer clientes, Integer acionistas) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, diretor, sede);
		this.clientes = clientes;
		this.acionistas = acionistas;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	@SuppressWarnings("resource")
	public Integer fundarCorporacaoInstituicaoEconomica() throws Exception, TratamentoException {
		fundarCorporacaoInstituicao();

		Scanner scan = new Scanner(System.in);

		try {
			System.out.print("Digite número de clientes (Apenas números): ");
			this.clientes = scan.nextInt();
		} catch (Exception e) {
			throw new TratamentoException("O Tipo deve ser númerico");
		}

		try {
			System.out.print("Digite a quantidade de acionistas (Apenas números): ");
			this.acionistas = scan.nextInt();
		} catch (Exception e) {
			throw new TratamentoException("O Tipo deve ser númerico");
		}

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return clientes;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Economica: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Fundador: " + getFundador()
				+ ", Diretor: " + getDiretor() + ", Sede: " + getSede() + ", Clientes: " + clientes + ", Acionistas: "
				+ acionistas + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoInstituicaoEconomica() throws IOException, TratamentoException {
		List<Economica> list = new ArrayList<Economica>();

		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoEconomica.txt";
		// Criando reader e utilizando padrão UTF-8
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			String line = br.readLine();

			// Lê cada linha e adiciona na list
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
				Integer clientes = Integer.parseInt(vect[12]);
				Integer acionistas = Integer.parseInt(vect[13]);

				Economica economica = new Economica(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(),
						tipo, multinacional, finsLucrativos, fundador, diretor, sede, clientes, acionistas);

				list.add(economica);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Instituição Economica: \n");

			if (list.isEmpty() != true) {
				for (Economica f : list) {
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
	public void outputCorporacaoInstituicaoEconomica() throws Exception {
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoEconomica.txt";
		List<Economica> list = new ArrayList<Economica>();

		Economica economica1 = new Economica(path, path, path, acionistas, getFaturamento(), porte, path,
				getMultinacional(), getFinsLucrativos(), path, path, path, clientes, acionistas);

		economica1.fundarCorporacaoInstituicaoEconomica();

		list.add(economica1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"))) {

			for (Economica economica : list) {
				out.append(economica.getNome());
				out.append(',');

				out.append(economica.getNomeFantasia());
				out.append(',');

				out.append(economica.getCnpj());
				out.append(',');

				out.append(Integer.toString(economica.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(economica.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(economica.getTipo());
				out.append(',');

				out.append(Boolean.toString(economica.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(economica.getFinsLucrativos()));
				out.append(',');

				out.append(economica.getFundador());
				out.append(',');

				out.append(economica.getDiretor());
				out.append(',');

				out.append(economica.getSede());
				out.append(',');

				out.append(Integer.toString(economica.getClientes()));
				out.append(',');

				out.append(Integer.toString(economica.getInvestimento()));
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
	public Integer getClientes() {
		return clientes;
	}

	public void setClientes(Integer clientes) {
		this.clientes = clientes;
	}

	public Integer getInvestimento() {
		return acionistas;
	}

	public void setInvestimento(Integer investimento) {
		this.acionistas = investimento;
	}
}
