package br.com.magna.magnacorps.classes.instituicao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.instituicao.Ensino;

public class EnsinoTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Ensino ensino = new Ensino(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
				testeBoolean, testeBoolean, testeString, testeString, testeString, testeString, testeInt);

		assertEquals(ensino.toString(), ensino.toString());
	}

	@Test
	public void verificaInputCorporacaoInstituicaoEnsino() throws Exception {
		List<Ensino> list = new ArrayList<Ensino>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoEnsino.txt";

		Ensino ensino = new Ensino(path, path, path, null, null, null, path, null, null, path, path, path, path, null);

		list.add(ensino);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoInstituicaoEnsino() throws Exception {
		List<Ensino> list = new ArrayList<Ensino>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoEconomica.txt";

		Ensino ensino = new Ensino(path, path, path, 0, 0.0, null, path, null, null, path, null, path, null, null);

		list.add(ensino);
		ensino.inputCorporacaoInstituicaoEnsino();

		assertNotNull(ensino);
	}

}
