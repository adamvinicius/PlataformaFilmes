package br.com.chronosacademy.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.chronosacademy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.chronosacademy.config.validacao.ErroDeFormularioDto;
import br.com.chronosacademy.config.validacao.FilmesValidacao;
import br.com.chronosacademy.controller.dto.FilmeDto;
import br.com.chronosacademy.controller.dto.FilmePlataformaDto;
import br.com.chronosacademy.controller.form.FilmeForm;
import br.com.chronosacademy.model.Categoria;
import br.com.chronosacademy.model.Filme;
import br.com.chronosacademy.model.FilmeCategoria;
import br.com.chronosacademy.model.FilmePlataforma;
import br.com.chronosacademy.model.Plataforma;

@RestController
@RequestMapping("/filmes")
public class FilmesController<FilmeCateogiraRepository> {

	@Autowired
	private FilmeRepository filmeRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private PlataformaRepository plataformaRepository;
	@Autowired
	private FilmePlataformaRepository filmePlataformaRepository;
	@Autowired
	private FilmeCategoriaRepository filmeCategoriaRepository;
	
	private ErroDeFormularioDto erroDeFormularioDto;
	private List<ErroDeFormularioDto> errosDeFormularioDto;
	
	
	@GetMapping
	public ResponseEntity<List<FilmePlataformaDto>> listaFilmes(@RequestParam(required = false) String nome){
		List<Filme> filmes;
		List<FilmePlataformaDto> filmesPlataformaDto = new ArrayList<>();
		if (nome == null) {
			filmes = filmeRepository.findAll();
		}else {
			filmes = filmeRepository.findByNome(nome);
		}
		for(Filme filme : filmes) {
			filmesPlataformaDto.add(new FilmePlataformaDto(filme));
		}
		
		return ResponseEntity.ok(filmesPlataformaDto);
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarPlataforma(@RequestBody @Valid FilmeForm form, UriComponentsBuilder uriBuilder){
		errosDeFormularioDto = new ArrayList<>();
		Filme filme = form.converter();
		FilmesValidacao filmesValidacao = new FilmesValidacao();
		errosDeFormularioDto = filmesValidacao.validaFormFilmes(form, filmeRepository, plataformaRepository, categoriaRepository);
		
		if (errosDeFormularioDto.size() != 0) {
			return ResponseEntity.badRequest().body(errosDeFormularioDto);
		}
		filme = filmeRepository.save(filme);
		List<FilmePlataforma> listFilmePlataforma = cadastraFilmePlataforma(form, filme);
		List<FilmeCategoria> listFilmeCategoria = cadastraFilmeCategoria(form, filme);
		
		filme.setFilmeplataforma(listFilmePlataforma);
		filme.setFilmecategoria(listFilmeCategoria);
		filmeRepository.save(filme);
		
		URI uri = uriBuilder.path("/plataformas/{id}").buildAndExpand(filme.getId()).toUri();
		return ResponseEntity.created(uri).body(new FilmeDto(filme));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid FilmeForm form){
		Optional<Filme> optional = filmeRepository.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		FilmesValidacao filmesValidacao = new FilmesValidacao();
		errosDeFormularioDto = filmesValidacao.validaFormFilmesAlteracao(id, form, filmeRepository, plataformaRepository, categoriaRepository);
		if (errosDeFormularioDto.size() != 0) {
			return ResponseEntity.badRequest().body(errosDeFormularioDto);
		}
		Filme filme = form.atualizar(id, filmeRepository, categoriaRepository, plataformaRepository, filmePlataformaRepository, filmeCategoriaRepository);
		return ResponseEntity.ok(new FilmeDto(filme));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Filme> optional = filmeRepository.findById(id);
		if (optional.isPresent()) {
			for (FilmePlataforma filmePlataforma : optional.get().getFilmeplataforma()) {
				filmePlataformaRepository.delete(filmePlataforma);
			}
			
			for (FilmeCategoria filmeCategoria : optional.get().getFilmecategoria()) {
				filmeCategoriaRepository.delete(filmeCategoria);
			}
			filmeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	public List<FilmeCategoria> cadastraFilmeCategoria(FilmeForm form, Filme filme) {
		List<Categoria> categorias = form.getCategorias();
		List<FilmeCategoria> listFilmeCategoria = new ArrayList<>();
		for (Categoria categoria : categorias) {
			categoria = categoriaRepository.findByTipo(categoria.getTipo()).get(0);
			FilmeCategoria filmeCategoria = new FilmeCategoria(filme, categoria);
			listFilmeCategoria.add(filmeCategoriaRepository.save(filmeCategoria));
		}
		return listFilmeCategoria;
	}

	public List<FilmePlataforma> cadastraFilmePlataforma(FilmeForm form, Filme filme) {
		List<Plataforma> plataformas = form.getPlataformas();
		List<FilmePlataforma> listFilmePlataforma= new ArrayList<>();
		
		for (Plataforma plataforma : plataformas) {
			plataforma = plataformaRepository.findByNome(plataforma.getNome()).get(0);
			FilmePlataforma filmePlataforma = new FilmePlataforma(filme, plataforma);
			filmePlataforma = filmePlataformaRepository.save(filmePlataforma);
		}
		return listFilmePlataforma;
	}

	

	
	
	
}
