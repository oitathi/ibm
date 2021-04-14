package br.com.volks.rota2030.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioDoSistemaNotFoundException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(UsuarioDoSistemaNotFoundException.class);
	
	public UsuarioDoSistemaNotFoundException(String login) {
		super("Usuario nao encontrado: " + login);
		logger.error("Usuario nao encontrado: " + login);
	}
}
