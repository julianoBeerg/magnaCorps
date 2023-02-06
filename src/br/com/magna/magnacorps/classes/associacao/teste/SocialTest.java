package br.com.magna.magnacorps.classes.associacao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.magna.magnacorps.classes.associacao.Desportivo;
import br.com.magna.magnacorps.classes.associacao.Social;

public class SocialTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Desportivo desportivo = new Desportivo(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeInt, testeInt);

		assertEquals(desportivo.toString(), desportivo.toString());

	}

	@Test
	public void verificaInputCorporacaoInstituicaoDesportivo() throws Exception {
		List<Social> list = new ArrayList<Social>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoAssociacaoSocial.txt";

		Social social = new Social(path, path, path, null, null, null, path, null, null, 
				path, null, path, null, null);

		list.add(social);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoAssociacaoSocial() throws Exception {
		List<Social> list = new ArrayList<Social>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoAssociacaoSocial.txt";

		Social social = new Social(path, path, path, 0, 0.0, null, path,
				null, null, path, null, path, null, null);

		list.add(social);
		social.inputCorporacaoAssociacaoSocial();

		assertNotNull(social);
	}
}
