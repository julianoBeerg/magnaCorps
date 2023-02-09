package br.com.magna.magnacorps.classes.sociedade.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.sociedade.Anonima;
import br.com.magna.magnacorps.classes.sociedade.Simples;

public class AnonimaTest {

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
	public void verificaInputCorporacaoInstituicaoSimples() {
		List<Simples> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeAnonima.txt";

		Simples simples = new Simples(path, path, path, null, null, null, path, null, null, path, null, null, path);

		list.add(simples);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoSociedadeAnonima() throws IOException {
		List<Anonima> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeAnonima.txt";

		Anonima anonima = new Anonima(path, path, path, 0, 0.0, null, path, null, null, path, null);

		list.add(anonima);
		anonima.inputCorporacaoSociedadeAnonima();

		assertNotNull(anonima);
	}
}
