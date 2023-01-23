package br.com.magna.magnacorps.interfaces;

public enum Porte {
	MicroEmpreendedor(01), MicroEmpresa(02), EmpresaPequenoPorte(03), EmpresaMedioPorte(04), EmpresaGrandePorteII(05),
	EmpresaGrandePorteI(06);

	private final int valor;

	Porte(int opcao) {
		valor = opcao;
	}

	public int getPorte() {
		return valor;
	}

}
