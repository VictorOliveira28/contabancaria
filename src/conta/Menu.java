package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrenteModel;
import conta.model.ContaPoupancaModel;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		ContaCorrenteModel cc1 = new ContaCorrenteModel(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrenteModel cc2 = new ContaCorrenteModel(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupancaModel cp1 = new ContaPoupancaModel(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupancaModel cp2 = new ContaPoupancaModel(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();

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

			try {

				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nITAÓ - O seu futuro começa aqui!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta \n\n");
				System.out.println("Digite o Numero da Agência: ");
				agencia = sc.nextInt();				
				System.out.println("Digite o Nome do titular: ");
				sc.next();
				titular = sc.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta(1-CC ou 2-CP): ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = sc.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrenteModel(contas.gerarNumero(), 
							agencia, tipo, titular, saldo, limite));
				}

				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupancaModel(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

					}
				}

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();

				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.procurarPorNumero(numero);

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o numero da Agência: ");
					agencia = sc.nextInt();
					sc.nextLine();
					System.out.println("Digite o Nome do Titular: ");
					titular = sc.nextLine();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = sc.nextFloat();
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = sc.nextFloat();
						
						contas.atualizar(new ContaCorrenteModel(numero, agencia, tipo,
								titular, saldo, limite));
					}
					
					case 2 -> {
						System.out.println("Digite o Aniversario da Conta: ");
						aniversario = sc.nextInt();
						
						contas.atualizar(new ContaPoupancaModel(numero, agencia, tipo,
								titular, saldo, aniversario));
					}
					
					default -> {
						System.out.println("Tipo de conta inválido!");
						}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.deletar(numero);
				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");

				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Deposito\n\n");

				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Invalida\n\n");

				keyPress();
				break;

			}
		}

	}

	public static void keyPress() {
		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou um tecla diferente de enter!");
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
