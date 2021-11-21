package br.com.chronosacademy.controller.dto;

import br.com.chronosacademy.model.Plataforma;

public class PlataformaFilmeDto {

	private Long id;
	private String nome;
	private String url;
	private String descricao;
	
	public PlataformaFilmeDto(Plataforma plataforma) {
		this.id = plataforma.getId();
		this.nome = plataforma.getNome();
		this.url = plataforma.getUrl();
		this.descricao = plataforma.getDescricao();
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
