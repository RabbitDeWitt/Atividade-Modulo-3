package screen;

public class TelaCliente extends Tela {
	private static void cadastrar() {
		
	}

	private static void listar() {
		
	}

	private static void consultar() {
		
	}

	private static void editar() {
		
	}

	private static void deletar() {
		
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
