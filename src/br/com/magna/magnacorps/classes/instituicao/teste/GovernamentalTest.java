package br.com.magna.magnacorps.classes.instituicao.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.magna.magnacorps.classes.instituicao.Governamental;

public class GovernamentalTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		Governamental governamental = new Governamental(testeString, testeString, testeString, testeInt, testeDouble,
				null, testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeBoolean,
				testeString);

		assertEquals(governamental.toString(), governamental.toString());
	}

	@Test
	public void verificaInputCorporacaoInstituicaoGovernamental(){
		List<Governamental> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoGovernamental.txt";

		Governamental governamental = new Governamental(path, path, path, null, null, null, path, null, null, path,
				path, path, null, path);

		list.add(governamental);
		assertEquals(list, list);
	}
	
	@Test
	public void verificaOutputCorporacaoInstituicaoGovernamental() throws IOException {
		List<Governamental> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Insituicao\\CorporacaoInstituicaoGovernamental.txt";

		Governamental governamental = new Governamental(path, path, path, 0, 0.0, null, path, null, null, path,
				path, path, null, path);
		
		list.add(governamental);
		governamental.inputCorporacaoInstituicaoGovernamental();
		
		assertNotNull(governamental);

	}
	
}
