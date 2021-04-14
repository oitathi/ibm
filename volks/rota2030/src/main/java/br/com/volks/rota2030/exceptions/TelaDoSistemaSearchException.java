package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TelaDoSistemaSearchException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(TelaDoSistemaSearchException.class);
	
	public TelaDoSistemaSearchException(Exception e) {
		super("Erro na busca de telas. Motivo: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Erro na busca de telas. Motivo: " + ExceptionUtils.getFullStackTrace(e));
	}
}
