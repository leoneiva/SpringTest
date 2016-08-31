package br.com.caelum.tarefas.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	private int id;
	private String login;
	private String senha;
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
}
