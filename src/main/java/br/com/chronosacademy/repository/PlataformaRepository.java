package br.com.chronosacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronosacademy.model.Plataforma;

public interface PlataformaRepository extends JpaRepository<Plataforma, Long>{
	List<Plataforma> findByNome(String nome);
}
