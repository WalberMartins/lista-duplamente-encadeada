package programa;

import java.util.Scanner;

public class Programa {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao;
		do {
			menu();
			opcao = sc.nextInt();
		}while(opcao != 0);
	}
	
	private static void menu() {
		System.out.println();
		System.out.println("\t1. Inserir um n�mero no inicio da lista");
		System.out.println("\t2. Excluir um n�mero");
		System.out.println("\t3. Consulta");
		System.out.println("\t0. Encerrar");
		System.out.print("\t\tdigite a op��o: ");
	}
	
	private static void menuConsultas() {
		System.out.println();
		System.out.println("\t1. Consultar por n�mero");
		System.out.println("\t2. Listar do in�cio para fim");
		System.out.println("\t3. Listar do fim para in�cio");
		System.out.print("\t\tdigite a op��o: ");
		
	}
	
	private static void processaOpcao(int opcao) {
		switch(opcao) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			menuConsultas();
			opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				break;
			case 2: 
				break;
			case 3:
				
			}
			break;
		
		}
	}

}
