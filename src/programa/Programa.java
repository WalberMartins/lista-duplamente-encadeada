package programa;

import java.util.Scanner;

import listaEncadeada.ListaEncadeada;

public class Programa {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ListaEncadeada<Integer> lista = new ListaEncadeada<>();
		int opcao;
		
		do {
			menu();
			opcao = sc.nextInt();
			processaOpcao(opcao, lista);
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
	
	private static void processaOpcao(int opcao, ListaEncadeada<Integer> lista) {
		Integer numero;
		switch(opcao) {
		case 1:
			try {
				System.out.println();
				System.out.print("Digite um n�mero inteiro: ");
				numero = sc.nextInt();
				lista.addFirst(numero);
				System.out.printf("O n�mero %d foi adicionado com sucesso.%n", numero);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println();
			System.out.print("Digite o n�mero a ser excluido: ");
			numero = sc.nextInt();
			if(!(lista.remove(numero))) {
				System.out.printf("O n�mero %d n�o est� na lista.%n", numero);
			}
			System.out.printf("O n�mero %d foi excluido com sucesso.%n", numero);
			break;
		case 3:
			menuConsultas();
			opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				System.out.println();
				System.out.print("Digite o n�mero a ser consultado: ");
				numero = sc.nextInt();
				if(lista.indexOf(numero) != -1)
					System.out.printf("O n�mero %d est� na lista.%n", numero);
				else
					System.out.printf("O n�mero %d n�o est� na lista.%n", numero);
				break;
			case 2:
				System.out.print("lista: ");
				for(int i = 0; i < lista.size() - 1; i++) {
					System.out.print(""+lista.get(i)+", ");
				}
				System.out.print(""+lista.get(lista.size()-1)+"\n");
				break;
			case 3:
				System.out.print("lista: ");
				for(int i = 0; i < lista.size() - 1; i++) {
					System.out.print(""+lista.getEnd(i)+", ");
				}
				System.out.print(""+lista.getEnd(lista.size()-1)+"\n");
			}
			break;
		case 0:
			System.out.println("PROGRAMA ENCERRADO!!!");
			break;
		default:
			System.out.println("Op��o inv�lida. Tente Novamente:");
		}
	}
}
