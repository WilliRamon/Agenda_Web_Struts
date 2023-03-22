package br.com.agendaweb.vo;

import java.util.Date;

public class Pessoa {
	
	private Long id;
	private String nome;
	private int idade;
	private String sexo;
//	private Date dataCadastro  = new java.sql.Date(System.currentTimeMillis());
	private Date dataCadastro;
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", dataCadastro="
				+ dataCadastro + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
}
