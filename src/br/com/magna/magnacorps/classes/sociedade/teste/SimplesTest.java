package br.com.magna.magnacorps.classes.sociedade.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.sociedade.Simples;

public class SimplesTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Simples simples = new Simples(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
				testeBoolean, testeBoolean, testeString, testeInt, testeInt, testeString);

		assertEquals(simples.toString(), simples.toString());

	}

	@Test
	public void verificaInputCorporacaoSociedadeSimples() {
		List<Simples> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeSimples.txt";

		Simples simples = new Simples(path, path, path, null, null, null, path, null, null, path, null, null, path);

		list.add(simples);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoSociedadeSimples() throws IOException {
		List<Simples> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeSimples.txt";

		Simples simples = new Simples(path, path, path, 0, 0.0, null, path, null, null, path, null, null, path);

		list.add(simples);
		simples.inputCorporacaoSociedadeSimples();

		assertNotNull(simples);
	}
}
