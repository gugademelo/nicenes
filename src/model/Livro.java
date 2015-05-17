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
import model.Autor;
import model.Editora;
import model.Categoria;

public class Livro {
	private Integer livro_id;
	private String titulo, isbn, colecao, edicao, idioma;
	private Integer ano; 
	private double preco;
	private Autor autor;
	private Editora editora;
	private Categoria categoria;
	
	public Livro()
	{
	
	}
	
	public Livro(int livro_id ,String titulo, String isbn, String colecao, String edicao, String idioma, double preco, Integer ano, int autor, int editora, int categoria)
	{
		this.livro_id = livro_id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.colecao = colecao;
		this.edicao = edicao;
		this.idioma = idioma;
		this.preco = preco;
		this.ano = ano;
		this.autor = Autor.getAutorPeloId(autor);
		this.editora = Editora.getEditoraPeloId(editora);
		this.categoria = Categoria.getCategoriaPeloId(categoria);
		
	}
	
	public boolean salva() {
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}

		String sql = "INSERT INTO livro (titulo, isbn, colecao, edicao, idioma, preco, ano, id_autor, id_editora, id_categoria) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, this.getTitulo());
			st.setString(2, this.getIsbn());
			st.setString(3, this.getColecao());
			st.setString(4, this.getEdicao());
			st.setString(5, this.getIdioma());
			st.setDouble(6, this.getPreco());
			st.setInt(7,   this.getAno());
			st.setInt(8, this.autor.getAutor_Id());
			st.setInt(9, this.editora.getId());
			st.setInt(10, this.categoria.getCategoria_id());
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
		String sql = "UPDATE LIVRO(titulo = ?, isbn = ?, colecao = ?, edicao = ?, idioma = ?, preco = ?, ano = ?, autor = ?, editora = ?, categoria = ?) WHERE livro_id = ?";
		try{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, livro.titulo);
			st.setString(2, livro.isbn);
			st.setString(3, livro.colecao);
			st.setString(4, livro.edicao);
			st.setString(5, livro.idioma);
			st.setDouble(6, livro.preco);
		    //st.setDate(7,   livro.ano);
			st.setInt(8, livro.autor.getAutor_Id());
			st.setInt(9, livro.editora.getId());
			st.setInt(10, livro.categoria.getCategoria_id());
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
	
	public static List<Livro> lista() {
		Connection con = new ConnectionFactory().getConnection();

		String sql = "SELECT * FROM livro";

		List<Livro> livros = null;

		try {
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			livros = new ArrayList<Livro>();

			while (rs.next()) {
				Livro livro = new Livro(rs.getInt("id_livro"), rs.getString("titulo"),
				rs.getString("isbn"),
				rs.getString("colecao"),
				rs.getString("edicao"),
				rs.getString("idioma"),
				rs.getDouble("preco"),
			    rs.getInt  ("ano"), // verificar formato de data
				rs.getInt("id_autor"),
				rs.getInt("id_editora"),
				rs.getInt("id_categoria"));
				
				
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

		String sql = "SELECT * FROM livro WHERE id_livro = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Livro livro = new Livro(rs.getInt("id_livro"), rs.getString("titulo"),
						rs.getString("isbn"),
						rs.getString("colecao"),
						rs.getString("edicao"),
						rs.getString("idioma"),
						rs.getDouble("preco"),
					    rs.getInt  ("ano"), // verificar formato de data
						rs.getInt("id_autor"),
						rs.getInt("id_editora"),
						rs.getInt("id_categoria"));
				
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(int autor) {
		this.autor = Autor.getAutorPeloId(autor);
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(int editora) {
		this.editora = Editora.getEditoraPeloId(editora);
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = Categoria.getCategoriaPeloId(categoria);
	}
	
	
	
	
}
