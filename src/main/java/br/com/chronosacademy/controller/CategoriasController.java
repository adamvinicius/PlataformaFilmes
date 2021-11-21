package br.com.chronosacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronosacademy.model.Categoria;
import br.com.chronosacademy.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> lista() {
		List<Categoria> categorias;
		categorias = categoriaRepository.findAll();
				
		return ResponseEntity.ok(categorias);

	}
}
