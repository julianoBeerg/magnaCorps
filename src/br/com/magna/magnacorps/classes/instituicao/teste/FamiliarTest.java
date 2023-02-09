package br.com.magna.magnacorps.classes.instituicao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.instituicao.Familiar;

public class FamiliarTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Familiar familiar = new Familiar(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString,
				testeString);

		assertEquals(familiar.toString(), familiar.toString());
	}

	@Test
	public void verificaInputCorporacaoInstituicaoFamiliar() {
		List<Familiar> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoFamiliar.txt";

		Familiar familiar = new Familiar(path, path, path, null, null, null, path, null, null, path, path, path, path,
				path);

		list.add(familiar);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoInstituicaoFamiliar() throws IOException {
		List<Familiar> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoFamiliar.txt";

		Familiar familiar = new Familiar(path, path, path, 0, 0.0, null, path, null, null, path, null, path, null,
				null);

		list.add(familiar);
		familiar.inputCorporacaoInstituicaoFamiliar();

		assertNotNull(familiar);
	}

}
