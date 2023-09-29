package screen;

import java.util.Scanner;

public class Secundaria extends Tela{

	public static void exibirMenu(int opcao) {
		final int operacao = opcao;
		
		limparTela();
		Cabecalho(operacao);
		
		System.out.println("1 - Cliente");
		System.out.println("2 - Destino");
		System.out.println("3 - Reserva");
		System.out.println("4 - Pacote");
		System.out.println("5 - Voltar");
		System.out.println("");
		
		System.out.print("Digite a opcao desejada: ");
		
		Scanner entrada = new Scanner(System.in);
		opcao = entrada.nextInt();
		
		switch (opcao) {
		case 1:
			TelaCliente.exibirFormulario(operacao, opcao);
		break;
		case 2:
			TelaDestino.exibirFormulario(operacao, opcao);
			break;
		case 3:
			TelaReserva.exibirFormulario(operacao, opcao);
			break;
		case 4:
			TelaPacote.exibirFormulario(operacao, opcao);
			break;
		case 5:
			Principal.exibirMenu();			
			break;
		default:
			exibirMenu(opcao);			
			break;
		}
			
		
	}

}