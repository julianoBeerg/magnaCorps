package br.com.magna.magnacorps.classes.instituicao;

import java.util.Scanner;
import br.com.magna.magnacorps.classes.Corporacao;
import br.com.magna.magnacorps.interfaces.Porte;

public class Instituicao extends Corporacao {

	private String fundador;
	private String diretor;
	private String sede;

	// Construtor
	public Instituicao(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String fundador, String diretor,
			String sede) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional,
				finsLucrativos = true);
		this.fundador = fundador;
		this.diretor = diretor;
		this.sede = sede;
	}

	// Método para fundar Instituicão a partir do metodo feito na classe corporação
	public void fundarCorporacaoInstituicao() throws Exception {
		fundarCorporacao();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite fundador: ");
		fundador = scan.nextLine();

		System.out.print("Digite diretor: ");
		diretor = scan.nextLine();

		System.out.print("Digite sede: ");
		sede = scan.next();
	}

	// Metodo sobrescrito, ja informando valor pois toda Instituição tem fins
	// lucrativos
	@Override
	public void verificaFinsLucrativos() {
		getFinsLucrativos();
		setFinsLucrativos(true);
	}
	
	public Integer verificaInstituicoes(Integer opcaoInstituicao) {
		
		
		return opcaoInstituicao;
	}

	// Abaixo Apenas getters e setters
	protected String getFundador() {
		return fundador;
	}

	protected void setFundador(String fundador) {
		this.fundador = fundador;
	}

	protected String getDiretor() {
		return diretor;
	}

	protected void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	protected String getSede() {
		return sede;
	}

	protected void setSede(String sede) {
		this.sede = sede;
	}
}
