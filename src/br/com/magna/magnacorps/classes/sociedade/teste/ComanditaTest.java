package br.com.magna.magnacorps.classes.sociedade.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.sociedade.Comandita;

public class ComanditaTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Comandita comandita = new Comandita(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeString, testeString, testeInt);

		assertEquals(comandita.toString(), comandita.toString());

	}

	@Test
	public void verificaInputCorporacaoInstituicaoComandita() {
		List<Comandita> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeComandita.txt";

		Comandita comandita = new Comandita(path, path, path, null, null, null, path, null, null, path, null, path,
				path, null);

		list.add(comandita);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoSociedadeComandita() throws IOException {
		List<Comandita> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeComandita.txt";

		Comandita comandita = new Comandita(path, path, path, 0, 0.0, null, path, null, null, path, null, path, path,
				null);

		list.add(comandita);
		comandita.inputCorporacaoSociedadeComandita();

		assertNotNull(comandita);
	}
}
