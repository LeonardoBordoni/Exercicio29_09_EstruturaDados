package view;

import controller.ListaCircularLogs;

public class Teste {
	public static void main (String Args[]) {
		
		int MAX_ELEMENTS = 1000;
		
		ListaCircularLogs<String> Lista = new ListaCircularLogs<>(MAX_ELEMENTS);

		for (int i = 0; i <= MAX_ELEMENTS; i++) {
			Lista.adiciona("LOG DE ERRO: " + i);
		}
		
		System.out.println("Lista organizada por ordem inversa: ");
		Lista.imprimir();

		int tamanho = Lista.getTamanho();
		
		System.out.println("Quantidade de logs de erro: " + tamanho);

		System.out.println("Lista com ordem original para poder comparar: ");
		System.out.println(Lista);

	}
}
