import java.util.Date;

import model.Cliente;
import model.Destino;
import model.Pacote;
import screen.Principal;
import sistema_CRUD.ClienteCRUD;
import sistema_CRUD.DestinoCRUD;
import sistema_CRUD.PacoteCRUD;

public class Sistema {
	public static void main(String[] args) {
		//Principal.exibirMenu();
		
		//Destino
		//DestinoCRUD.cadastrar(new Destino("Zakk Wylde", new Date(),"55 (11) 1234-5678","BR000011"));
		//DestinoCRUD.atualizar(new Destino(2, "John", new Date(),"55 (11) 6789-1234","BR000002"));
		//DestinoCRUD.removerPorId(3);
		//for(Destino Destino : DestinoCRUD.listarDestino()) {
		//	Destino.mostrar();
		//}
		
		
		//DESTINO
		//DestinoCRUD.cadastrar(new Destino("Rio de Janeito", "RJ", "Brasil", 750));
		//DestinoCRUD.atualizar(new Destino(2 ,"Rio de Janeiro", "RJ", "Brasil", 750));
		//DestinoCRUD.removerPorId(1);
		//for(Destino destino : DestinoCRUD.listarDestino()) {
		//	destino.mostrar();
		//}
		
		//PACOTES
		//PacoteCRUD.cadastrar(new Pacote("Economico", 0));
		//PacoteCRUD.cadastrar(new Pacote("Premium", 100));
		//PacoteCRUD.atualizar(new Pacote(2, "Economico", 500));
		//DestinoCRUD.removerPorId(1);
		//for(Pacote pacote : PacoteCRUD.listarPacote()) {
		//	pacote.mostrar();
		//}
		
		//RESERVA
		Cliente hendrix = new Cliente("Jimi Hendrix", new Date(), "(55) 55 1234-5678", "BR123456");
		Destino bahia = new Destino("Bahia", "BA", "Brasil", 600);
		Pacote extra = new Pacote("Extra", 200);
		//ClienteCRUD.cadastrar(hendrix);
		//DestinoCRUD.cadastrar(bahia);
		//PacoteCRUD.cadastrar(extra);
		
		
	}

}
