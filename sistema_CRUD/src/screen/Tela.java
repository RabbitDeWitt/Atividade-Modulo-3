package screen;

public abstract class Tela {

	public static void limparTela(){
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void Cabecalho(int numTela) {
		System.out.println("===================================");
	switch (numTela) {
		case 1: 
			System.out.println("              CADASTRAR             ");
		break;
		case 2: 
			System.out.println("               LISTAR               ");
		break;
		case 3: 
			System.out.println("               EDITAR               ");
		break;
		case 4:
			System.out.println("               DELETAR              ");
		break;
		default:
			System.out.println("               MENU               ");			
		break;
	}
		
		System.out.println("===================================");
		System.out.println("");
	}
	
	public static void CabecalhoForm(int operacao, int opcao) {
		String strOperacao;
		String strOpcao;
		
		switch (operacao) {
		case 1: 
			strOperacao = "CADASTRAR";
			break;
		case 2: 
			strOperacao = "LISTAR";
			break;
		case 3: 
			strOperacao = "EDITAR";
			break;
		default:
			strOperacao = "DELETAR";
			break;
		}
		switch (opcao) {
		case 1: 
			strOpcao = "CLIENTE";
			break;
		case 2: 
			strOpcao = "DESTINO";
			break;
		case 3: 
			strOpcao = "RESERVA";
			break;
		default:
			strOpcao = "PACOTE";
			break;
		}
			System.out.println("===================================");
			System.out.println(strOperacao+" "+strOpcao);
			System.out.println("===================================");
			System.out.println("");
	}

}
