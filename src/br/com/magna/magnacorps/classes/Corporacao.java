package br.com.magna.magnacorps.classes;

import java.util.Scanner;
import br.com.magna.magnacorps.interfaces.AutenticaCNPJ;
import br.com.magna.magnacorps.interfaces.Porte;
import br.com.magna.magnacorps.main.TratamentoException;

public abstract class Corporacao implements AutenticaCNPJ {

	protected String nome;
	private String nomeFantasia;
	private String cnpj;
	protected Integer numFuncionarios;
	private Double faturamento;
	protected Porte porte;
	private String tipo;
	private Boolean multinacional;
	private Boolean finsLucrativos;

	// Construtor
	public Corporacao(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos) {
		super();
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.numFuncionarios = numFuncionarios;
		this.faturamento = faturamento;
		this.porte = porte;
		this.tipo = tipo;
		this.multinacional = multinacional;
		this.finsLucrativos = finsLucrativos;
	}

	// Método para validar se o tipo é público ou privado se for privado verifica se
	// é multinacional ou não
	protected String verificaTipo(String tipo) throws TratamentoException {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		if (tipo.contains("PUBLICO")) {
			multinacional = false;
		} else if (tipo.contains("PRIVADO")) {
			System.out.print("Digite SIM se a empresa for multinacional ou NÃO se ela for nacional: ");
			String verifica = scan.next().toUpperCase();
			if (verifica.contains("SIM")) {
				multinacional = true;
			} else if (verifica.contains("NÃO") || verifica.contains("NAO"))
				multinacional = false;
		} else {
			throw new TratamentoException("Uma corporação só pode ser pública ou privada");
		}
		return nome;
	}

	// Método que verifica se o CNPJ tem entre 14 e 17 caracteres (podendo ser
	// escrito de forma númerica ou com as pontuações)
	@Override
	public String autentica(String cnpj) throws TratamentoException {
		while (cnpj.length() < 14 || cnpj.length() > 18) {
			throw new TratamentoException("O CNPJ deve conter 14 ou 17 números, preencha o cadastro novamente");
		}
		return cnpj;
	}

	// Método utilizado para captar as informações no console e posteriormente fazer
	// o output no arquivo CSV
	public void fundarCorporacao() throws TratamentoException {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite nome: ");
		nome = scan.nextLine();

		System.out.print("Digite nome Fantasia: ");
		nomeFantasia = scan.nextLine();

		System.out.print("Digite cnpj (Entre 14 e 17 dígitos): ");
		cnpj = scan.next();
		autentica(cnpj);

		try {
			System.out.print("Digite número de funcionarios (Apenas números): ");
			this.numFuncionarios = scan.nextInt();
		} catch (Exception e) {
			throw new TratamentoException("O Tipo deve ser númerico");
		}

		try {
			System.out.print("Digite faturamento (Apenas números): ");
			this.faturamento = scan.nextDouble();
		} catch (Exception e) {
			throw new TratamentoException("O Tipo deve ser númerico");
		}

		try {
			System.out.print("Digite tipo (PUBLICO ou PRIVADO): ");
			tipo = scan.next().toUpperCase();
			verificaTipo(tipo);
		} catch (Exception e) {
			throw new TratamentoException("Uma corporação só pode ser pública ou privada");
		}
	}

	// Método que calcula o porte da empresa (Através do numero de funcionarios ou
	// faturamento
	public Porte enumPorte() {
		if (numFuncionarios == 1) {
			setPorte(Porte.MicroEmpreendedor);
		} else if (numFuncionarios > 1 && numFuncionarios <= 50 || faturamento <= 360.000) {
			setPorte(Porte.MicroEmpresa);
		} else if (numFuncionarios > 50 && numFuncionarios <= 1000
				|| faturamento > 360.000 && faturamento <= 4.800000) {
			setPorte(Porte.EmpresaPequenoPorte);
		} else if (numFuncionarios > 1000 && numFuncionarios <= 10000
				|| faturamento > 4.80000 && faturamento <= 20.000000) {
			setPorte(Porte.EmpresaMedioPorte);
		} else if (numFuncionarios > 10000 && numFuncionarios <= 100000
				|| faturamento > 20.00000 && faturamento <= 50.000000) {
			setPorte(Porte.EmpresaGrandePorteII);
		} else if (numFuncionarios > 100000 || faturamento > 50.00000) {
			setPorte(Porte.EmpresaGrandePorteI);
		}
		return porte;
	}

	// verifica se a empresa tem fins lucrativos ou não
	public abstract void verificaFinsLucrativos();

	// Abaixo Apenas getters e setters
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getNomeFantasia() {
		return nomeFantasia;
	}

	protected void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	protected String getCnpj() {
		return cnpj;
	}

	protected Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	protected void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	protected Double getFaturamento() {
		return faturamento;
	}

	protected void setFaturamento(Double faturamento) {
		this.faturamento = faturamento;
	}

	protected String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}

	protected Boolean getMultinacional() {
		return multinacional;
	}

	protected void setMultinacional(Boolean multinacional) {
		this.multinacional = multinacional;
	}

	protected Boolean getFinsLucrativos() {
		return finsLucrativos;
	}

	protected void setFinsLucrativos(Boolean finsLucrativos) {
		this.finsLucrativos = finsLucrativos;
	}

	protected Porte getPorte() {
		return enumPorte();
	}

	protected void setPorte(Porte porte) {
		this.porte = porte;
	}

}
