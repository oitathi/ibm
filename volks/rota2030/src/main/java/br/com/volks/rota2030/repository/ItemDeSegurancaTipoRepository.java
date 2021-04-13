package br.com.volks.rota2030.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.volks.rota2030.model.ItemDeSegurancaTipo;

public interface ItemDeSegurancaTipoRepository extends JpaRepository<ItemDeSegurancaTipo, Long> {

	List<ItemDeSegurancaTipo> findByDescricao(String descricao);

}

