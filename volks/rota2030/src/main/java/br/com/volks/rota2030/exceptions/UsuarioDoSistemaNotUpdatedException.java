package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioDoSistemaNotUpdatedException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(UsuarioDoSistemaNotUpdatedException.class);
	
	public UsuarioDoSistemaNotUpdatedException(Exception e) {
		super("Usuario nao editado: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Usuario nao editado: " + ExceptionUtils.getFullStackTrace(e));
	}
}
