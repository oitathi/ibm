package br.com.volks.rota2030.component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.volks.rota2030.dto.PerfilDeAcessoDoSistemaDto;
import br.com.volks.rota2030.form.PerfilDeAcessoDoSistemaForm;
import br.com.volks.rota2030.model.PerfilDeAcessoDoSistema;
import br.com.volks.rota2030.model.TelaDoSistema;
import br.com.volks.rota2030.model.UsuarioDoSistema;
import br.com.volks.rota2030.service.TelasDoSistemaService;
import br.com.volks.rota2030.service.UsuarioDoSistemaService;

@Component
public class PerfilDeAcessoDoSistemaComponent {
	
	@Autowired
	private TelasDoSistemaService telaService;
	
	@Autowired
	private UsuarioDoSistemaService usuarioService;

	public PerfilDeAcessoDoSistema toEntity(PerfilDeAcessoDoSistemaForm form) {
		return new PerfilDeAcessoDoSistema(form.getDescricao(), getUsuariosFromLogin(form.getUsuarios()), getTelasFromDescricao(form.getTelas()));
	}

	public PerfilDeAcessoDoSistema toEntity(PerfilDeAcessoDoSistemaDto dto) {
		return new PerfilDeAcessoDoSistema(dto.getId(), dto.getDescricao(), getTelasFromDescricao(dto.getTelas()));
	}
	
	private Set<TelaDoSistema> getTelasFromDescricao(List<String> telas){
		Set<TelaDoSistema> telasEntities = new HashSet<TelaDoSistema>();
				
		for(String tela : telas) {
			telasEntities.add(telaService.buscaPorDescricao(tela));
		}
		return telasEntities;
	}
	
	
	private Set<UsuarioDoSistema> getUsuariosFromLogin(List<String> logins){
		
		Set<UsuarioDoSistema> usuariosEntities = new HashSet<UsuarioDoSistema>();
		
		for(String login : logins) {
			usuariosEntities.add(usuarioService.buscaPorLogin(login));
		}
		return usuariosEntities;
	}

}
