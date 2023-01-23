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
	public void verificaSePorteRetornaEnumCorreto() {
		Corporacao corporacao = new Corporacao(null, null, null, 10, 10.0, null, null, null, null) {
			@Override
			public void verificaFinsLucrativos() {
			}
		};

		Porte porte = corporacao.enumPorte();
		Assert.assertEquals(porte, Porte.MicroEmpresa);
	}

}
