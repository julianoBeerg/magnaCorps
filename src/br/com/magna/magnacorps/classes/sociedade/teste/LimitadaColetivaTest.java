package br.com.magna.magnacorps.classes.sociedade.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.magna.magnacorps.classes.sociedade.LimitadaColetiva;

public class LimitadaColetivaTest {

	@Test
	public void verificaToString() {
		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		LimitadaColetiva limitadaColetiva = new LimitadaColetiva(testeString, testeString, testeString, testeInt,
				testeDouble, null, testeString, testeBoolean, testeBoolean, testeString, testeInt, testeString,
				testeString);

		assertEquals(limitadaColetiva.toString(), limitadaColetiva.toString());

	}

	@Test
	public void verificaInputCorporacaoInstituicaoLimitadaColetiva(){
		List<LimitadaColetiva> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeLimitadaColetiva.txt";

		LimitadaColetiva limitadaColetiva = new LimitadaColetiva(path, path, path, null, null, null, path, null, null,
				path, null, path, path);

		list.add(limitadaColetiva);
		assertEquals(list, list);
	}

	@Test
	public void verificaOutputCorporacaoSociedadeLimitadaColetiva() throws IOException {
		List<LimitadaColetiva> list = new ArrayList<>();
		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeLimitadaColetiva.txt";

		LimitadaColetiva limitadaColetiva = new LimitadaColetiva(path, path, path, 0, 0.0, null, path, null, null, path,
				null, path, path);

		list.add(limitadaColetiva);
		limitadaColetiva.inputCorporacaoSociedadeLimitadaColetiva();

		assertNotNull(limitadaColetiva);
	}
}
