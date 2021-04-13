package br.com.volks.rota2030.repository;

import java.util.Map;

import org.springframework.data.domain.Page;

import br.com.volks.rota2030.model.UsuarioDoSistema;

public interface UsuarioDoSistemaRepositoryCustom {

	Page<UsuarioDoSistema> buscaPorFiltros(Map<String, String> filtro, int pageNo, int pageSize, String sortBy);
	
	UsuarioDoSistema findByIdFullLoad(long id);

}
