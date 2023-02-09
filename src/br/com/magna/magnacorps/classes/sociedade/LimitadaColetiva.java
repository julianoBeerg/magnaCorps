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
import java.util.Scanner;

import br.com.magna.magnacorps.interfaces.Porte;

public class LimitadaColetiva extends Sociedade {

	private String area;
	private String administrador;

	public LimitadaColetiva(String nome, String nomeFantasia, String cnpj, Integer numFuncionarios, Double faturamento,
			Porte porte, String tipo, Boolean multinacional, Boolean finsLucrativos, String sede, Integer sociosQuant,
			String area, String administrador) {
		super(nome, nomeFantasia, cnpj, numFuncionarios, faturamento, porte, tipo, multinacional, finsLucrativos, sede,
				sociosQuant);
		this.area = area;
		this.administrador = administrador;
	}

	// Método que utiliza metodo da classe Instituição para criar um objeto do tipo:
	// (Corporação > Instituição > Familiar)
	// Não pode ser instaciado direto na Main
	public String fundarCorporacaoSociedadeLimitadaColetiva(){
		fundarCorporacaoSociedade();
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite a area de atuação: ");
		this.area = scan.nextLine();

		System.out.print("Digite o nome do administrador: ");
		this.administrador = scan.nextLine();

		System.out.println("\nCadastro Realizado com Sucesso !\n\n");

		scan.close();
		return area;
	}

	// Sobreescrita do toString para ser utilizado no output
	@Override
	public String toString() {
		return "Instituição Economica: [ Nome: " + getNome() + ", NomeFantasia: " + getNomeFantasia() + ", Cnpj: "
				+ getCnpj() + ", NumFuncionarios: " + getNumFuncionarios() + ", Faturamento: "
				+ getFaturamento().intValue() + ", Porte: " + getPorte() + ", Tipo: " + getTipo() + ", Multinacional: "
				+ getMultinacional() + ", FinsLucrativos: " + getFinsLucrativos() + ", Sede: " + getSede()
				+ ", QuantSocios: " + getSociosQuant() + ", Área: " + getArea() + ", Administrador: " + getAdministrador()
				+ " ]";
	}

	// Método de input para ler arquivos CSV
	public void inputCorporacaoSociedadeLimitadaColetiva() throws IOException {
		List<LimitadaColetiva> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeLimitadaColetiva.txt";

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
				area = vect[11];
				administrador = vect[12];

				LimitadaColetiva limitadaColetiva = new LimitadaColetiva(nome, nomeFantasia, cnpj, numFuncionarios,
						faturamento, getPorte(), tipo, multinacional, finsLucrativos, sede, sociosQuant, area,
						administrador);
				list.add(limitadaColetiva);

				line = br.readLine();
			}
			// loop que imprima linha a linha utilizando
			System.out.println("Corparação Sociedade Limitada/Coletiva: \n");

			if (!list.isEmpty()) {
				for (LimitadaColetiva f : list) {
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
	public void outputCorporacaoSociedadeLimitadaColetiva() {
		List<LimitadaColetiva> list = new ArrayList<>();

		String path = "src\\br\\com\\magna\\magnacorps\\arquivoscsv\\Sociedade\\CorporacaoSociedadeLimitadaColetiva.txt";

		LimitadaColetiva limitadaColetiva1 = new LimitadaColetiva(path, path, path, numFuncionarios, getFaturamento(),
				porte, path, getMultinacional(), getFinsLucrativos(), path, sociosQuant, path, path);

		limitadaColetiva1.fundarCorporacaoSociedadeLimitadaColetiva();

		list.add(limitadaColetiva1);

		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

			for (LimitadaColetiva limitadaColetiva : list) {
				out.append(limitadaColetiva.getNome());
				out.append(',');

				out.append(limitadaColetiva.getNomeFantasia());
				out.append(',');

				out.append(limitadaColetiva.getCnpj());
				out.append(',');

				out.append(Integer.toString(limitadaColetiva.getNumFuncionarios()));
				out.append(',');

				out.append(Double.toString(limitadaColetiva.getFaturamento()));
				out.append(',');

				out.append(getPorte().toString());
				out.append(',');

				out.append(limitadaColetiva.getTipo());
				out.append(',');

				out.append(Boolean.toString(limitadaColetiva.getMultinacional()));
				out.append(',');

				out.append(Boolean.toString(limitadaColetiva.getFinsLucrativos()));
				out.append(',');

				out.append(limitadaColetiva.getSede());
				out.append(',');

				out.append(Integer.toString(limitadaColetiva.getSociosQuant()));
				out.append(',');

				out.append(limitadaColetiva.getArea());
				out.append(',');

				out.append(limitadaColetiva.getAdministrador());
				out.append(',');
				out.append('\n');
			}
			out.flush();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Abaixo Apenas getters e setters
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
}
