package br.com.magna.magnacorps.classes.associacao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.associacao.Desportivo;
import br.com.magna.magnacorps.classes.associacao.Social;

public class DesportivoTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Social social = new Social(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
				testeBoolean, testeBoolean, testeString, testeInt, testeString, testeInt, testeInt);

		assertEquals(social.toString(), social.toString());

	}

	@Test
	public void verificaInputCorporacaoAssociacaoDesportivo() {
		List<Desportivo> list = new ArrayList<>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoAssociacaoSocial.txt";

		Desportivo desportivo = new Desportivo(path, path, path, 0, 0.0, null, path, null, null, path, null, null,
				null);

		list.add(desportivo);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoAssociacaoDesportivo() throws Exception {
		List<Desportivo> list = new ArrayList<>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoAssociacaoDesportivo.txt";

		Desportivo desportivo = new Desportivo(path, path, path, 0, 0.0, null, path, null, null, path, null, null,
				null);

		list.add(desportivo);
		desportivo.inputCorporacaoAssociacaoDesportivo();

		assertNotNull(desportivo);
	}
}
