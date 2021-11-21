package br.com.chronosacademy.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plataforma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String url;
	
	private String descricao;
	@OneToMany(mappedBy = "plataforma")
	private List<FilmePlataforma> filmeplataforma = new ArrayList<>();

	public Plataforma() {
	}

	public Plataforma(String nome, String url, String descricao) {
		this.nome = nome;
		this.url = url;
		this.descricao = descricao;
		
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
		Plataforma other = (Plataforma) obj;
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

	public List<FilmePlataforma> getFilmeplataforma() {
		return filmeplataforma;
	}

	public void setFilmeplataforma(List<FilmePlataforma> filmeplataforma) {
		this.filmeplataforma = filmeplataforma;
	}

}
