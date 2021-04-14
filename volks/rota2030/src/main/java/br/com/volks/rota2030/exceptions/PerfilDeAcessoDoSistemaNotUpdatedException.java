package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerfilDeAcessoDoSistemaNotUpdatedException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(PerfilDeAcessoDoSistemaNotUpdatedException.class);
	
	public PerfilDeAcessoDoSistemaNotUpdatedException(Exception e) {
		super("Perfil nao editado: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Perfil nao editado: " + ExceptionUtils.getFullStackTrace(e));
	}

}
