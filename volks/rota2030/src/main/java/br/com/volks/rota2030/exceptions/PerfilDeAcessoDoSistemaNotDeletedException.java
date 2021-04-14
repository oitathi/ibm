package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerfilDeAcessoDoSistemaNotDeletedException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(PerfilDeAcessoDoSistemaNotDeletedException.class);
	
	public PerfilDeAcessoDoSistemaNotDeletedException(Exception e) {
		super("Perfil nao foi excluido. Motivo: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Perfil nao foi excluido. Motivo: " + ExceptionUtils.getFullStackTrace(e));
	}

}
