import java.util.Date;

import model.Cliente;
import model.Destino;
import model.Pacote;
import model.Reserva;
import screen.Principal;
import sistema_CRUD.ClienteCRUD;
import sistema_CRUD.DestinoCRUD;
import sistema_CRUD.PacoteCRUD;
import sistema_CRUD.ReservaCRUD;

public class Sistema {
	public static void main(String[] args) {
		//Principal.exibirMenu();
		
		//CLIENTE
		//ClienteCRUD.cadastrar(new Cliente("Zakk Wylde", new Date(),"55 (11) 1234-5678","BR000011"));
		//ClienteCRUD.atualizar(new Cliente(2, "John", new Date(),"55 (11) 6789-1234","BR000002"));
		//ClienteCRUD.removerPorId(3);
		//for(Cliente cliente : ClienteCRUD.listarCliente()) {
		//	Cliente.mostrar();
		//}
		//ClienteCRUD.consultarCliente(5).mostrar();
		
		
		//DESTINO
		//DestinoCRUD.cadastrar(new Destino("Rio de Janeito", "RJ", "Brasil", 750));
		//DestinoCRUD.atualizar(new Destino(2 ,"Rio de Janeiro", "RJ", "Brasil", 750));
		//DestinoCRUD.removerPorId(1);
		//for(Destino destino : DestinoCRUD.listarDestino()) {
		//	destino.mostrar();
		//}
		//DestinoCRUD.consultarDestino(2).mostrar();
		
		//PACOTES
		//PacoteCRUD.cadastrar(new Pacote("Economico", 0));
		//PacoteCRUD.cadastrar(new Pacote("Premium", 100));
		//PacoteCRUD.atualizar(new Pacote(2, "Economico", 500));
		//DestinoCRUD.removerPorId(1);
		//for(Pacote pacote : PacoteCRUD.listarPacote()) {
		//	pacote.mostrar();
		//}
		//PacoteCRUD.consultarPacote(2).mostrar();
		
		//RESERVA
		Cliente cliente = ClienteCRUD.consultarCliente(7);
		Destino destino = DestinoCRUD.consultarDestino(3);
		Pacote pacote = PacoteCRUD.consultarPacote(2);
		
		ReservaCRUD.cadastrar(new Reserva(new Date(), new Date(), cliente, destino, pacote));
		
		
	}

}
