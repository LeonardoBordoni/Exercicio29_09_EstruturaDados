package controller;

public class ListaCircularLogs<T> {
	
	private No<T> inicio;
	private No<T> ultimo;
	private final int MAX_ELEMENTS;
	private boolean bloqueado;
	private int tamanho;
	
	public ListaCircularLogs(int MAX_ELEMENTS) {
		this.inicio = null;
		this.ultimo = null;
		this.MAX_ELEMENTS = MAX_ELEMENTS;
		this.bloqueado = false;
		this.tamanho = 0;
	}

	public void adiciona(T elemento) {
		if (bloqueado == true) {
			System.out.println("ESTÁ IMPRIMINDO, ADIÇÃO BLOQUEADA!!!!!!!");
			return;
		}
		
		if (tamanho == 0) {
			No<T> Novo = new No<>(elemento);
			this.inicio = Novo;
			this.ultimo = Novo;
			this.tamanho++;
			this.inicio.setProximo(inicio);
		} else if (tamanho < MAX_ELEMENTS) {
			No<T> Novo = new No<>(elemento);
			Novo.setProximo(inicio);
			ultimo.setProximo(Novo);
			ultimo = Novo;
			this.tamanho++;
		} else {
			inicio.setElemento(elemento);
			inicio = inicio.getProximo();
			ultimo = ultimo.getProximo();
			
			
		}
		
		
		
	}
	
	
	public void imprimir() {
		this.bloqueado = true;
		ListaAjudante<T> ListaAjudante = new ListaAjudante<>();
		No<T> Atual = this.inicio;
		
		
		for(int i = 0; i < tamanho; i++) {	

			ListaAjudante.adicionaInicio(Atual.getElemento());
			Atual = Atual.getProximo();
		}
		
		System.out.println(ListaAjudante);
		ListaAjudante.limpa();
		this.bloqueado = false;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	

	@Override
	public String toString() {
		if (this.tamanho == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");

		No<T> atual = this.inicio;

		builder.append(atual.getElemento()).append(", ");

		
		for(int i = 0; i < tamanho - 1; i++) {
			atual = atual.getProximo();
			builder.append(atual.getElemento()).append(", ");
		}

		

		builder.deleteCharAt(builder.length() - 1);
		builder.deleteCharAt(builder.length() - 1);


		builder.append("]");
		return builder.toString();
	}
	
}
