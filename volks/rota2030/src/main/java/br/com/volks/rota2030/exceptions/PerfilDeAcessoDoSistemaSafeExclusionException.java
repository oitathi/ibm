package br.com.volks.rota2030.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerfilDeAcessoDoSistemaSafeExclusionException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(PerfilDeAcessoDoSistemaSafeExclusionException.class);
	
	public PerfilDeAcessoDoSistemaSafeExclusionException() {
		super("O perfil não pode ser excluido pois exitem usuarios com esse perfil" );
		logger.error("O perfil não pode ser excluido pois exitem usuarios com esse perfil");
	}
}
