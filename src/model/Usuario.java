package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;

public class Usuario {
	private String nome, email, senha;
	private int id, perfil;

	public Usuario(int id, String nome, String email, String senha, int perfil) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}
	
	public Usuario() {}
	
	public boolean salva() {
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}

		String sql = "INSERT INTO usuario (nome, email, senha, id_perfil) VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, this.getNome());
			st.setString(2, this.getEmail());
			st.setString(3, this.getSenha());
			st.setInt(4, this.getPerfil());
			if(st.executeUpdate() == 1) return true;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}
	
	public static Usuario login(String email, String senha){
		Connection con = new ConnectionFactory().getConnection();
		
		String sql="SELECT * FROM usuario WHERE email = ? AND senha = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("id_perfil"));
				return usuario;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Usuario> lista() {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql="SELECT * FROM usuario";
		
		List<Usuario> usuarios = null;
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			usuarios = new ArrayList<Usuario>();
			
			while(rs.next()) {
				Usuario usuario = new Usuario(Integer.parseInt(rs.getString("id_usuario")), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), Integer.parseInt(rs.getString("id_perfil")));
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
}
