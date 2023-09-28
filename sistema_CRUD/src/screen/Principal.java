package screen;

import java.util.Scanner;

public class Principal extends Tela {
	public static void exibirMenu() {
		int opcao = 0; 
		Scanner entrada = new Scanner(System.in);
		
		limparTela();
		
		Cabecalho(opcao);
		
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Editar");
		System.out.println("4 - Deletar");
		System.out.println("5 - Sair");
		System.out.println("");
		
		System.out.print("Digite a opcao desejada: ");
		opcao = entrada.nextInt();
		
		
		
		if(opcao >= 1 && opcao <= 4) {
			Secundaria.exibirMenu(opcao);			
		}else if(opcao == 5){
			System.exit(5);
		}else {
			exibirMenu();			
		}
		
		
	} 	

}
