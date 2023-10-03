package screen;

import java.util.Scanner;

public class Principal extends Tela {
	public static void exibirMenu() {
		int opcao = 0; 
		Scanner sc = new Scanner(System.in);
		
		limparTela();
		
		Cabecalho(opcao);
		
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Consultar por ID");
		System.out.println("4 - Editar");
		System.out.println("5 - Deletar");
		System.out.println("6 - Sair");
		System.out.println("");
		
		System.out.print("Digite a opcao desejada: ");
		opcao = sc.nextInt();
		
		
		
		if(opcao >= 1 && opcao <= 5) {
			Secundaria.exibirMenu(opcao);			
		}else if(opcao == 6){
			System.exit(6);
		}else {
			exibirMenu();			
		}
		
		
	} 	

}
