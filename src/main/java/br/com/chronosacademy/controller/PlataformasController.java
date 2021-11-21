package br.com.chronosacademy.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
import br.com.chronosacademy.controller.dto.PlataformaDto;
import br.com.chronosacademy.controller.form.AtualizacaoPlataformaForm;
import br.com.chronosacademy.controller.form.PlataformaForm;
import br.com.chronosacademy.model.Plataforma;
import br.com.chronosacademy.repository.PlataformaRepository;

@RestController
@RequestMapping("/plataformas")
public class PlataformasController {

	@Autowired
	private PlataformaRepository plataformaRepository;

	@GetMapping
	public ResponseEntity<List<PlataformaDto>> lista(@RequestParam(required = false) String nome) {
		List<Plataforma> plataformas;
		List<PlataformaDto> plataformasDto = new ArrayList<>();
		if (nome == null) {
			plataformas = plataformaRepository.findAll();
		} else {
			plataformas = plataformaRepository.findByNome(nome);
		}
		for (Plataforma plataforma : plataformas) {
			plataformasDto.add(new PlataformaDto(plataforma));
		}
		
		
		
		return ResponseEntity.ok(plataformasDto);

	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarPlataforma(@RequestBody @Valid PlataformaForm form, UriComponentsBuilder uriBuilder){
		Plataforma plataforma = form.converter();
		
		if (plataformaRepository.findByNome(plataforma.getNome()).size() != 0) {
			ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto("nome", "A plataforma: "+plataforma.getNome()+" já está cadastrada!");
			List<ErroDeFormularioDto> errosDeFormularioDto = new ArrayList<>();
			errosDeFormularioDto.add(erroDeFormularioDto);
			return ResponseEntity.badRequest().body(errosDeFormularioDto);
		}
		plataformaRepository.save(plataforma);
		
		URI uri = uriBuilder.path("/plataformas/{id}").buildAndExpand(plataforma.getId()).toUri();
		return ResponseEntity.created(uri).body(new PlataformaDto(plataforma));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPlataformaForm form) {
		Optional<Plataforma> optional = plataformaRepository.findById(id);
		if (optional.isPresent()) {
			Plataforma plataforma = form.atualizar(id, plataformaRepository);
			return ResponseEntity.ok(new PlataformaDto(plataforma));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Plataforma> optional = plataformaRepository.findById(id);
		if (optional.isPresent()) {
			plataformaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	
}
