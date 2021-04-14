package br.com.volks.rota2030.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.dto.PerfilDeAcessoDoSistemaDto;
import br.com.volks.rota2030.dto.UsuarioDoSistemaDto;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaNotFoundException;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaSearchException;
import br.com.volks.rota2030.form.PerfilDeAcessoDoSistemaForm;
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

	public Page<PerfilDeAcessoDoSistemaDto> buscaDinamica(Map<String, String> filtro, int pageNo, int pageSize,
			String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public PerfilDeAcessoDoSistemaDto buscaPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public PerfilDeAcessoDoSistemaDto salva(PerfilDeAcessoDoSistemaForm novo) {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioDoSistemaDto edita(PerfilDeAcessoDoSistemaDto editado) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleta(Long id, String user) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}
