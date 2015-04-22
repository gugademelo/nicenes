package model;

import java.sql.*;

import database.ConnectionFactory;

public class Usuario {
	private String nome, email, senha;

	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario() {}
	
	public boolean salva() {
		Connection con = new ConnectionFactory().getConnection("localhost", "nicenes", "root", "");
		
		if(con == null){
			return false;	
		}
		
		String sql = "INSERT INTO usuario (nome, email, senha, cd_perfil) VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, this.getNome());
			st.setString(2, this.getEmail());
			st.setString(1, this.getSenha());
			st.setInt(1, 2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
