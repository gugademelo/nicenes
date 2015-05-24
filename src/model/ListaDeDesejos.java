package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import database.ConnectionFactory;

public class ListaDeDesejos {
	private List<Livro> livros = new ArrayList<Livro>();
	
	public static boolean adiciona(Usuario usuario, Livro livro) {
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}

		String sql = "INSERT INTO lista_desejo (id_usuario, id_livro) VALUES(?, ?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, usuario.getId());
			st.setInt(2, livro.getLivro_id());
			if(st.executeUpdate() == 1) return true;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
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
