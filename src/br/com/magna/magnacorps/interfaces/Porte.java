package br.com.magna.magnacorps.interfaces;

public enum Porte {
	MICROEMPREENDEDOR(01), MICROEMPRESA(02), EMPRESAPEQUENOPORTE(03), 
	EMPRESAMEDIOPORTE(04), EMPRESAGRANDEPORTEII(05),
	EMPRESAGRANDEPORTEI(06);

	private final int valor;

	Porte(int opcao) {
		valor = opcao;
	}

	public int getPorte() {
		return valor;
	}

}
