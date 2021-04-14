package br.com.volks.rota2030.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.volks.rota2030.model.PerfilDeAcessoDoSistema;

public interface PerfilDeAcessoDoSistemaRepository extends JpaRepository<PerfilDeAcessoDoSistema, Long> { 

	@Query("SELECT p FROM PerfilDeAcessoDoSistema p JOIN p.telas t ON p.id = t.id WHERE p.descricao = ?1")
	Optional<PerfilDeAcessoDoSistema> findByDescricao(String descricao);
}
