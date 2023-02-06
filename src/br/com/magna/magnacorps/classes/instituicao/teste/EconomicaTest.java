package br.com.magna.magnacorps.classes.instituicao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.instituicao.Economica;

public class EconomicaTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Economica economica = new Economica(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeInt, testeInt);

		assertEquals(economica.toString(), economica.toString());

	}

	@Test
	public void verificaInputCorporacaoInstituicaoEconomica() throws Exception {
		List<Economica> list = new ArrayList<Economica>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoEconomica.txt";

		Economica economica = new Economica(path, path, path, null, null, null, path, null, null, path, path, path,
				null, null);

		list.add(economica);
		assertEquals(list, list);
	}
	
	@Test
	public void verificaOutputCorporacaoInstituicaoEconomica() throws Exception {
		List<Economica> list = new ArrayList<Economica>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoEconomica.txt";

		Economica economica = new Economica(path, path, path, 0, 0.0, null, path,
				null, null, path, null, path, null, null);

		list.add(economica);
		economica.inputCorporacaoInstituicaoEconomica();

		assertNotNull(economica);
	}
}
