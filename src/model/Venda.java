package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectionFactory;

public class Venda {
	int id_venda, id_usuario;
	String frete;
	double valor_frete;
	public Venda(int id_usuario, String frete, double valor_frete) {
		super();
		this.id_usuario = id_usuario;
		this.frete = frete;
		this.valor_frete = valor_frete;
	}
	public Venda() {}
	
	public boolean salva() {
		Connection con = new ConnectionFactory().getConnection();

		if (con == null) {
			return false;
		}
		
		String sql = "INSERT INTO venda (frete, valor_frete, id_usuario) VALUES(?, ?, ?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, this.getFrete());
			st.setDouble(2, this.getValor_frete());
			st.setInt(3, this.getId_usuario());
			
			if (st.executeUpdate() == 1)
				return true;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	public int getId_venda() {
		return id_venda;
	}
	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getFrete() {
		return frete;
	}
	public void setFrete(String frete) {
		this.frete = frete;
	}
	public double getValor_frete() {
		return valor_frete;
	}
	public void setValor_frete(double valor_frete) {
		this.valor_frete = valor_frete;
	}
	
}
