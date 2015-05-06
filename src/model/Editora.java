package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import database.ConnectionFactory;

public class Editora {
	
	private Integer cep,fone,cnpj;
	private String nome, endereco, cidade, uf, pais, assunto,razaoSocial,web;
	
	
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public Integer getFone() {
		return fone;
	}
	public void setFone(Integer fone) {
		this.fone = fone;
	}
	public Integer getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}

	public boolean salva() {
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}

		String sql = "INSERT INTO editora "
					+ "(nome, endereco,cidade,uf,pais,cep,fone,cnpj,razao,web) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,this.getNome());
			st.setString(2,this.getEndereco());
			st.setString(3,this.getCidade());
			st.setString(4,this.getUf());
			st.setString(5,this.getPais());
			st.setInt(6,this.getCep());
			st.setInt(7,this.getFone());
			st.setInt(8,this.getCnpj());
			st.setString(9,this.getRazaoSocial());
			st.setString(10,this.getWeb());
			
			
			if(st.executeUpdate() == 1) return true;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}
	

}
