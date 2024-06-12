package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int opcao;

		while (true) {
			System.out.println(
					Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "****************************************");
			System.out.println("                                        ");
			System.out.println("                ITAÓ                    ");
			System.out.println("                                        ");
			System.out.println("****************************************");
			System.out.println("                                        ");
			System.out.println("       1.Criar conta                    ");
			System.out.println("       2.Listar todas as Contas         ");
			System.out.println("       3.Buscar conta por número        ");
			System.out.println("       4.Atualizar dados da conta       ");
			System.out.println("       5.Apagar conta                   ");
			System.out.println("       6.Sacar                          ");
			System.out.println("       7.Depositar                      ");
			System.out.println("       8.Transferir                     ");
			System.out.println("       9.Sair                           ");
			System.out.println("                                        ");
			System.out.println("****************************************");
			System.out.println("Entre na opção desejada:                ");
			System.out.println("                                        " + Cores.TEXT_RESET);

			opcao = sc.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazul com Z - O seu futuro começa aqui!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta \n\n");

				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");

				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");

				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");

				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");

				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saqueln\n");

				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Deposito\n\n");
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");

				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Invalidal\n");

			}
		}
	}

	public static void sobre() {
		System.out.println("\n****************************************");
		System.out.println(" Projeto Desenvolvido por: ");
		System.out.println("Generation Brasil - generation@generation.or");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("\\n****************************************");

	}

}
