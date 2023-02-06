package br.com.magna.magnacorps.classes.associacao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.associacao.Cultural;

public class CulturalTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Cultural cultural = new Cultural(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeDouble, testeInt);

		assertEquals(cultural.toString(), cultural.toString());

	}

	@Test
	public void verificaInputCorporacaoAssociacaoCultural() throws Exception {
		List<Cultural> list = new ArrayList<Cultural>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoAssociacaoCultural.txt";

		Cultural cultural = new Cultural(path, path, path, 0, 0.0, null, path, null, null, path, null, null, null);

		list.add(cultural);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoAssociacaoCultural() throws Exception {
		List<Cultural> list = new ArrayList<Cultural>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoAssociacaoCultural.txt";

		Cultural cultural = new Cultural(path, path, path, 0, 0.0, null, path, null, null, path, null, null, null);

		list.add(cultural);
		cultural.inputCorporacaoAssociacaoCultural();

		assertNotNull(cultural);
	}
}
