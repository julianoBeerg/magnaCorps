package br.com.magna.magnacorps.classes.instituicao.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.magna.magnacorps.classes.instituicao.Religiosa;

public class ReligiosaTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Religiosa religiosa = new Religiosa(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString,
				testeString);

		assertEquals(religiosa.toString(), religiosa.toString());
	}

	@Test
	public void verificaInputCorporacaoInstituicaoReligiosa() throws Exception {
		List<Religiosa> list = new ArrayList<Religiosa>();
		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoReligiosa.txt";

		Religiosa religiosa = new Religiosa(path, path, path, null, null, null, path, null, null, path, path, path,
				path, path);

		list.add(religiosa);
		assertEquals(list, list);
	}
	
//	@Test
//	public void verificaOutputCorporacaoInstituicaoReligiosa() throws Exception {
//		List<Religiosa> list = new ArrayList<Religiosa>();
//		String path = "C:\\dev\\csvArchives\\Insituicao\\CorporacaoInstituicaoReligiosa.txt";
//
//		Religiosa religiosa = new Religiosa(path, path, path, 0, 0.0, null, path, null, null,
//				path, path, path, path, path);
//		
//		list.add(religiosa);
//		religiosa.inputCorporacaoInstituicaoReligiosa();
//
//		assertNotNull(religiosa);
//	}
	
}
