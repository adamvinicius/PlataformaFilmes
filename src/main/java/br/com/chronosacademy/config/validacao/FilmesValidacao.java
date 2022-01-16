package br.com.chronosacademy.config.validacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.chronosacademy.controller.form.FilmeForm;
import br.com.chronosacademy.model.Categoria;
import br.com.chronosacademy.model.Filme;
import br.com.chronosacademy.model.Plataforma;
import br.com.chronosacademy.repository.CategoriaRepository;
import br.com.chronosacademy.repository.FilmeRepository;
import br.com.chronosacademy.repository.PlataformaRepository;

public class FilmesValidacao {

	public List<ErroDeFormularioDto> validaFormFilmes(FilmeForm form, FilmeRepository filmeRepository, PlataformaRepository plataformaRepository, CategoriaRepository categoriaRepository) {
		List<ErroDeFormularioDto> errosDeFormularioDto = new ArrayList<>();
		Filme filme = form.converter();

		errosDeFormularioDto.addAll(validaFilme(filme, filmeRepository));
		
		errosDeFormularioDto.addAll(validaPlataformas(form, plataformaRepository));
		errosDeFormularioDto.addAll(validaCategoria(form, categoriaRepository));
		
		return errosDeFormularioDto;
	}

	public List<ErroDeFormularioDto> validaFormFilmesAlteracao(Long id, FilmeForm form, FilmeRepository filmeRepository, PlataformaRepository plataformaRepository, CategoriaRepository categoriaRepository) {
		List<ErroDeFormularioDto> errosDeFormularioDto = new ArrayList<>();
		Filme filme = form.converter();

		Optional<Filme> filme2 = filmeRepository.findById(id);

		if (!filme.getNome().equals(filme2.get().getNome())){
			errosDeFormularioDto.addAll(validaFilme(filme, filmeRepository));
		}


		errosDeFormularioDto.addAll(validaPlataformas(form, plataformaRepository));
		errosDeFormularioDto.addAll(validaCategoria(form, categoriaRepository));

		return errosDeFormularioDto;
	}


		
	
	public List<ErroDeFormularioDto> validaCategoria(FilmeForm form, CategoriaRepository categoriaRepository) {
		int count = 0;
		List<Categoria> categorias = form.getCategorias();
		List<ErroDeFormularioDto> listErrosDeFormularioDto = new ArrayList<>();
		for (Categoria categoria : categorias) {
			if (categoriaRepository.findByTipo(categoria.getTipo()).size() == 0) {
				ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto("filme.categorias["+count+"].tipo", "A categoria: "+categoria.getTipo()+" não está cadastrada!");
				listErrosDeFormularioDto.add(erroDeFormularioDto);
			}
			count++;
		}
		
		if (count == 0) {
			ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto("filme.categorias[]", "Lista de categorias é obrigatória");
			listErrosDeFormularioDto.add(erroDeFormularioDto);
		}
		return listErrosDeFormularioDto;
	}

	public List<ErroDeFormularioDto> validaPlataformas(FilmeForm form, PlataformaRepository plataformaRepository) {
		List<Plataforma> plataformas = form.getPlataformas();
		List<ErroDeFormularioDto> errosDeFormularioDto = new ArrayList<>();
		int count = 0;
		for (Plataforma plataforma : plataformas) {
			if (plataformaRepository.findByNome(plataforma.getNome()).size() == 0) {
				ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto("filme.plataformas["+count+"].nome", "A plataforma: "+plataforma.getNome()+" não está cadastrada!");
				errosDeFormularioDto.add(erroDeFormularioDto);
			}
			count ++;
		}
		if (count == 0) {
			ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto("filme.plataformas[]", "Lista de plataformas é obrigatória");
			errosDeFormularioDto.add(erroDeFormularioDto);
		}
		return errosDeFormularioDto;
	}

	public List<ErroDeFormularioDto> validaFilme(Filme filme, FilmeRepository filmeRepository) {
		List<ErroDeFormularioDto> errosDeFormularioDto = new ArrayList<>();
		if (filmeRepository.findByNome(filme.getNome()).size() != 0) {
			ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto("filme.nome", "O filme: "+filme.getNome()+" já foi cadastrado!");
			errosDeFormularioDto.add(erroDeFormularioDto);
		}
		return errosDeFormularioDto;
	}
}
