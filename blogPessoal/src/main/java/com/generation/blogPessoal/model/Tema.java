package com.generation.blogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String discricao;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("postagemCriada")
	private List<Postagem> postagemCriada = new ArrayList<>();

	
	public List<Postagem> getPostagemCriada() {
		return postagemCriada;
	}

	public void setPostagemCriada(List<Postagem> postagemCriada) {
		this.postagemCriada = postagemCriada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDiscricao() {
		return discricao;
	}

	public void setDiscricao(String discricao) {
		this.discricao = discricao;
	}

}
