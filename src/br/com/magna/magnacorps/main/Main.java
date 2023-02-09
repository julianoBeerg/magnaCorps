package br.com.magna.magnacorps.main;

public class Main {

	public static void main(String[] args) throws Exception {
//
//		@SuppressWarnings("resource")
//		Scanner scan = new Scanner(System.in);
//
//		// Inicializando listas com tipos genéricos
//		String testeString = "n";
//		int testeInt = 0;
//		double testeDouble = 0.0;
//		boolean testeBoolean = false;
//
//		Integer opcao;
//		Integer opcaoMenu;
//		Integer opcaoMenuEspecifico;
//
//		// Instituições
//		Economica economica = new Economica(testeString, testeString, testeString, testeInt, testeDouble, null,
//				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeInt, testeInt);
//		Ensino ensino = new Ensino(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
//				testeBoolean, testeBoolean, testeString, testeString, testeString, testeString, testeInt);
//		Esportiva esportiva = new Esportiva(testeString, testeString, testeString, testeInt, testeDouble, null,
//				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString, testeInt);
//		Familiar familiar = new Familiar(testeString, testeString, testeString, testeInt, testeDouble, null,
//				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString,
//				testeString);
//		Religiosa religiosa = new Religiosa(testeString, testeString, testeString, testeInt, testeDouble, null,
//				testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeString,
//				testeString);
//		Governamental governamental = new Governamental(testeString, testeString, testeString, testeInt, testeDouble,
//				null, testeString, testeBoolean, testeBoolean, testeString, testeString, testeString, testeBoolean,
//				testeString);
//
//		// Sociedade
//		Simples simples = new Simples(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
//				testeBoolean, testeBoolean, testeString, testeInt, testeInt, testeString);
//		LimitadaColetiva limitadaColetiva = new LimitadaColetiva(testeString, testeString, testeString, testeInt,
//				testeDouble, null, testeString, testeBoolean, testeBoolean, testeString, testeInt, testeString,
//				testeString);
//		Comandita comandita = new Comandita(testeString, testeString, testeString, testeInt, testeDouble, null,
//				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeString, testeString, testeInt);
//		Anonima anonima = new Anonima(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
//				testeBoolean, testeBoolean, testeString, testeInt);
//
//		// Associacao
//		Cultural cultural = new Cultural(testeString, testeString, testeString, testeInt, testeDouble, null,
//				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeDouble, testeInt);
//		Desportivo desportivo = new Desportivo(testeString, testeString, testeString, testeInt, testeDouble, null,
//				testeString, testeBoolean, testeBoolean, testeString, testeInt, testeInt, testeInt);
//		Social social = new Social(testeString, testeString, testeString, testeInt, testeDouble, null, testeString,
//				testeBoolean, testeBoolean, testeString, testeInt, testeString, testeInt, testeInt);
//
//		do {
//			System.out.println("");
//			System.out.println("*********** BEM VINDO(A) **********");
//			System.out.println("*********** MAGNA CORPS ***********\n");
//			System.out.println("Selecione em qual categoria deseja entrar");
//			System.out.println("1 - Instituição");
//			System.out.println("2 - Sociedade");
//			System.out.println("3 - Associação");
//			System.out.println("0 - Sair");
//			System.out.print("Opção: ");
//			opcao = scan.nextInt();
//			System.out.println("\n");
//
//			// Inicio Bloco instituições
//			if (opcao == 1) {
//				System.out.println("BEM VINDO A ÁREA DE INSTITUIÇÕES !\n");
//				System.out.println("Escolha o tipo de instituição que deseja ver");
//				System.out.println("1 - Econômica");
//				System.out.println("2 - Ensino");
//				System.out.println("3 - Esportiva");
//				System.out.println("4 - Familiar");
//				System.out.println("5 - Religiosa");
//				System.out.println("6 - Governamental");
//				System.out.println("0 - Voltar ao menu anterior");
//				System.out.print("Opção: ");
//				try {
//					opcaoMenu = scan.nextInt();
//				} catch (Exception e) {
//					throw new TratamentoException("O Tipo deve ser númerico");
//				}
//
//				System.out.println("\nO que deseja fazer ?");
//				System.out.println("1 - Cadastrar");
//				System.out.println("2 - Verificar cadastros");
//				System.out.println("0 - Voltar ao menu Principal");
//				System.out.println("O que deseja fazer");
//				System.out.print("Opção: ");
//				try {
//					opcaoMenuEspecifico = scan.nextInt();
//				} catch (Exception e) {
//					throw new TratamentoException("O Tipo deve ser númerico");
//				}
//
//				System.out.println("\n\n\n");
//
//				// Inicio Bloco instituições especifícas
//				if (opcaoMenu == 1) {
//					if (opcaoMenuEspecifico == 1) {
//						economica.outputCorporacaoInstituicaoEconomica();
//					} else if (opcaoMenuEspecifico == 2) {
//						economica.inputCorporacaoInstituicaoEconomica();
//					}
//				} else if (opcaoMenu == 2) {
//					if (opcaoMenuEspecifico == 1) {
//						ensino.outputCorporacaoInstituicaoEnsino();
//					} else if (opcaoMenuEspecifico == 2) {
//						ensino.inputCorporacaoInstituicaoEnsino();
//					}
//				} else if (opcaoMenu == 3) {
//					if (opcaoMenuEspecifico == 1) {
//						esportiva.outputCorporacaoInstituicaoEsportiva();
//					} else if (opcaoMenuEspecifico == 2) {
//						esportiva.inputCorporacaoInstituicaoEsportiva();
//					}
//				} else if (opcaoMenu == 4) {
//					if (opcaoMenuEspecifico == 1) {
//						familiar.outputCorporacaoInstituicaoFamiliar();
//					} else if (opcaoMenuEspecifico == 2) {
//						familiar.inputCorporacaoInstituicaoFamiliar();
//					}
//				} else if (opcaoMenu == 5) {
//					if (opcaoMenuEspecifico == 1) {
//						religiosa.outputCorporacaoInstituicaoReligiosa();
//					} else if (opcaoMenuEspecifico == 2) {
//						religiosa.inputCorporacaoInstituicaoReligiosa();
//					}
//				} else if (opcaoMenu == 6) {
//					if (opcaoMenuEspecifico == 1) {
//						governamental.outputCorporacaoInstituicaoGovernamental();
//					} else if (opcaoMenuEspecifico == 2) {
//						governamental.inputCorporacaoInstituicaoGovernamental();
//					}
//				}
//
//				// Inicio Bloco Sociedades
//			} else if (opcao == 2) {
//				System.out.println("BEM VINDO A AREA DE SOCIEDADES !\n");
//				System.out.println("1 - Simples");
//				System.out.println("2 - LimitadaColetiva");
//				System.out.println("3 - Comandita");
//				System.out.println("4 - Anônima");
//				System.out.println("0 - Voltar ao menu anterior");
//				System.out.print("Opção: ");
//				try {
//					opcaoMenu = scan.nextInt();
//				} catch (Exception e) {
//					throw new TratamentoException("O Tipo deve ser númerico");
//				}
//
//				System.out.println("\nO que deseja fazer ?");
//				System.out.println("1 - Cadastrar");
//				System.out.println("2 - Verificar cadastros");
//				System.out.println("0 - Voltar ao menu Principal");
//				System.out.println("O que deseja fazer");
//				System.out.print("Opção: ");
//				try {
//					opcaoMenuEspecifico = scan.nextInt();
//				} catch (Exception e) {
//					throw new TratamentoException("O Tipo deve ser númerico");
//				}
//
//				System.out.println("\n\n\n");
//
//				// Inicio Bloco sociedades especifícas
//				if (opcaoMenu == 1) {
//					if (opcaoMenuEspecifico == 1) {
//						simples.outputCorporacaoSociedadeSimples();
//					} else if (opcaoMenuEspecifico == 2) {
//						simples.inputCorporacaoSociedadeSimples();
//					}
//				}
//
//				if (opcaoMenu == 2) {
//					if (opcaoMenuEspecifico == 1) {
//						limitadaColetiva.outputCorporacaoSociedadeLimitadaColetiva();
//					} else if (opcaoMenuEspecifico == 2) {
//						limitadaColetiva.inputCorporacaoSociedadeLimitadaColetiva();
//					}
//				}
//
//				if (opcaoMenu == 3) {
//					if (opcaoMenuEspecifico == 1) {
//						comandita.outputCorporacaoSociedadeComandita();
//					} else if (opcaoMenuEspecifico == 2) {
//						comandita.inputCorporacaoSociedadeComandita();
//					}
//				}
//
//				if (opcaoMenu == 4) {
//					if (opcaoMenuEspecifico == 1) {
//						anonima.outputCorporacaoSociedadeAnonima();
//					} else if (opcaoMenuEspecifico == 2) {
//						anonima.inputCorporacaoSociedadeAnonima();
//					}
//				}
//
//				// Inicio Bloco associações
//			} else if (opcao == 3) {
//				System.out.println("BEM VINDO A AREA DE ASSICIAÇÕES !\n");
//				System.out.println("1 - Cultural");
//				System.out.println("2 - Desportiva");
//				System.out.println("3 - Social");
//				System.out.println("0 - Voltar ao menu anterior");
//				System.out.print("Opção: ");
//				try {
//					opcaoMenu = scan.nextInt();
//				} catch (Exception e) {
//					throw new TratamentoException("O Tipo deve ser númerico");
//				}
//
//				System.out.println("\nO que deseja fazer ?");
//				System.out.println("1 - Cadastrar");
//				System.out.println("2 - Verificar cadastros");
//				System.out.println("0 - Voltar ao menu Principal");
//				System.out.println("O que deseja fazer");
//				System.out.print("Opção: ");
//				try {
//					opcaoMenuEspecifico = scan.nextInt();
//				} catch (Exception e) {
//					throw new TratamentoException("O Tipo deve ser númerico");
//				}
//
//				System.out.println("\n\n\n");
//
//				// Inicio Bloco associações especificas
//				if (opcaoMenu == 1) {
//					if (opcaoMenuEspecifico == 1) {
//						cultural.outputCorporacaoAssociacaoCultural();
//					} else if (opcaoMenuEspecifico == 2) {
//						cultural.inputCorporacaoAssociacaoCultural();
//					}
//				}
//
//				if (opcaoMenu == 2) {
//					if (opcaoMenuEspecifico == 1) {
//						desportivo.outputCorporacaoAssociacaoDesportivo();
//					} else if (opcaoMenuEspecifico == 2) {
//						desportivo.outputCorporacaoAssociacaoDesportivo();
//					}
//				}
//
//				if (opcaoMenu == 3) {
//					if (opcaoMenuEspecifico == 1) {
//						social.outputCorporacaoAssociacaoSocial();
//					} else if (opcaoMenuEspecifico == 2) {
//						social.inputCorporacaoAssociacaoSocial();
//					}
//				}
//			}
//
//		} while (opcao != 0);
//
//		System.out.println("Obrigado !");
//		scan.close();
	}

}
