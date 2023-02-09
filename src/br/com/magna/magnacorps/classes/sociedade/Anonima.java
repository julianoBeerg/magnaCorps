package br.com.magna.magnacorps.classes.sociedade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import br.com.magna.magnacorps.interfaces.Porte;

public class Anonima extends Sociedade {

	public Anonima(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String sede, Integer sociosQuant) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos, sede,
				sociosQuant);
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	public String fundarCorporacaoSociedadeAnonima() {
		fundarCorporacaoSociedade();

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		return nome;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Economica: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Sede: " + getSede()
				+ ", QuantSocios: " + getSociosQuant() + " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoSociedadeAnonima() throws IOException {
		List<Anonima> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeAnonima.txt";

		// Criando reader e utilizando padrão UTF-8
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
			String line = br.readLine();

			// Lê cada linha e adciona na list
			while (line != null) {
				String[] vect = line.split(",");
				String nome = vect[0];
				String nomeFantasia = vect[1];
				String cnpj = vect[2];
				Integer numFuncionarios = Integer.parseInt(vect[3]);
				Double faturamento = Double.parseDouble(vect[4]);
				@SuppressWarnings("unused")
				String porte = vect[5];
				String tipo = vect[6];
				Boolean multinacional = Boolean.parseBoolean(vect[7]);
				Boolean finsLucrativos = Boolean.parseBoolean(vect[8]);
				String sede = vect[9];
				Integer sociosQuant = Integer.parseInt(vect[10]);

				Anonima anonima = new Anonima(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, getPorte(), tipo,
						multinacional, finsLucrativos, sede, sociosQuant);

				list.add(anonima);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Sociedade Anonima: \n");

			if (!list.isEmpty()) {
				for (Anonima f : list) {
					System.out.println(f + "\n");
				}
			} else {
				System.out.println("A lista não contém nenhuma corporação cadastrada");
			}

		} catch (IOException e) {
			throw new NullPointerException();
		}
	}

	// Output para escrita dos objetos no CSV
	public void outputCorporacaoSociedadeAnonima(){
		List<Anonima> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeAnonima.txt";

		Anonima anonima1 = new Anonima(path, path, path, numFuncionarios, getFaturamento(), porte, path,
				getMultinacional(), getFinsLucrativos(), path, sociosQuant);

		anonima1.fundarCorporacaoSociedadeAnonima();

		list.add(anonima1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (Anonima anonima : list) {
				out.append(anonima.getNome());
				out.append(',');

				out.append(anonima.getNomeFantasia());
				out.append(',');

				out.append(anonima.getCnpj());
				out.append(',');

				out.append(Integer.toString(anonima.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(anonima.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(anonima.getTipo());
				out.append(',');

				out.append(Boolean.toString(anonima.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(anonima.getFinsLucrativos()));
				out.append(',');

				out.append(anonima.getSede());
				out.append(',');

				out.append(Integer.toString(anonima.getSociosQuant()));
				out.append('\n');
			}
			out.flush();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
