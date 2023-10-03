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
			System.out.println("           CONSULTAR POR ID             ");
		break;
		case 4:
			System.out.println("               EDITAR              ");
		break;
		case 5:
			System.out.println("               DELETAR              ");
			break;
		default:
			System.out.println("               MENU               ");			
		break;
	}
		
		System.out.println("===================================");
		System.out.println("");
	}

}
