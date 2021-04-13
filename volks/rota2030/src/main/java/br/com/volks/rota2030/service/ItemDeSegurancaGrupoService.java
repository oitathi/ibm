package br.com.volks.rota2030.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.exceptions.GrupoNotFoundException;
import br.com.volks.rota2030.model.ItemDeSegurancaGrupo;
import br.com.volks.rota2030.repository.ItemDeSegurancaGrupoRepository;

@Service 
public class ItemDeSegurancaGrupoService {
	
	@Autowired
	private ItemDeSegurancaGrupoRepository repository;
	
	public List<ItemDeSegurancaGrupo> listarTodos(){
		return repository.findAll();
	}
	
	public ItemDeSegurancaGrupo buscaPorDescricao(String descricao) {
		List<ItemDeSegurancaGrupo> grupos = repository.findByDescricao(descricao);
		if(!grupos.isEmpty()) {
			return grupos.get(0);
		}
		throw new GrupoNotFoundException(descricao);
	}

}
