package br.com.magna.magnacorps.interfaces;

import br.com.magna.magnacorps.main.TratamentoException;

public interface AutenticaCNPJ {
	
	public String autentica(String cnpj) throws TratamentoException;

	
}
