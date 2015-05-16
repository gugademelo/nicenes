package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import database.ConnectionFactory;

public class Autor {
	private Integer autor_Id, qtdLivros;
	private String nome, sobrenome, principalLivro, endereco, telefone, email, rg, obs; 
	private Date dtNascimento;
	
	public Autor()
	{
	
	}
	
	
	
	public Autor(Integer autor_Id, Integer qtdLivros, String nome,
			String sobrenome, String principalLivro, String endereco,
			String telefone, String email, String rg, String obs,
			Date dtNascimento) {
		super();
		this.autor_Id = autor_Id;
		this.qtdLivros = qtdLivros;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.principalLivro = principalLivro;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.rg = rg;
		this.obs = obs;
		this.dtNascimento = dtNascimento;
	}
	
	public boolean salva() {
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}

		String sql = "INSERT INTO AUTOR (nome, sobrenome, dtNascimento, principalLivro, endereco, telefone, email, rg, obs, qtdLivros) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, this.getNome());
			st.setString(2, this.getSobrenome());
			//st.setDate  (3, this.getDtNascimento());
			st.setString(4, this.getPrincipalLivro());
			st.setString(5, this.getEndereco());
			st.setString(6, this.getTelefone());
		    //st.setDate  (7,   this.getEmail());
			st.setString(8, this.getRg());
			st.setString(9, this.getObs());
			st.setInt   (10, this.getQtdLivros());
			if(st.executeUpdate() == 1) return true;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}
	
	public boolean atualizarAutor(Autor autor)
	{
		Connection con = new ConnectionFactory().getConnection();
		
		if(con == null){
			return false;	
		}
		String sql = "UPDATE AUTOR(nome = ?, sobrenome = ?, dtNascimento = ?, principalLivro = ?, endereco = ?, telefone = ?, email = ?, rg = ?, obs = ?, qtdLivros = ?) WHERE autor_Id = ?";
		try{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, autor.nome);
			st.setString(2, autor.sobrenome);
			java.sql.Date sqlData = new java.sql.Date(autor.dtNascimento.getTime());
			st.setDate(3, sqlData);
			st.setString(4, autor.principalLivro);
			st.setString(5, autor.endereco);
			st.setString(6, autor.telefone);
		    st.setString(7, autor.email);
			st.setString(8, autor.rg);
			st.setString(9, autor.obs);
			st.setInt   (10, autor.qtdLivros);
			st.setInt   (11, autor.autor_Id);
			return true;
		} catch (SQLException e){
			
			e.printStackTrace();
			return false;
		}
	}



	public Integer getAutor_Id() {
		return autor_Id;
	}
	public void setAutor_Id(Integer autor_Id) {
		this.autor_Id = autor_Id;
	}
	public Integer getQtdLivros() {
		return qtdLivros;
	}
	public void setQtdLivros(Integer qtdLivros) {
		this.qtdLivros = qtdLivros;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getPrincipalLivro() {
		return principalLivro;
	}
	public void setPrincipalLivro(String principalLivro) {
		this.principalLivro = principalLivro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	

	
}
