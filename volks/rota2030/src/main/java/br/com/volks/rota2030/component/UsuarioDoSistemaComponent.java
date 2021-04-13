package br.com.volks.rota2030.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.volks.rota2030.form.UsuarioDoSistemaForm;
import br.com.volks.rota2030.model.PerfilDeAcessoDoSistema;
import br.com.volks.rota2030.model.UsuarioDoSistema;
import br.com.volks.rota2030.service.PerfilDeAcessoDoSistemaService;
import br.com.volks.rota2030.service.UsuarioDoSistemaService;

@Component
public class UsuarioDoSistemaComponent {
	
		
	@Autowired
	private PerfilDeAcessoDoSistemaService perfilService;
	
	
	public UsuarioDoSistema toEntity(UsuarioDoSistemaForm form) {
		PerfilDeAcessoDoSistema perfil = perfilService.buscaPorDescricao(form.getPerfil());
		
		return new UsuarioDoSistema(form.getLogin(), form.getNome(), form.getEmail(), perfil);
	}
	

}
