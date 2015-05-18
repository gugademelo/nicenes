package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrinho {
	List<Livro> livros = new ArrayList<Livro>();
	public void adiciona(Livro livro) {
		livros.add(livro);
	}
	
	public void remove(Livro livro) {
		Iterator<Livro> iter = this.livros.iterator();
		while(iter.hasNext()){
		    if(iter.next().getLivro_id() == livro.getLivro_id())
		        iter.remove();
		}
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
