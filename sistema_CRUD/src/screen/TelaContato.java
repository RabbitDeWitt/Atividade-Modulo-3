package screen;

import java.util.Scanner;

import model.Contato;
import sistema_CRUD.ClienteCRUD;
import sistema_CRUD.ContatoCRUD;

public class TelaContato extends Tela{
	private static void cadastrar() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Digite o nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Digite email: ");
			String email = sc.nextLine();
			
			System.out.print("Digite a mensagem: ");
			String msg = sc.nextLine();
			

			ContatoCRUD.cadastrar(new Contato(nome, email, msg));
			Principal.exibirMenu();
		}
	}
	
	private static void listar() {
		try (Scanner sc = new Scanner(System.in)) {
			boolean concluido = false;

			ContatoCRUD.listarContato();

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
			System.out.print("Digite o ID da mensagem que voce deseja consultar: ");
			int id = sc.nextInt();

			Contato contato = ContatoCRUD.consultarContato(id);
			

			if(contato.getId() != 0) {
				contato.mostrar();				
			}else {
				System.out.println("Mensagem nao encontrada...");
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
			ContatoCRUD.listarContato();

			System.out.print("Qual cliente voce deseja editar: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Digite o novo nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Digite o novo email: ");
			String email = sc.nextLine();
			
			System.out.print("Digite a nova mensagem: ");
			String msg = sc.nextLine();
			
			ContatoCRUD.atualizar(new Contato(id, nome, email, msg));
			Principal.exibirMenu();
		}
	}
	
	private static void deletar() {
		try (Scanner sc = new Scanner(System.in)) {
			limparTela();
			boolean contatoValido = false;
			int id = 0;
			
			while(contatoValido == false) {
				ContatoCRUD.listarContato();
				System.out.print("Digite o ID mensagem que voce deseja deletar: ");
				id = sc.nextInt();
				Contato contato = ContatoCRUD.consultarContato(id);
				if(contato.getId() != 0) {
					contato.mostrar();
					contatoValido = true;
				}else {
					System.out.println("Mensagem nao encontrada...");
				}
				
			}
			
			System.out.println("=====================================");
			System.out.println("Deseja deletar essa mensagem?");
			System.out.println("1 - SIM      2-NAO");
			System.out.println("=====================================");

			int opcao = sc.nextInt();

			if (opcao == 1) {
				ContatoCRUD.removerPorId(id);
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
