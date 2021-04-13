package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioDoSistemaNotSalvedException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(UsuarioDoSistemaNotSalvedException.class);
	
	public UsuarioDoSistemaNotSalvedException(Exception e) {
		super("Usuario nao foi salvo. Motivo: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Usuario nao foi salvo. Motivo: " + ExceptionUtils.getFullStackTrace(e));
	}

}
