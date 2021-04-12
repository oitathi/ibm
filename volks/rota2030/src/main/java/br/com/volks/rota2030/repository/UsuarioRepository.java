package br.com.volks.rota2030.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.volks.rota2030.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByLogin(String login);
}
