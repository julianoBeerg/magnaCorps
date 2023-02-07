package br.com.magna.magnacorps.classes.associacao;

import java.util.Scanner;
import br.com.magna.magnacorps.classes.Corporacao;
import br.com.magna.magnacorps.interfaces.Porte;

public class Associacao extends Corporacao {

	protected String fundador;
	protected Integer arrecadacao;

	protected Associacao(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador,
			Integer arrecadacao) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos);
		this.fundador = fundador;
		this.arrecadacao = arrecadacao;
	}

	// Método para fundar Instituicão a partir do metodo feito na classe corporação
	protected String fundarCorporacaoAssociacao() {
		fundarCorporacao();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o nome do fundador: ");
		this.fundador = scan.nextLine();

		System.out.print("Digite o valor de arrecadação (Apenas números): ");
		this.arrecadacao = scan.nextInt();

		return nome;
	}

	// Metodo sobrescrito, ja informando valor pois toda Instituição tem fins
	// lucrativos
	@Override
	protected void verificaFinsLucrativos() {
		getFinsLucrativos();
		setFinsLucrativos(false);
	}

	// Abaixo Apenas getters e setters
	protected String getFundador() {
		return fundador;
	}

	protected void setFundador(String fundador) {
		this.fundador = fundador;
	}

	protected Integer getArrecadacao() {
		return arrecadacao;
	}

	protected void setArrecadacao(Integer arrecadacao) {
		this.arrecadacao = arrecadacao;
	}
}
