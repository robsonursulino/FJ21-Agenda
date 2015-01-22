package br.com.caelum.modelo;

import java.util.Calendar;

public class Contato {
	
	private Long cod_contato;
	private String nome_contato;
	private String email;
	private String endereco;
	private Calendar data_nascimento;

	public void setCod_contato(Long cod_contato) {
		this.cod_contato = cod_contato;
	}

	public Long getCod_contato() {
		return cod_contato;
	}

	public String getNome_contato() {
		return nome_contato;
	}

	public void setNome_contato(String nome_contato) {
		this.nome_contato = nome_contato;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Calendar data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
}
