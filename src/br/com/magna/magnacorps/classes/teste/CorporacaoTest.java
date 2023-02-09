package br.com.magna.magnacorps.classes.teste;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.magna.magnacorps.classes.Corporacao;
import br.com.magna.magnacorps.interfaces.Porte;

public class CorporacaoTest {

	@Test
	public void deveriaRetornarEntre14e18Numeros() {
		Corporacao corporacao = new Corporacao(null, null, null, null, null, null, null, null, null) {
			
		};
		String verificaCNPJ = corporacao.autentica("23.456.789/0001-01");
		Assert.assertEquals(18, verificaCNPJ.length());
	}

	@Test
	public void verificaSePorteRetornaEnumMicroEmpreendedor() {
		Corporacao corporacao = new Corporacao(null, null, null, 1, 10.0, null, null, null, null) {
			
		};

		Porte porte = corporacao.enumPorte();
		Assert.assertEquals(porte, Porte.MICROEMPREENDEDOR);
	}

	@Test
	public void verificaSePorteRetornaEnumMicroEmpresa() {
		Corporacao corporacao = new Corporacao(null, null, null, 10, 350.001, null, null, null, null) {
			
		};
		

		Porte porte = corporacao.enumPorte();
		Assert.assertEquals(porte, Porte.MICROEMPRESA);
	}

	@Test
	public void verificaSePorteRetornaEnumPequenoPorte() {
		Corporacao corporacao = new Corporacao(null, null, null, 101, 360.001, null, null, null, null) {
			
		};

		Porte porte = corporacao.enumPorte();
		Assert.assertEquals(porte, Porte.EMPRESAPEQUENOPORTE);
	}

	@Test
	public void verificaTipoPublico() {
		Corporacao corporacao = new Corporacao(null, null, null, null, null, null, null, null, null) {
			
		};
		corporacao.verificaTipo("PUBLICO");
		Assert.assertEquals(false, corporacao.getMultinacional());
	}
	
	@Test
	public void verificaTipoPRIVADOSIM() {
		Corporacao corporacao = new Corporacao(null, null, null, null, null, null, null, null, null) {
			
		};		
		corporacao.verificaTipo("PRIVADO");
		Assert.assertEquals(true, corporacao.getMultinacional());
	}
	
	@Test
	public void verificaTipoPRIVADONAO() {
		Corporacao corporacao = new Corporacao(null, null, null, null, null, null, null, null, null) {
			
		};		
		
		corporacao.verificaTipo("PRIVADO");
		Assert.assertEquals(false, corporacao.getMultinacional());
	}

}
