package screen;

public class TelaReserva extends Tela{

	public static void exibirFormulario(int operacao, int opcao) {
		limparTela();
		CabecalhoForm(operacao, opcao);
		System.out.println("FORM RESERVA");
	}

}
