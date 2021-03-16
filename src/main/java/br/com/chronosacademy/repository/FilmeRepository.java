package br.com.chronosacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronosacademy.modelo.Filme;


public interface FilmeRepository extends JpaRepository<Filme, Long> {
	List<Filme> findByNome(String nome);
}
