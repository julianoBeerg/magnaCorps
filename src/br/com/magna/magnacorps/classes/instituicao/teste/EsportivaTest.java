package br.com.magna.magnacorps.classes.instituicao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.instituicao.Esportiva;

public class EsportivaTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Esportiva esportiva = new Esportiva(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString, testeInt);

		assertEquals(esportiva.toString(), esportiva.toString());
	}

	@Test
	public void verificaInputCorporacaoInstituicaoEsportiva() throws Exception {
		List<Esportiva> list = new ArrayList<Esportiva>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoEsportiva.txt";

		Esportiva esportiva = new Esportiva(path, path, path, null, null, null, path, null, null, path, path, path,
				path, null);

		list.add(esportiva);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoInstituicaoEsportiva() throws Exception {
		List<Esportiva> list = new ArrayList<Esportiva>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoEsportiva.txt";

		Esportiva esportiva = new Esportiva(path, path, path, 0, 0.0, null, path, null, null, path, null, path, null,
				null);

		list.add(esportiva);
		esportiva.inputCorporacaoInstituicaoEsportiva();

		assertNotNull(esportiva);
	}
}
