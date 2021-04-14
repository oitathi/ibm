package br.com.volks.rota2030.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.volks.rota2030.model.TelaDoSistema;

public interface TelaDoSistemaRepository extends JpaRepository<TelaDoSistema, Long>,PagingAndSortingRepository<TelaDoSistema, Long>{

	Optional<TelaDoSistema> findByDescricao(String descricao);
}
