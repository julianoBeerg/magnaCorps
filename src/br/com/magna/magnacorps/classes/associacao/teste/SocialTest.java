package br.com.magna.magnacorps.classes.associacao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
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
	public void verificaInputCorporacaoInstituicaoDesportivo() {
		List<Social> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Associacao\\CorporacaoAssociacaoSocial.txt";

		Social social = new Social(path, path, path, null, null, null, path, null, null, 
				path, null, path, null, null);

		list.add(social);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoAssociacaoSocial() throws IOException  {
		List<Social> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Associacao\\CorporacaoAssociacaoSocial.txt";

		Social social = new Social(path, path, path, 0, 0.0, null, path,
				null, null, path, null, path, null, null);

		list.add(social);
		social.inputCorporacaoAssociacaoSocial();

		assertNotNull(social);
	}
}
