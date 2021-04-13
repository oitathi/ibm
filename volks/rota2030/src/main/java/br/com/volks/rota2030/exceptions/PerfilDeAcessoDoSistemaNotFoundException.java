package br.com.volks.rota2030.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerfilDeAcessoDoSistemaNotFoundException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(PerfilDeAcessoDoSistemaNotFoundException.class);
	
	public PerfilDeAcessoDoSistemaNotFoundException(String perfil) {
		super("Perfil de acesso não encontrado: " + perfil);
		logger.error("Perfil de acesso não encontrado: " + perfil);
	}

}
