package br.com.chronosacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronosacademy.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

}
