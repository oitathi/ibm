package br.com.volks.rota2030.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.sun.xml.bind.v2.model.core.ID;

import br.com.volks.rota2030.model.ItemDeSegurancaGrupo;

public interface ItemDeSegurancaGrupoRepository extends JpaRepository<ItemDeSegurancaGrupo, Long> {
	
	List<ItemDeSegurancaGrupo>findByDescricao(String descricao);

}
