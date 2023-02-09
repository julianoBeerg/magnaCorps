package br.com.magna.magnacorps.classes.sociedade;

import java.util.Scanner;

import br.com.magna.magnacorps.classes.Corporacao;
import br.com.magna.magnacorps.interfaces.Porte;

public class Sociedade extends Corporacao {
	String sede;
	Integer sociosQuant;

	// Construtor
	public Sociedade(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String sede, Integer sociosQuant) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos);
		this.sede = sede;
		this.sociosQuant = sociosQuant;
		this.finsLucrativos = true;
	}

	// M�todo para fundar Instituic�o a partir do metodo feito na classe corpora��o
	public void fundarCorporacaoSociedade() {
		fundarCorporacao();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite sede: ");
		sede = scan.next();

			System.out.print("Digite a quantidade de s�cios (Apenas n�meros): ");
			this.sociosQuant = scan.nextInt();
	

	}



	// Abaixo Apenas getters e setters
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Integer getSociosQuant() {
		return sociosQuant;
	}

	public void setSociosQuant(Integer sociosQuant) {
		this.sociosQuant = sociosQuant;
	}
}
