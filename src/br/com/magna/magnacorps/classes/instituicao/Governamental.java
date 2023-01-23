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

public class Governamental extends Instituicao {

	private Boolean federal;
	private String areaAtuacao;

	// Construtor
	public Governamental(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador, String diretor,
			String sede, Boolean federal, String areaAtuacao) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos,
				fundador, diretor, sede);
		this.federal = federal;
		this.areaAtuacao = areaAtuacao;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	@SuppressWarnings("resource")
	public String fundarCorporacaoInstituicaoGovernamental() throws Exception, TratamentoException {
		fundarCorporacaoInstituicao();

		Scanner scan = new Scanner(System.in);

		System.out.print("Digite SIM se a empresa for Federal ou NÃO se ela não for: ");
		String verifica = scan.next().toUpperCase();
		if (verifica.contains("SIM")) {
			federal = true;
		} else if (verifica.contains("NÃO") || verifica.contains("NAO")) {
			federal = false;
		} else {
			throw new TratamentoException("Preenche novamente com um valor válido !");
		}

		System.out.print("Digite a area de atuação: ");
		this.areaAtuacao = scan.next();

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return areaAtuacao;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Economica: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Fundador: " + getFundador()
				+ ", Diretor: " + getDiretor() + ", Sede: " + getSede() + ", Federal: " + federal + ", AreaAtuacao: "
				+ areaAtuacao + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoInstituicaoGovernamental() throws IOException, TratamentoException {
		List<Governamental> list = new ArrayList<Governamental>();

		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoGovernamental.txt";

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
				String fundador = vect[9];
				String diretor = vect[10];
				String sede = vect[11];
				Boolean federal = Boolean.parseBoolean(vect[12]);
				String areaAtuacao = vect[13];

				Governamental governamental = new Governamental(nome, nomeFantasia, cnpj, numFuncionarios, faturamento,
						getPorte(), tipo, multinacional, finsLucrativos, fundador, diretor, sede, federal, areaAtuacao);

				list.add(governamental);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Instituição Governamental: \n");

			if (list.isEmpty() != true) {
				for (Governamental f : list) {
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
	public void outputCorporacaoInstituicaoGovernamental() throws Exception {
		List<Governamental> list = new ArrayList<Governamental>();

		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoGovernamental.txt";

		Governamental governamental1 = new Governamental(path, path, path, numFuncionarios, getFaturamento(), porte,
				path, federal, federal, path, path, path, federal, path);

		governamental1.fundarCorporacaoInstituicaoGovernamental();

		list.add(governamental1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"))) {

			for (Governamental governamental : list) {
				out.append(governamental.getNome());
				out.append(',');

				out.append(governamental.getNomeFantasia());
				out.append(',');

				out.append(governamental.getCnpj());
				out.append(',');

				out.append(Integer.toString(governamental.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(governamental.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(governamental.getTipo());
				out.append(',');

				out.append(Boolean.toString(governamental.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(governamental.getFinsLucrativos()));
				out.append(',');

				out.append(governamental.getFundador());
				out.append(',');

				out.append(governamental.getDiretor());
				out.append(',');

				out.append(governamental.getSede());
				out.append(',');

				out.append(Boolean.toString(governamental.federal));
				out.append(',');

				out.append(governamental.getAreaAtuacao());
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
	public Boolean getFederal() {
		return federal;
	}

	public void setFederal(Boolean federal) {
		this.federal = federal;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
}
