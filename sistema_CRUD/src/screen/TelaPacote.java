package screen;

import java.util.Scanner;

import model.Pacote;
import sistema_CRUD.PacoteCRUD;

public class TelaPacote extends Tela {

	private static void cadastrar() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Digite o nome do pacote: ");
			String nome = sc.nextLine();
			
			System.out.print("Digite o valor do pacote: ");
			float valor = sc.nextFloat();

			PacoteCRUD.cadastrar(new Pacote(nome, valor));
			Principal.exibirMenu();
		}
	}

	private static void listar() {
		try (Scanner sc = new Scanner(System.in)) {
			boolean concluido = false;

			PacoteCRUD.listarPacote();

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
			System.out.print("Digite o ID do pacote que voce deseja consultar: ");
			int id = sc.nextInt();

			Pacote pacote = PacoteCRUD.consultarPacote(id);

			if(pacote.getId() != 0) {
				pacote.mostrar();				
			}else {
				System.out.println("Pacote nao encontrado...");
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
			PacoteCRUD.listarPacote();

			System.out.print("Qual pacote voce deseja editar: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite o novo nome do pacote: ");
			String nome = sc.nextLine();

			System.out.print("Digite o novo valor do pacote: ");
			float valor = sc.nextFloat();

			PacoteCRUD.atualizar(new Pacote(id, nome, valor));
			Principal.exibirMenu();
		}
	}

	private static void deletar() {
		try (Scanner sc = new Scanner(System.in)) {
				limparTela();
				boolean pacoteValido = false;
				int id = 0;
				
				while(pacoteValido == false) {
					PacoteCRUD.listarPacote();
					System.out.print("Digite o ID do pacote que voce deseja deletar: ");
					id = sc.nextInt();
					Pacote pacote = PacoteCRUD.consultarPacote(id);
					
					if(pacote.getId() != 0) {
						pacote.mostrar();
						pacoteValido = true;
					}else {
						System.out.println("Pacote nao encontrado...");
					}
				}

				
				System.out.println("=====================================");
				System.out.println("Deseja deletar esse pacote?");
				System.out.println("1 - SIM      2-NAO");
				System.out.println("=====================================");

				int opcao = sc.nextInt();

				if (opcao == 1) {
					PacoteCRUD.removerPorId(id);
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
