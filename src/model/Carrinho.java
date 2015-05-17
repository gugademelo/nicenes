package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	List<Livro> livros = new ArrayList<Livro>();
	public void adiciona(Livro livro) {
		livros.add(livro);
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
