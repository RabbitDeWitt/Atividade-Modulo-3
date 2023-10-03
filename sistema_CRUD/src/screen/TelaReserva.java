package screen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Cliente;
import model.Destino;
import model.Pacote;
import model.Reserva;
import sistema_CRUD.ClienteCRUD;
import sistema_CRUD.DestinoCRUD;
import sistema_CRUD.PacoteCRUD;
import sistema_CRUD.ReservaCRUD;

public class TelaReserva extends Tela {

	private static void cadastrar() {
		try (Scanner sc = new Scanner(System.in)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			ClienteCRUD.listarCliente();

			System.out.print("Cliente: ");
			int idCliente = sc.nextInt();

			DestinoCRUD.listarDestino();

			System.out.print("Destino: ");
			int idDestino = sc.nextInt();

			PacoteCRUD.listarPacote();

			System.out.print("Pacote: ");
			int idPacote = sc.nextInt();

			System.out.print("Data de Partida(DD/MM/AAAA): ");
			String dataPartidaStr = sc.next();

			System.out.print("Data de Retorno(DD/MM/AAAA): ");
			String dataRetornoStr = sc.next();

			Date dataPartida = new Date();
			Date dataRetorno = new Date();

			try {
				dataPartida = sdf.parse(dataPartidaStr);
				dataRetorno = sdf.parse(dataRetornoStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Cliente cliente = ClienteCRUD.consultarCliente(idCliente);
			Destino destino = DestinoCRUD.consultarDestino(idDestino);
			Pacote pacote = PacoteCRUD.consultarPacote(idPacote);

			ReservaCRUD.cadastrar(new Reserva(dataPartida, dataRetorno, cliente, destino, pacote));
			
			Principal.exibirMenu();
		}

	}

	private static void listar() {
		try (Scanner sc = new Scanner(System.in)) {
			boolean concluido = false;
			
			ReservaCRUD.listarReserva();
	
			while(concluido == false) {
				System.out.println("=====================================");
				System.out.println("Deseja voltar ao menu?");
				System.out.println("1 - SIM      2-NAO");
				System.out.println("=====================================");
				
				int opcao = sc.nextInt();
				
				if(opcao == 1) {
					Principal.exibirMenu();
				}else if(opcao == 2){
					consultar();
				}
			}
		}
	}

	private static void consultar() {
		try (Scanner sc = new Scanner(System.in)) {
			boolean concluido = false;
			System.out.print("Digite o ID da reserva que voce deseja consultar: ");
			int id = sc.nextInt();
	
			ReservaCRUD.consultarReserva(id);
			
			while(concluido == false) {
				System.out.println("=====================================");
				System.out.println("Deseja fazer uma nova consulta?");
				System.out.println("1 - SIM      2-NAO");
				System.out.println("=====================================");
				
				int opcao = sc.nextInt();
				
				if(opcao == 1) {
					consultar();
				}else if(opcao == 2){
					Principal.exibirMenu();
				}
			}
		}
		
		
	}

	private static void editar() {
		try (Scanner sc = new Scanner(System.in)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			ReservaCRUD.listarReserva();
			
			System.out.print("Qual reserva voce deseja editar:");
			int id = sc.nextInt();
			
			ClienteCRUD.listarCliente();
			System.out.print("Selecione um novo cliente: ");
			int idCliente = sc.nextInt();
			
			DestinoCRUD.listarDestino();
			System.out.print("Selecione um novo destino: ");
			int idDestino = sc.nextInt();
			
			PacoteCRUD.listarPacote();
			System.out.print("Selecione um nove pacote: ");
			int idPacote = sc.nextInt();
			
			Cliente cliente = ClienteCRUD.consultarCliente(idCliente);
			Destino destino = DestinoCRUD.consultarDestino(idDestino);
			Pacote pacote = PacoteCRUD.consultarPacote(idPacote);
			
			System.out.print("Data de Partida(DD/MM/AAAA): ");
			String dataPartidaStr = sc.next();
	
			System.out.print("Data de Retorno(DD/MM/AAAA): ");
			String dataRetornoStr = sc.next();
	
			Date dataPartida = new Date();
			Date dataRetorno = new Date();
	
			try {
				dataPartida = sdf.parse(dataPartidaStr);
				dataRetorno = sdf.parse(dataRetornoStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			ReservaCRUD.atualizar(new Reserva(id, dataPartida, dataRetorno, cliente, destino, pacote));
			Principal.exibirMenu();
		}
	}

	private static void deletar() {
		try (Scanner sc = new Scanner(System.in)) {
				limparTela();
				ReservaCRUD.listarReserva();
				System.out.print("Digite o ID da reserva que voce deseja deletar:");
				int id = sc.nextInt();

				ReservaCRUD.consultarReserva(id);

				System.out.println("=====================================");
				System.out.println("Deseja deletar essa reserva?");
				System.out.println("1 - SIM      2-NAO");
				System.out.println("=====================================");

				int opcao = sc.nextInt();

				if (opcao == 1) {
					ReservaCRUD.removerPorId(id);
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
