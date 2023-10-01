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

			for (Cliente cliente : ClienteCRUD.listarCliente()) {
				cliente.mostrar();
			}

			System.out.print("Cliente: ");
			int idCliente = sc.nextInt();

			for (Destino destino : DestinoCRUD.listarDestino()) {
				destino.mostrar();
			}

			System.out.print("Destino: ");
			int idDestino = sc.nextInt();

			for (Pacote pacote : PacoteCRUD.listarPacote()) {
				pacote.mostrar();
			}

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
		}

	}

	private static void deletar() {
		limparTela();
		Scanner sc = new Scanner(System.in);
		boolean concluido = false;

		while (concluido == false) {
			limparTela();
			ReservaCRUD.listarReserva();
			System.out.print("Digite o ID da reserva que voce deseja deletar:");
			int id = sc.nextInt();

			ReservaCRUD.consultarReserva(id);

			System.out.println("===============================");
			System.out.println("Deseja deletar essa reserva?");
			System.out.println("1 - SIM      2-NAO");
			System.out.println("===============================");

			int opcao = sc.nextInt();

			if (opcao == 1) {
				ReservaCRUD.removerPorId(id);
				concluido = true;
			}
		}
		Principal.exibirMenu();
		
	}

	private static void listar() {
		ReservaCRUD.listarReserva();
	}
	
	private static void consultar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID da reserva que voce deseja consultar:");
		int id = sc.nextInt();

		ReservaCRUD.consultarReserva(id);
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
			System.out.println("Editar");
			break;
		case 5:
			deletar();
			break;
		}

	}

}
