package testes;

import listaEncadeada.ListaEncadeada;

public class Teste {

	public static void main(String[] args) throws Exception {
		
		ListaEncadeada<String> lista = new ListaEncadeada<String>();
		
		lista.add("p");
		lista.add("s");
		lista.add("t");
		lista.add("q");
		
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.getEnd(i));
		}
		


	}

}
