package br.com.volks.rota2030.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioNotFoundException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(UsuarioNotFoundException.class);
	
	public UsuarioNotFoundException(String login) {
		logger.error("Dados de autenticacao invalidos" + " Login:" + login );
		throw new UsernameNotFoundException("Dados de autenticacao invalidos" + " Login:" + login);
	}
}
