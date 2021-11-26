package br.com.chronosacademy.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.chronosacademy.repository.*;
import org.hibernate.validator.constraints.Length;

import br.com.chronosacademy.model.Categoria;
import br.com.chronosacademy.model.Filme;
import br.com.chronosacademy.model.FilmeCategoria;
import br.com.chronosacademy.model.FilmePlataforma;
import br.com.chronosacademy.model.Plataforma;


public class FilmeForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull
	private double duracao;
	List<Plataforma> plataformas;
	List<Categoria> categorias;
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
	public List<Plataforma> getPlataformas() {
		return plataformas;
	}
	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Filme converter() {
		return new Filme(nome, descricao, duracao);
	}
	
	public Filme atualizar(Long id, FilmeRepository filmeRepository,
						   CategoriaRepository categoriaRespository, PlataformaRepository plataformaRepository,
						   FilmePlataformaRepository filmeplataformaRepository, FilmeCategoriaRepository filmeCategoriaRepository) {
		Filme filme = filmeRepository.getOne(id);
		
		filme.setNome(nome);
		filme.setDescricao(descricao);
		filme.setDuracao(duracao);
		
		filme.setFilmecategoria(
			atualizaFilmeCategoria(categoriaRespository, filmeCategoriaRepository, filme)
		);
		filme.setFilmeplataforma(
				atualizaFilmePlataforma(plataformaRepository, filmeplataformaRepository, filme)
		);
		return filme;
	}
	public List<FilmeCategoria> atualizaFilmeCategoria(CategoriaRepository categoriaRespository,
													   FilmeCategoriaRepository filmeCategoriaRepository, Filme filme) {
		List<FilmeCategoria> filmesCategoria = filme.getFilmecategoria();
		for (FilmeCategoria filmeCategoria : filmesCategoria) {
			filmeCategoriaRepository.delete(filmeCategoria);
		}
		filmesCategoria = new ArrayList<>();
		for (Categoria categoria : getCategorias()) {
			FilmeCategoria filmeCategoria = new FilmeCategoria(filme, 
					categoriaRespository.findByTipo(categoria.getTipo()).get(0)	
			);
			filmesCategoria.add(
					filmeCategoriaRepository.save(filmeCategoria)
			);
			
		}
		return filmesCategoria;
	}
	
	public List<FilmePlataforma> atualizaFilmePlataforma(PlataformaRepository plataformaRespository,
			FilmePlataformaRepository filmePlataformaRepository, Filme filme) {
		List<FilmePlataforma> filmesPlataforma = filme.getFilmeplataforma();
		for (FilmePlataforma filmePlataforma : filmesPlataforma) {
			filmePlataformaRepository.delete(filmePlataforma);
		}
		filmesPlataforma = new ArrayList<>();
		for (Plataforma plataforma : getPlataformas()) {
			FilmePlataforma filmePlataforma = new FilmePlataforma(filme, 
					plataformaRespository.findByNome(plataforma.getNome()).get(0)	
			);
			filmesPlataforma.add(
					filmePlataformaRepository.save(filmePlataforma)
			);
			
		}
		return filmesPlataforma;
	}

}
