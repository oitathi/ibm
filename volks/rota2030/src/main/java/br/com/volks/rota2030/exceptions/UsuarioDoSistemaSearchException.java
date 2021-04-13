package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioDoSistemaSearchException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(UsuarioDoSistemaSearchException.class);
	
	public UsuarioDoSistemaSearchException(Exception e) {
		super("Erro ao buscar usuario: " + ExceptionUtils.getStackTrace(e));
		logger.error("Erro ao buscar usuario: " + ExceptionUtils.getStackTrace(e));
	}
	
	

}
