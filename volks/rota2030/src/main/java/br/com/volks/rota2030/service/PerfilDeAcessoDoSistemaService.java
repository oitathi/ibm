package br.com.volks.rota2030.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.component.PerfilDeAcessoDoSistemaComponent;
import br.com.volks.rota2030.dto.PerfilDeAcessoDoSistemaDto;
import br.com.volks.rota2030.enums.AcoesEnum;
import br.com.volks.rota2030.enums.TabelasEnum;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaNotDeletedException;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaNotFoundException;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaNotUpdatedException;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaSafeExclusionException;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoDoSistemaSearchException;
import br.com.volks.rota2030.exceptions.PerfilDeAcessoNotSalvedException;
import br.com.volks.rota2030.form.PerfilDeAcessoDoSistemaForm;
import br.com.volks.rota2030.model.Logs;
import br.com.volks.rota2030.model.PerfilDeAcessoDoSistema;
import br.com.volks.rota2030.model.TelaDoSistema;
import br.com.volks.rota2030.model.UsuarioDoSistema;
import br.com.volks.rota2030.repository.LogsRepository;
import br.com.volks.rota2030.repository.PerfilDeAcessoDoSistemaRepository;

@Service
public class PerfilDeAcessoDoSistemaService {
	
	@Autowired
	private PerfilDeAcessoDoSistemaRepository repository;
	
	@Autowired 
	private PerfilDeAcessoDoSistemaComponent component;
	
	@Autowired
	private LogsRepository logsRepository;

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

	public PerfilDeAcessoDoSistemaDto buscaPorDescricaoFullLoad(String descricao) {
		try {
			Optional<PerfilDeAcessoDoSistema> perfilOp=  repository.buscaPerfilETelasEUsuariosPorDescricao(descricao);
			if(perfilOp.isPresent()) {
				return perfilOp.get().toDto();
			}
			throw new PerfilDeAcessoDoSistemaNotFoundException(descricao);
		}catch (Exception e) {
			throw new PerfilDeAcessoDoSistemaSearchException(e);
		}
	}
	
	public Page<PerfilDeAcessoDoSistemaDto> buscaTodosPerfisComTelasEUsuarios( int pageNo, int pageSize, String sortBy){
		try {
			List<PerfilDeAcessoDoSistema> entities = repository.buscaTodosPerfisETelasEUsuarios();
			
			List<PerfilDeAcessoDoSistemaDto> dtos = new ArrayList<>();
			entities.forEach(en -> dtos.add(en.toDto()));
			
			Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<PerfilDeAcessoDoSistemaDto> resultPaged = new PageImpl<PerfilDeAcessoDoSistemaDto>(dtos, page, dtos.size());
			
			return resultPaged;
		}catch(Exception e) {
			throw new PerfilDeAcessoDoSistemaSearchException(e);
		}
	}


	public PerfilDeAcessoDoSistemaDto salva(PerfilDeAcessoDoSistemaForm novo) {
		try {
			PerfilDeAcessoDoSistema perfil =  component.toEntity(novo);
			perfil = repository.save(perfil);
			
			Logs log = new Logs(novo.getUsuarioLogado(), AcoesEnum.CRIAR, TabelasEnum.PERFIL_DE_ACESSO, perfil.getId(), perfil.toString(), new Date());
			logsRepository.save(log);
						
			return perfil.toDto();	
			
		}catch (Exception e) {
			throw new PerfilDeAcessoNotSalvedException(e);
		}
	}

	public PerfilDeAcessoDoSistemaDto edita(PerfilDeAcessoDoSistemaDto editado) {
		try {
			PerfilDeAcessoDoSistema perfil =  component.toEntity(editado);
			perfil = repository.save(perfil);
			
			Logs log = new Logs(editado.getUsuarioLogado(), AcoesEnum.EDITAR, TabelasEnum.PERFIL_DE_ACESSO, perfil.getId(), perfil.toString(), new Date());
			logsRepository.save(log);
						
			return editado;	
			
		}catch (Exception e) {
			throw new PerfilDeAcessoDoSistemaNotUpdatedException(e);
		}
	}

	public boolean deleta(Long id, String user) {
		try {
			Optional<PerfilDeAcessoDoSistema> perfilOp  = repository.buscaPerfilEUsuariosPorId(id);
			if(perfilOp.isPresent()) {
				PerfilDeAcessoDoSistema perfil = perfilOp.get();
				Set<UsuarioDoSistema> usuariosComEssePerfil = perfil.getUsuarios();
				if(usuariosComEssePerfil.isEmpty()) {
					repository.deleteById(id);
				}
				throw new PerfilDeAcessoDoSistemaSafeExclusionException();
			}
			throw new PerfilDeAcessoDoSistemaNotFoundException(String.valueOf(id));
		}catch(Exception e) {
			throw new PerfilDeAcessoDoSistemaNotDeletedException(e);
		}
	}

	

	
	
	
}
