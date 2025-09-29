package controller;

public class ListaAjudante<T> {

	private No<T> inicio;
	private No<T> ultimo;

	private int tamanho = 0;
	
	public void adiciona(T elemento) {
		No<T> celula = new No<T>(elemento);

		if (tamanho == 0) {
			this.inicio = celula;
		} else {
			this.ultimo.setProximo(celula);
		}

		this.ultimo = celula;
		this.tamanho++;
	}

	public void adicionaInicio(T elemento) {
		if (this.tamanho == 0) {
			No<T> Novo = new No<>(elemento);
			this.inicio = Novo;
			this.ultimo = Novo;

		} else {
			No<T> Novo = new No<>(elemento);
			Novo.setProximo(this.inicio);
			Novo.setElemento(elemento);
			this.inicio = Novo;

		}
		this.tamanho++;
	}


	public void limpa() {
		No<T> atual = this.inicio;

		while (atual != null) {
			No<T> proximo = atual.getProximo();
			atual.setElemento(null);
			atual.setProximo(null);
			atual = proximo;

		}

		this.inicio = null;
		this.ultimo = null;
		this.tamanho = 0;

	}

	@Override
	public String toString() {
		if (this.tamanho == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");

		No<T> atual = this.inicio;

		builder.append(atual.getElemento()).append(", ");

		while (atual.getProximo() != null) {
			atual = atual.getProximo();
			builder.append(atual.getElemento()).append(", ");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.deleteCharAt(builder.length() - 1);
		builder.append("]");
		return builder.toString();
	}

}