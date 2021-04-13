package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioNotDeletedException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(UsuarioNotDeletedException.class);
	
	public UsuarioNotDeletedException(Exception e) {
		super("Usuario nao foi excluido. Motivo: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Usuario nao foi excluido. Motivo: " + ExceptionUtils.getFullStackTrace(e));
	}
}
