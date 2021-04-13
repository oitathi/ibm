package br.com.volks.rota2030.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.exceptions.TipoNotFoundException;
import br.com.volks.rota2030.model.ItemDeSegurancaTipo;
import br.com.volks.rota2030.repository.ItemDeSegurancaTipoRepository;

@Service 
public class ItemDeSegurancaTipoService {
	
	@Autowired
	private ItemDeSegurancaTipoRepository repository;
	
	public List<ItemDeSegurancaTipo> listarTodos(){
		return repository.findAll();
	}
	
	public ItemDeSegurancaTipo buscaPorDescricao(String descricao) {
		List<ItemDeSegurancaTipo> tipos = repository.findByDescricao(descricao);
		if(!tipos.isEmpty()) {
			return tipos.get(0);
		}
		throw new TipoNotFoundException(descricao);
	}

}
