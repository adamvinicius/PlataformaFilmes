package br.com.chronosacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronosacademy.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
