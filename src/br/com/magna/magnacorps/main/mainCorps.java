package br.com.magna.magnacorps.main;

import br.com.magna.magnacorps.classes.associacao.Cultural;
import br.com.magna.magnacorps.classes.associacao.Desportivo;
import br.com.magna.magnacorps.classes.associacao.Social;
import br.com.magna.magnacorps.classes.instituicao.Economica;
import br.com.magna.magnacorps.classes.instituicao.Ensino;
import br.com.magna.magnacorps.classes.instituicao.Esportiva;
import br.com.magna.magnacorps.classes.instituicao.Familiar;
import br.com.magna.magnacorps.classes.instituicao.Governamental;
import br.com.magna.magnacorps.classes.instituicao.Religiosa;
import br.com.magna.magnacorps.classes.sociedade.Anonima;
import br.com.magna.magnacorps.classes.sociedade.Comandita;
import br.com.magna.magnacorps.classes.sociedade.LimitadaColetiva;
import br.com.magna.magnacorps.classes.sociedade.Simples;

public class MainCorps {

	public static void main(String[] args) throws Exception {

		String testeString = "n";
		int testeInt = 0;
		double testeDouble = 0.0;
		boolean testeBoolean = false;

		// Instituição
		Familiar familiar = new Familiar(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString,
				testeString);
		familiar.outputCorporacaoInstituicaoFamiliar();
		familiar.inputCorporacaoInstituicaoFamiliar();

		Economica economica = new Economica(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeInt, testeInt);
		economica.outputCorporacaoInstituicaoEconomica();
		economica.inputCorporacaoInstituicaoEconomica();

		Ensino ensino = new Ensino(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
				testeBoolean, testeBoolean, testeString, testeString, testeString, testeString, testeInt);
		ensino.outputCorporacaoInstituicaoEnsino();
		ensino.inputCorporacaoInstituicaoEnsino();

		Esportiva esportiva = new Esportiva(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString, testeInt);
		esportiva.outputCorporacaoInstituicaoEsportiva();
		esportiva.inputCorporacaoInstituicaoEsportiva();

		Governamental governamental = new Governamental(testeString, testeString, testeString, testeInt, testeDouble,
				null, testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeBoolean,
				testeString);
		governamental.outputCorporacaoInstituicaoGovernamental();
		governamental.inputCorporacaoInstituicaoGovernamental();

		Religiosa religiosa = new Religiosa(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString,
				testeString);
		religiosa.outputCorporacaoInstituicaoReligiosa();
		religiosa.inputCorporacaoInstituicaoReligiosa();

		// Sociedade
		Simples simples = new Simples(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
				testeBoolean, testeBoolean, testeString, testeInt, testeInt, testeString);
		simples.outputCorporacaoSociedadeSimples();
		simples.inputCorporacaoSociedadeSimples();

		LimitadaColetiva limitadaColetiva = new LimitadaColetiva(testeString, testeString, testeString, testeInt,
				testeDouble, null, testeString, testeBoolean, testeBoolean, testeString, testeInt, testeString,
				testeString);
		limitadaColetiva.outputCorporacaoSociedadeLimitadaColetiva();
		limitadaColetiva.inputCorporacaoSociedadeLimitadaColetiva();

		Comandita comandita = new Comandita(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeString, testeString, testeInt);
		comandita.outputCorporacaoSociedadeComandita();
		comandita.inputCorporacaoSociedadeComandita();

		Anonima anonima = new Anonima(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
				testeBoolean, testeBoolean, testeString, testeInt);
		anonima.outputCorporacaoSociedadeAnonima();
		anonima.inputCorporacaoSociedadeAnonima();

		// Associacao
		Cultural cultural = new Cultural(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeDouble, testeInt);
		cultural.outputCorporacaoAssociacaoCultural();
		cultural.inputCorporacaoAssociacaoCultural();

		Desportivo desportivo = new Desportivo(testeString, testeString, testeString, testeInt, testeDouble, null,
				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeInt, testeInt);
		desportivo.outputCorporacaoAssociacaoDesportivo();
		desportivo.inputCorporacaoAssociacaoDesportivo();

		Social social = new Social(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
				testeBoolean, testeBoolean, testeString, testeInt, testeString, testeInt, testeInt);
		social.outputCorporacaoAssociacaoSocial();
		social.inputCorporacaoAssociacaoSocial();

	}

}
