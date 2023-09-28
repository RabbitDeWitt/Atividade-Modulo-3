package screen;

public class TelaPacote extends Tela {

	public static void exibirFormulario(int operacao, int opcao) {
		limparTela();
		CabecalhoForm(operacao, opcao);
		System.out.println("FORM PACOTE");
	}

}
