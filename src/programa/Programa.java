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
		System.out.println("\t1. Inserir um número no inicio da lista");
		System.out.println("\t2. Excluir um número");
		System.out.println("\t3. Consulta");
		System.out.println("\t0. Encerrar");
		System.out.print("\t\tdigite a opção: ");
	}
	
	private static void menuConsultas() {
		System.out.println();
		System.out.println("\t1. Consultar por número");
		System.out.println("\t2. Listar do início para fim");
		System.out.println("\t3. Listar do fim para início");
		System.out.print("\t\tdigite a opção: ");
		
	}
	
	private static void processaOpcao(int opcao, ListaEncadeada<Integer> lista) {
		Integer numero;
		switch(opcao) {
		case 1:
			try {
				System.out.println();
				System.out.print("Digite um número inteiro: ");
				numero = sc.nextInt();
				lista.addFirst(numero);
				System.out.printf("O número %d foi adicionado com sucesso.%n", numero);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println();
			System.out.print("Digite o número a ser excluido: ");
			numero = sc.nextInt();
			if(!(lista.remove(numero))) {
				System.out.printf("O número %d não está na lista.%n", numero);
			}
			System.out.printf("O número %d foi excluido com sucesso.%n", numero);
			break;
		case 3:
			menuConsultas();
			opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				System.out.println();
				System.out.print("Digite o número a ser consultado: ");
				numero = sc.nextInt();
				if(lista.indexOf(numero) != -1)
					System.out.printf("O número %d está na lista.%n", numero);
				else
					System.out.printf("O número %d não está na lista.%n", numero);
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
			System.out.println("Opção inválida. Tente Novamente:");
		}
	}
}
