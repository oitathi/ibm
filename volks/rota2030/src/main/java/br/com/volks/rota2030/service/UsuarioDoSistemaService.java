package br.com.volks.rota2030.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.component.UsuarioDoSistemaComponent;
import br.com.volks.rota2030.dto.UsuarioDoSistemaDto;
import br.com.volks.rota2030.enums.AcoesEnum;
import br.com.volks.rota2030.enums.TabelasEnum;
import br.com.volks.rota2030.exceptions.UsuarioDoSistemaNotFoundException;
import br.com.volks.rota2030.exceptions.UsuarioDoSistemaNotSalvedException;
import br.com.volks.rota2030.exceptions.UsuarioDoSistemaNotUpdatedException;
import br.com.volks.rota2030.exceptions.UsuarioDoSistemaSearchException;
import br.com.volks.rota2030.exceptions.UsuarioNotDeletedException;
import br.com.volks.rota2030.form.UsuarioDoSistemaForm;
import br.com.volks.rota2030.model.Logs;
import br.com.volks.rota2030.model.UsuarioDoSistema;
import br.com.volks.rota2030.repository.LogsRepository;
import br.com.volks.rota2030.repository.UsuarioDoSistemaRepository;
import br.com.volks.rota2030.util.DateOperations;

@Service
public class UsuarioDoSistemaService {
	
	@Autowired
	private UsuarioDoSistemaRepository usuarioRepository;
	
	@Autowired
	private UsuarioDoSistemaComponent usuarioComponent;
	
	@Autowired
	private LogsRepository logsRepository;

	public Page<UsuarioDoSistemaDto> buscaDinamica(Map<String, String> filtro, int pageNo, int pageSize, String sortBy) {
		try {
			List<UsuarioDoSistemaDto> listDto = new ArrayList<>();
			
			Page<UsuarioDoSistema> entitiesList = usuarioRepository.buscaPorFiltros(filtro, pageNo, pageSize, sortBy);
			entitiesList.forEach(entity -> listDto.add(entity.toDto()));
			
			Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<UsuarioDoSistemaDto> resultPaged = new PageImpl<UsuarioDoSistemaDto>(listDto, page, listDto.size());
					
			return resultPaged; 
		}catch (Exception e) {
			throw new UsuarioDoSistemaSearchException(e);
		}
	}

	public UsuarioDoSistemaDto buscaPorId(Long id) {
		try {
			  UsuarioDoSistema usuario = usuarioRepository.findByIdFullLoad(id);
			  return usuario.toDto();
			}catch (Exception e) {
				throw new UsuarioDoSistemaSearchException(e);
			}
	}
	
	public UsuarioDoSistema buscaPorLogin(String login) {
		try {
			Optional<UsuarioDoSistema> usuarioOp = usuarioRepository.findByLogin(login);
			if(usuarioOp.isPresent()) {
				return usuarioOp.get();
			}
			throw new UsuarioDoSistemaNotFoundException(login);
		}catch (Exception e) {
			throw new UsuarioDoSistemaSearchException(e);
		}
	}

	public UsuarioDoSistemaDto salva(UsuarioDoSistemaForm form) {
		try {
			UsuarioDoSistema usuario = usuarioComponent.toEntity(form);
			usuario = usuarioRepository.save(usuario);
			
			Logs log = new Logs(form.getUsuarioLogado(), AcoesEnum.CRIAR, TabelasEnum.USUARIO, usuario.getId(), usuario.toString(), new Date());
			logsRepository.save(log);
			
			return usuario.toDto();
		}catch(Exception e) {
			throw new UsuarioDoSistemaNotSalvedException(e);
		}
	}

	public UsuarioDoSistemaDto edita(UsuarioDoSistemaDto dto) {
		try {
			
			usuarioRepository.update(dto.getId(), dto.getNome(), dto.getEmail(), dto.isAcessoExpirado(),  dto.isAcessoAtivo(), DateOperations.toDate(dto.getDataUltimoAcesso()), dto.getPerfil());
			Logs log = new Logs(dto.getUsuarioLogado(), AcoesEnum.EDITAR, TabelasEnum.USUARIO, dto.getId(), dto.toString(), new Date());
			logsRepository.save(log);
			
			return dto;
			
		}catch(Exception e) {
			throw new UsuarioDoSistemaNotUpdatedException(e);
		}
	}

	public boolean deleta(Long id, String user) {
		try {
			usuarioRepository.deleteById(id);
			Logs log = new Logs(user, AcoesEnum.EXCLUIR, TabelasEnum.USUARIO,id, "", new Date());
			return true;
		}catch(Exception e) {
			throw new UsuarioNotDeletedException(e);
		}
	}

	
	
}
