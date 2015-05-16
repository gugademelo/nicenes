package model;

import java.text.ParseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionFactory;

public class Livro {
	private Integer livro_id;
	private String titulo, isbn, colecao, edicao, idioma, assunto;
	private Integer ano;
	private String autor;
	private String editora;
	private String categoria;
	
	public Livro()
	{
	
	}
	
	public Livro(int livro_id ,String titulo, String isbn, String colecao, String edicao, String idioma, String assunto, Integer ano, String autor, String editora, String categoria)
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
	
	public boolean salva() {
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
			st.setInt(7,   this.getAno());
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
	
	public boolean exclui() {
		Connection con = new ConnectionFactory().getConnection();

		if (con == null) {
			return false;
		}

		String sql = "DELETE FROM LIVRO WHERE livro_id = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, this.getLivro_id());
			if (st.executeUpdate() == 1) return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List<Livro> lista() {
		Connection con = new ConnectionFactory().getConnection();

		String sql = "SELECT * FROM LIVRO";

		List<Livro> livros = null;

		try {
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			livros = new ArrayList<Livro>();

			while (rs.next()) {
				Livro livro = new Livro(rs.getInt("id"), rs.getString("nome"),
				rs.getString("isbn"),
				rs.getString("colecao"),
				rs.getString("edicao"),
				rs.getString("idioma"),
				rs.getString("assunto"),
			    rs.getInt  ("ano"), // verificar formato de data
				rs.getString("autor"),
				rs.getString("editora"),
				rs.getString("categoria"));
				
				
				livros.add(livro);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return livros;
	}
	
	public static Livro getLivroPeloId(int id) {
		Connection con = new ConnectionFactory().getConnection();

		String sql = "SELECT * FROM LIVRO WHERE livro_id = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Livro livro = new Livro(rs.getInt("id"), rs.getString("nome"),
						rs.getString("isbn"),
						rs.getString("colecao"),
						rs.getString("edicao"),
						rs.getString("idioma"),
						rs.getString("assunto"),
					    rs.getInt  ("ano"), // verificar formato de data
						rs.getString("autor"),
						rs.getString("editora"),
						rs.getString("categoria"));
				
				return livro;
			}
			
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
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
