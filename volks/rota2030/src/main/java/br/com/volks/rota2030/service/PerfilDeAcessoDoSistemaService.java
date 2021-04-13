package br.com.volks.rota2030.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaNotFoundException;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaSearchException;
import br.com.volks.rota2030.model.PerfilDeAcessoDoSistema;
import br.com.volks.rota2030.repository.PerfilDeAcessoDoSistemaRepository;

@Service
public class PerfilDeAcessoDoSistemaService {
	
	@Autowired
	private PerfilDeAcessoDoSistemaRepository repository;

	public PerfilDeAcessoDoSistema buscaPorDescricao(String perfil) {
		try {
			Optional<PerfilDeAcessoDoSistema> perfilOp=  repository.findByDescricao(perfil);
			if(perfilOp.isPresent()) {
				return perfilOp.get();
			}
			throw new PerfilDeAcessoDoSistemaNotFoundException(perfil);
		}catch (Exception e) {
			throw new PerfilDeAcessoDoSistemaSearchException(e);
		}
	}

	
	
	
}
