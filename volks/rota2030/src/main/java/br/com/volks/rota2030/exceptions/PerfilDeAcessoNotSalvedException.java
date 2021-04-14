package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerfilDeAcessoNotSalvedException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(PerfilDeAcessoNotSalvedException.class);
	
	public PerfilDeAcessoNotSalvedException(Exception e) {
		super("Perfil nao foi salvo. Motivo: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Perfil nao foi salvo. Motivo: " + ExceptionUtils.getFullStackTrace(e));
	}


}
