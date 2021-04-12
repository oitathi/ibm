package br.com.volks.rota2030.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.exceptions.UsuarioNotFoundException;
import br.com.volks.rota2030.model.Usuario;
import br.com.volks.rota2030.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOp = repository.findByLogin(login);
		
		if(usuarioOp.isPresent()) {
			return usuarioOp.get();
		}
		
		throw new UsuarioNotFoundException(login);
	}

}
