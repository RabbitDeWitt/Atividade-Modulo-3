package screen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Cliente;
import model.Destino;
import model.Pacote;
import sistema_CRUD.ClienteCRUD;
import sistema_CRUD.DestinoCRUD;
import sistema_CRUD.PacoteCRUD;

public class TelaCliente extends Tela {
	private static void cadastrar() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Digite o nome do cliente: ");
			String nome = sc.nextLine();
			
			Date dataNasc = new Date();
			System.out.print("Digite a data de nascimento (dd/MM/AAAA): ");
			String dataNascStr = sc.nextLine();
			
			System.out.print("Digite o telefone (DDD) xxxx-xxxx: ");
			String telefone = sc.nextLine();
			
			System.out.print("Digite o numero do passaporte: ");
			String numPassaporte = sc.nextLine();
			
			
			try {
				dataNasc = sdf.parse(dataNascStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}


			ClienteCRUD.cadastrar(new Cliente(nome, dataNasc, telefone, numPassaporte));
			Principal.exibirMenu();
		}
	}

	private static void listar() {
		try (Scanner sc = new Scanner(System.in)) {
			boolean concluido = false;

			ClienteCRUD.listarCliente();

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
			System.out.print("Digite o ID do cliente que voce deseja consultar: ");
			int id = sc.nextInt();

			Cliente cliente = ClienteCRUD.consultarCliente(id);
			

			if(cliente.getId() != 0) {
				cliente.mostrar();				
			}else {
				System.out.println("Cliente nao encontrado...");
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try (Scanner sc = new Scanner(System.in)) {
			ClienteCRUD.listarCliente();

			System.out.print("Qual cliente voce deseja editar: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite o novo nome do cliente: ");
			String nome = sc.nextLine();
			
			Date dataNasc = new Date();
			System.out.print("Digite a data de nascimento (dd/MM/AAAA): ");
			String dataNascStr = sc.nextLine();
			
			System.out.print("Digite o telefone (DDD) xxxx-xxxx: ");
			String telefone = sc.nextLine();
			
			System.out.print("Digite o numero do passaporte: ");
			String numPassaporte = sc.nextLine();
			
			try {
				dataNasc = sdf.parse(dataNascStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			ClienteCRUD.atualizar(new Cliente(id, nome, dataNasc, telefone, numPassaporte));
			Principal.exibirMenu();
		}
	}

	private static void deletar() {
		try (Scanner sc = new Scanner(System.in)) {
			limparTela();
			boolean clienteValido = false;
			int id = 0;
			
			while(clienteValido == false) {
				ClienteCRUD.listarCliente();
				System.out.print("Digite o ID do cliente que voce deseja deletar: ");
				id = sc.nextInt();
				Cliente cliente = ClienteCRUD.consultarCliente(id);
				if(cliente.getId() != 0) {
					cliente.mostrar();
					clienteValido = true;
				}else {
					System.out.println("Cliente nao encontrado...");
				}
				
			}
			
			System.out.println("=====================================");
			System.out.println("Deseja deletar esse cliente?");
			System.out.println("1 - SIM      2-NAO");
			System.out.println("=====================================");

			int opcao = sc.nextInt();

			if (opcao == 1) {
				ClienteCRUD.removerPorId(id);
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
