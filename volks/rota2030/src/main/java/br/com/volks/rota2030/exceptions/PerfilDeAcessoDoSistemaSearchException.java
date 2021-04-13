package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerfilDeAcessoDoSistemaSearchException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(PerfilDeAcessoDoSistemaSearchException.class);
	
	public PerfilDeAcessoDoSistemaSearchException(Exception e) {
		super("Erro na busca dinamica de perfil de acesso. Motivo: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Erro na busca dinamica de perfil de acesso. Motivo:" + ExceptionUtils.getFullStackTrace(e));
	}
}
