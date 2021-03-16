package br.com.chronosacademy.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.chronosacademy.modelo.FilmePlataforma;
import br.com.chronosacademy.modelo.Plataforma;

public class PlataformaDto {

	private Long id;
	private String nome;
	private String url;
	private String descricao;
	private List<FilmeDto> filmes;
	
	public PlataformaDto() {
		
	}
	
	public PlataformaDto(Plataforma plataforma) {
		this.id = plataforma.getId();
		this.nome = plataforma.getNome();
		this.url = plataforma.getUrl();
		this.descricao = plataforma.getDescricao();
		List<FilmePlataforma> filmesPlataformas = plataforma.getFilmeplataforma();
		List<FilmeDto> filmesDto = new ArrayList<>();
		for (FilmePlataforma filmePlataforma : filmesPlataformas) {
			
			filmesDto.add(new FilmeDto(filmePlataforma.getFilme()));
			
		}
		this.filmes = filmesDto;
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
	public List<FilmeDto> getFilmes() {
		return filmes;
	}
	public void setFilmesDto(List<FilmeDto> filmes) {
		this.filmes = filmes;
	}
	
	
	
	
}
