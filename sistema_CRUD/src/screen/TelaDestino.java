package screen;

import java.util.Scanner;

import model.Destino;
import sistema_CRUD.DestinoCRUD;

public class TelaDestino extends Tela {
	private static void cadastrar() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Digite o nome do destino: ");
			String nome = sc.nextLine();
			System.out.print("Digite o estado: ");
			String estado = sc.nextLine();
			
			System.out.print("Digite o pais: ");
			String pais = sc.nextLine();
			
			System.out.print("Digite o valor da viagem base: ");
			float valor = sc.nextFloat();

			DestinoCRUD.cadastrar(new Destino(nome, estado, pais, valor));
			Principal.exibirMenu();
		}
	}

	private static void listar() {
		try (Scanner sc = new Scanner(System.in)) {
			boolean concluido = false;

			DestinoCRUD.listarDestino();

			while (concluido == false) {
				System.out.println("=====================================");
				System.out.println("Deseja voltar ao menu?");
				System.out.println("1 - SIM      2-NAO");
				System.out.println("=====================================");

				int opcao = sc.nextInt();

				if (opcao == 1) {
					Principal.exibirMenu();
				} else if (opcao == 2) {
					consultar();
				}
			}
		}
	}

	private static void consultar() {
		try (Scanner sc = new Scanner(System.in)) {
			boolean concluido = false;
			System.out.print("Digite o ID do destino que voce deseja consultar: ");
			int id = sc.nextInt();

			Destino destino = DestinoCRUD.consultarDestino(id);

			if(destino.getId() != 0) {
				destino.mostrar();
			}else {
				System.out.println("Destino nao encontrado...");
			}
			
			while (concluido == false) {
				System.out.println("=====================================");
				System.out.println("Deseja fazer uma nova consulta?");
				System.out.println("1 - SIM      2-NAO");
				System.out.println("=====================================");

				int opcao = sc.nextInt();

				if (opcao == 1) {
					consultar();
				} else if (opcao == 2) {
					Principal.exibirMenu();
				}
			}
		}
	}

	private static void editar() {
		try (Scanner sc = new Scanner(System.in)) {
			DestinoCRUD.listarDestino();

			System.out.print("Qual destino voce deseja editar: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite o novo nome do destino: ");
			String nome = sc.nextLine();
			
			System.out.print("Digite o estado: ");
			String estado = sc.nextLine();
			
			System.out.print("Digite o pais: ");
			String pais = sc.nextLine();

			System.out.print("Digite o novo valor base do destino: ");
			float valor = sc.nextFloat();

			DestinoCRUD.atualizar(new Destino(id, nome, estado, pais, valor));
			Principal.exibirMenu();
		}
	}

	private static void deletar() {
		try (Scanner sc = new Scanner(System.in)) {
				limparTela();
				boolean destinoValido = false;
				int id = 0;
				while(destinoValido == false) {
					DestinoCRUD.listarDestino();
					System.out.print("Digite o ID do destino que voce deseja deletar: ");
					id = sc.nextInt();
					Destino destino = DestinoCRUD.consultarDestino(id);

					if(destino.getId() != 0) {
						destino.mostrar();
						destinoValido = true;
					}else {
						System.out.println("Destino nao encotrado...");
					}
				}

				
				System.out.println("=====================================");
				System.out.println("Deseja deletar esse destino?");
				System.out.println("1 - SIM      2-NAO");
				System.out.println("=====================================");

				int opcao = sc.nextInt();

				if (opcao == 1) {
					DestinoCRUD.removerPorId(id);
					Principal.exibirMenu();
				}else if(opcao == 2) {
					Principal.exibirMenu();
				}
			}
		}

	public static void exibirFormulario(int operacao) {
		limparTela();
		switch (operacao) {
		case 1:
			cadastrar();
			break;
		case 2:
			listar();
			break;
		case 3:
			consultar();
			break;
		case 4:
			editar();
			break;
		case 5:
			deletar();
			break;
		}
	}

}
