package br.com.volks.rota2030.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TelaDoSistemaNotFoundException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(TelaDoSistemaNotFoundException.class);
	
	public TelaDoSistemaNotFoundException(String tela) {
		super("Tela nao encontrado: " + tela);
		logger.error("Tela nao encontrado: " + tela);
	}

}
