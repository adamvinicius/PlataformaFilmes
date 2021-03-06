package br.com.chronosacademy.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.chronosacademy.modelo.Plataforma;
import br.com.chronosacademy.repository.PlataformaRepository;

public class AtualizacaoPlataformaForm {

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



	public Plataforma atualizar(Long id, PlataformaRepository plataformaRepository) {
		Plataforma plataforma = plataformaRepository.getOne(id);
		
		plataforma.setNome(nome);
		plataforma.setDescricao(descricao);
		plataforma.setUrl(url);
		return plataforma;
		
	}
	
}
