package screen;

public class TelaDestino extends Tela{
	public static void exibirFormulario(int operacao, int opcao) {
		limparTela();
		CabecalhoForm(operacao, opcao);
		System.out.println("FORM DESTINO");
	}

}
