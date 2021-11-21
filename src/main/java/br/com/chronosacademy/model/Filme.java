package br.com.chronosacademy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private double duracao;
	@OneToMany(mappedBy = "filme")
	private List<FilmePlataforma> filmeplataforma = new ArrayList<>();
	@OneToMany(mappedBy = "filme")
	private List<FilmeCategoria> filmecategoria = new ArrayList<>();

	public Filme() {

	}

	public Filme(String nome, String descricao, double duracao) {
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public double isDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	
	public double getDuracao() {
		return this.duracao;
	}

	public List<FilmePlataforma> getFilmeplataforma() {
		return filmeplataforma;
	}

	public void setFilmeplataforma(List<FilmePlataforma> filmeplataforma) {
		this.filmeplataforma = filmeplataforma;
	}

	public List<FilmeCategoria> getFilmecategoria() {
		return filmecategoria;
	}

	public void setFilmecategoria(List<FilmeCategoria> filmecategoria) {
		this.filmecategoria = filmecategoria;
	}

}
