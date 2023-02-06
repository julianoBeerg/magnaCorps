package br.com.magna.magnacorps.classes.teste;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.magna.magnacorps.classes.Corporacao;
import br.com.magna.magnacorps.interfaces.Porte;
import br.com.magna.magnacorps.main.TratamentoException;

public class CorporacaoTest {

	@Test
	public void deveriaRetornarEntre14e18Numeros() throws TratamentoException {
		Corporacao corporacao = new Corporacao(null, null, null, null, null, null, null, null, null) {
			@Override
			public void verificaFinsLucrativos() {
			}
		};
		String verificaCNPJ = corporacao.autentica("23.456.789/0001-01");
		Assert.assertEquals(18, verificaCNPJ.length());
	}

	@Test
	public void verificaSePorteRetornaEnumMicroEmpreendedor() {
		Corporacao corporacao = new Corporacao(null, null, null, 1, 10.0, null, null, null, null) {
			@Override
			public void verificaFinsLucrativos() {
			}
		};

		Porte porte = corporacao.enumPorte();
		Assert.assertEquals(porte, Porte.MicroEmpreendedor);
	}

	@Test
	public void verificaSePorteRetornaEnumMicroEmpresa() {
		Corporacao corporacao = new Corporacao(null, null, null, 10, 350.001, null, null, null, null) {
			@Override
			public void verificaFinsLucrativos() {
			}
		};

		Porte porte = corporacao.enumPorte();
		Assert.assertEquals(porte, Porte.MicroEmpresa);
	}

	@Test
	public void verificaSePorteRetornaEnumPequenoPorte() {
		Corporacao corporacao = new Corporacao(null, null, null, 101, 360.001, null, null, null, null) {
			@Override
			public void verificaFinsLucrativos() {
			}
		};

		Porte porte = corporacao.enumPorte();
		Assert.assertEquals(porte, Porte.EmpresaPequenoPorte);
	}

	@Test
	public void VerificaTipo() throws TratamentoException {
		Corporacao corporacao = new Corporacao(null, null, null, null, null, null, null, null, null) {
			@Override
			public void verificaFinsLucrativos() {
			}
		};
		corporacao.verificaTipo("PUBLICO");
		Assert.assertEquals(false, corporacao.getMultinacional());
	}

}
