package br.com.chronosacademy.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.chronosacademy.model.Plataforma;

public class PlataformaForm {
	@NotNull @NotEmpty @Length(min = 3) 
	private String nome;
	@NotNull @NotEmpty @Length(min = 5)
	private String url;
	@NotNull @NotEmpty @Length(min = 10)
	private String descricao;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Plataforma converter() {
		return new Plataforma(nome, url, descricao);
	}
	
}
