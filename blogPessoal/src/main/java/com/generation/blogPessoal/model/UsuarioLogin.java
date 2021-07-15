package com.generation.blogPessoal.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioLogin {
	@NotNull
	@Size(min = 6,max = 100)
    private String nome;
	@NotNull
	@Size(min = 6,max = 100)
	private String usuario;
	@NotNull
	@Size(min = 6,max = 100)
	private String senha;
	
	private String token;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}


