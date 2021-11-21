package br.com.chronosacademy.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.chronosacademy.model.Categoria;
import br.com.chronosacademy.model.Filme;
import br.com.chronosacademy.model.FilmeCategoria;
import br.com.chronosacademy.model.FilmePlataforma;


public class FilmePlataformaDto {

	private long id;
	private String nome;
	private String descricao;
	private double duracao;
	private List<Categoria> categorias;
	private List<PlataformaFilmeDto> plataforma;
	
	public FilmePlataformaDto(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.descricao = filme.getDescricao();
		this.duracao = filme.getDuracao();
		this.categorias = new ArrayList<>();
		for(FilmeCategoria filmeCategoria : filme.getFilmecategoria()) {
			categorias.add(filmeCategoria.getCategoria());
		}
		this.plataforma = new ArrayList<>();
		for(FilmePlataforma filmePlataforma : filme.getFilmeplataforma()) {
			plataforma.add(new PlataformaFilmeDto(filmePlataforma.getPlataforma()));
		}
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getDuracao() {
		return duracao;
	}
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public List<PlataformaFilmeDto> getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(List<PlataformaFilmeDto> plataforma) {
		this.plataforma = plataforma;
	}
	
	
}
