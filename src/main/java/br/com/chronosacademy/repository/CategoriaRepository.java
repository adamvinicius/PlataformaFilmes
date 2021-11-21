package br.com.chronosacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronosacademy.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	List<Categoria> findByTipo(String tipo);
}
