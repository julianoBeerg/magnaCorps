package br.com.magna.magnacorps.classes.associacao;

import java.util.Scanner;

import br.com.magna.magnacorps.classes.Corporacao;
import br.com.magna.magnacorps.interfaces.Porte;
import br.com.magna.magnacorps.main.TratamentoException;

public class Associacao extends Corporacao {

	String fundador;
	Integer arrecadacao;

	public Associacao(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador,
			Integer arrecadacao) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos);
		this.fundador = fundador;
		this.arrecadacao = arrecadacao;
	}

	// M�todo para fundar Instituic�o a partir do metodo feito na classe corpora��o
	public String fundarCorporacaoAssociacao() throws Exception {
		fundarCorporacao();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o nome do fundador: ");
		this.fundador = scan.nextLine();

		try {
			System.out.print("Digite o valor de arrecada��o (Apenas n�meros): ");
			this.arrecadacao = scan.nextInt();
		} catch (Exception e) {
			throw new TratamentoException("O Tipo deve ser n�merico");
		}
		return nome;
	}

	// Metodo sobrescrito, ja informando valor pois toda Institui��o tem fins
	// lucrativos
	@Override
	public void verificaFinsLucrativos() {
		getFinsLucrativos();
		setFinsLucrativos(false);
	}

	// Abaixo Apenas getters e setters
	public String getFundador() {
		return fundador;
	}

	public void setFundador(String fundador) {
		this.fundador = fundador;
	}

	public Integer getArrecadacao() {
		return arrecadacao;
	}

	public void setArrecadacao(Integer arrecadacao) {
		this.arrecadacao = arrecadacao;
	}
}
