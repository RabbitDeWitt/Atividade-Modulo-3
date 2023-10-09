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
			boolean clienteValido = false, destinoValido = false, pacoteValido = false;
			
			Cliente cliente = new Cliente();
			Destino destino = new Destino();
			Pacote pacote = new Pacote();

			while (clienteValido == false) {
				ClienteCRUD.listarCliente();

				System.out.print("Cliente: ");
				int idCliente = sc.nextInt();
				Cliente c = ClienteCRUD.consultarCliente(idCliente);
				if (c.getId() != 0) {
					cliente.setId(c.getId());
					cliente.setNome(c.getNome());
					cliente.setDataNasc(c.getDataNasc());
					cliente.setTelefone(c.getTelefone());
					cliente.setNumPassaporte(c.getNumPassaporte());
					clienteValido = true;
				}else {
					System.out.println("=====================================");
					System.out.println("Cliente nao encontrado...");
					System.out.println("=====================================");
				}
			}

			while(destinoValido == false) {
				DestinoCRUD.listarDestino();
				System.out.print("Destino: ");
				int idDestino = sc.nextInt();
				Destino d = DestinoCRUD.consultarDestino(idDestino);
				if(d.getId() != 0) {
					destino.setId(d.getId());
					destino.setNome(d.getNome());
					destino.setEstado(d.getEstado());
					destino.setPais(d.getPais());
					destino.setValor(d.getValor());
					destinoValido = true;
				}else {
					System.out.println("=====================================");
					System.out.println("Destino nao encontrado...");
					System.out.println("=====================================");
				}
			}
			
			while (pacoteValido == false) {
				PacoteCRUD.listarPacote();
				System.out.print("Pacote: ");
				int idPacote = sc.nextInt();
				Pacote p = PacoteCRUD.consultarPacote(idPacote);
				if(p.getId() != 0) {
					pacote.setId(p.getId());
					pacote.setNome(p.getNome());
					pacote.setValor(p.getValor());
					pacoteValido = true;
				}else {
					System.out.println("=====================================");
					System.out.println("Pacote nao encontrado...");
					System.out.println("=====================================");
				}
			}
			
			
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


			ReservaCRUD.cadastrar(new Reserva(dataPartida, dataRetorno, cliente, destino, pacote));

			Principal.exibirMenu();
		}

	}

	private static void listar() {
		try (Scanner sc = new Scanner(System.in)) {
			boolean concluido = false;

			ReservaCRUD.listarReserva();

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
			System.out.print("Digite o ID da reserva que voce deseja consultar: ");
			int id = sc.nextInt();

			Reserva reserva = ReservaCRUD.consultarReserva(id);
			
			if(reserva.getId() != 0) {
				reserva.mostrar();				
			}else {
				System.out.println("Reserva nao encontrada...");
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
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			boolean clienteValido = false, destinoValido = false, pacoteValido = false, reservaValida = false;
			int id = 0;
			Cliente cliente = new Cliente();
			Destino destino = new Destino();
			Pacote pacote = new Pacote();
			
			while(reservaValida == false) {
				ReservaCRUD.listarReserva();
				System.out.print("Qual reserva voce deseja editar:");
				id = sc.nextInt();
				Reserva r = ReservaCRUD.consultarReserva(id);
				if(r.getId() != 0) {
					reservaValida = true;	
				}else {
					System.out.println("Reserva nao encontrada...");
				}
			}

			while (clienteValido == false) {
				ClienteCRUD.listarCliente();

				System.out.print("Cliente: ");
				int idCliente = sc.nextInt();
				Cliente c = ClienteCRUD.consultarCliente(idCliente);
				if (c.getId() != 0) {
					cliente.setId(c.getId());
					cliente.setNome(c.getNome());
					cliente.setDataNasc(c.getDataNasc());
					cliente.setTelefone(c.getTelefone());
					cliente.setNumPassaporte(c.getNumPassaporte());
					clienteValido = true;
				}else {
					System.out.println("=====================================");
					System.out.println("Cliente nao encontrado...");
					System.out.println("=====================================");
				}
			}

			while(destinoValido == false) {
				DestinoCRUD.listarDestino();
				System.out.print("Destino: ");
				int idDestino = sc.nextInt();
				Destino d = DestinoCRUD.consultarDestino(idDestino);
				if(d.getId() != 0) {
					destino.setId(d.getId());
					destino.setNome(d.getNome());
					destino.setEstado(d.getEstado());
					destino.setPais(d.getPais());
					destino.setValor(d.getValor());
					destinoValido = true;
				}else {
					System.out.println("=====================================");
					System.out.println("Destino nao encontrado...");
					System.out.println("=====================================");
				}
			}

			while (pacoteValido == false) {
				PacoteCRUD.listarPacote();
				System.out.print("Pacote: ");
				int idPacote = sc.nextInt();
				Pacote p = PacoteCRUD.consultarPacote(idPacote);
				if(p.getId() != 0) {
					pacote.setId(p.getId());
					pacote.setNome(p.getNome());
					pacote.setValor(p.getValor());
					pacoteValido = true;
				}else {
					System.out.println("=====================================");
					System.out.println("Destino nao encontrado...");
					System.out.println("=====================================");
				}
			}


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
			boolean reservaValida = false;
			int id = 0;
			while(reservaValida == false) {
				ReservaCRUD.listarReserva();
				System.out.print("Digite o ID da reserva que voce deseja deletar:");
				id = sc.nextInt();
				
				Reserva reserva = ReservaCRUD.consultarReserva(id);
				
				if(reserva.getId() != 0) {
					reserva.mostrar();
					reservaValida = true;
				}else {
					System.out.println("Reserva nao encontrada...");
				}
			}

			System.out.println("=====================================");
			System.out.println("Deseja deletar essa reserva?");
			System.out.println("1 - SIM      2-NAO");
			System.out.println("=====================================");

			int opcao = sc.nextInt();

			if (opcao == 1) {
				ReservaCRUD.removerPorId(id);
				Principal.exibirMenu();
			} else if (opcao == 2) {
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
