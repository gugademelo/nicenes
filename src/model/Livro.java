package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import database.ConnectionFactory;

public class Livro {
	private Integer livro_id;
	private String titulo, isbn, colecao, edicao, idioma, assunto;
	private Date ano;
	private String autor;
	private String editora;
	private String categoria;
	
	public Livro()
	{
	
	}
	
	public Livro(int livro_id ,String titulo, String isbn, String colecao, String edicao, String idioma, String assunto, Date ano, String autor, String editora, String categoria)
	{
		this.livro_id = livro_id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.colecao = colecao;
		this.edicao = edicao;
		this.idioma = idioma;
		this.assunto = assunto;
		this.ano = ano;
		this.autor = autor;
		this.editora = editora;
		this.categoria = categoria;
		
	}
	
	public boolean inserirLivro() {
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}

		String sql = "INSERT INTO livro (titulo, isbn, colecao, edicao, idioma, assunto, ano, autor, editora, categoria) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, this.getTitulo());
			st.setString(2, this.getIsbn());
			st.setString(3, this.getColecao());
			st.setString(4, this.getEdicao());
			st.setString(5, this.getIdioma());
			st.setString(6, this.getAssunto());
		  //st.setDate(7,   this.getAno());
			st.setString(8, this.getAutor());
			st.setString(9, this.getEditora());
			st.setString(10, this.getCategoria());
			if(st.executeUpdate() == 1) return true;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}
	
	public boolean atualizarLivro(Livro livro)
	{
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}
		String sql = "UPDATE LIVRO(titulo = ?, isbn = ?, colecao = ?, edicao = ?, idioma = ?, assunto = ?, ano = ?, autor = ?, editora = ?, categoria = ?) WHERE livro_id = ?";
		try{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, livro.titulo);
			st.setString(2, livro.isbn);
			st.setString(3, livro.colecao);
			st.setString(4, livro.edicao);
			st.setString(5, livro.idioma);
			st.setString(6, livro.assunto);
		    //st.setDate(7,   livro.ano);
			st.setString(8, livro.autor);
			st.setString(9, livro.editora);
			st.setString(10, livro.categoria);
			st.setInt   (11, livro.livro_id);
			return true;
			
		} catch (SQLException e){
			
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Integer getLivro_id() {
		return livro_id;
	}

	public void setLivro_id(Integer livro_id) {
		this.livro_id = livro_id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getColecao() {
		return colecao;
	}
	public void setColecao(String colecao) {
		this.colecao = colecao;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Date getAno() {
		return ano;
	}
	public void setAno(Date ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
