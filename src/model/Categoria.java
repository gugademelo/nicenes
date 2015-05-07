package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;

public class Categoria {
	
	private String categoria;

	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String nomeCat) {
		this.categoria = nomeCat;
	}
	
	public boolean salva() {
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}

		String sql = "INSERT INTO categoria (categoria) VALUES(?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, this.getCategoria());
			if(st.executeUpdate() == 1) return true;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}

	public List<Categoria> lista() {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql="SELECT * FROM categoria";
		
		List<Categoria> categorias = null;
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			categorias = new ArrayList<Categoria>();
			
			while(rs.next()) {
				Categoria cat = new Categoria();
				cat.setCategoria(rs.getString("categoria"));
				
				categorias.add(cat);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return categorias;
		

	}

}
