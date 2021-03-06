package br.com.chronosacademy.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.chronosacademy.modelo.Categoria;
import br.com.chronosacademy.modelo.Filme;
import br.com.chronosacademy.modelo.FilmeCategoria;

public class FilmeDto {
	private Long id;
	private String nome;
	private String descricao;
	private double duracao;
	private List<Categoria> categorias;
		
	public FilmeDto(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.descricao = filme.getDescricao();
		this.duracao = filme.getDuracao();
		
		List<FilmeCategoria> filmesCategorias = filme.getFilmecategoria();
		List<Categoria> categorias = new ArrayList<>();
		for (FilmeCategoria filmeCategoria : filmesCategorias) {
			categorias.add(filmeCategoria.getCategoria());
		}
		this.categorias = categorias;
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
	
	
	
}
