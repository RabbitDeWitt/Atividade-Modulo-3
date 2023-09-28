import java.util.Date;

import model.Cliente;
import screen.Principal;
import sistema_CRUD.ClienteCRUD;

public class Sistema {
	public static void main(String[] args) {
		//Principal.exibirMenu();
		
		//ClienteCRUD.cadastrar(new Cliente("Zakk Wylde", new Date(),"55 (11) 1234-5678","BR000011"));
		//ClienteCRUD.atualizar(new Cliente(2, "John", new Date(),"55 (11) 6789-1234","BR000002"));
		
		
		ClienteCRUD.removerPorId(3);
		
		for(Cliente cliente : ClienteCRUD.listarCliente()) {
			cliente.mostrar();
		}
		
	}

}
