package br.com.volks.rota2030.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItemDeSeguracaNotUpdatedException extends RuntimeException {
	
	private Logger logger = LogManager.getLogger(ItemDeSeguracaNotUpdatedException.class);
	
	public ItemDeSeguracaNotUpdatedException(Exception e) {
		super("Item de seguranca nao editado: " + ExceptionUtils.getFullStackTrace(e));
		logger.error("Item de seguranca nao editado: " + ExceptionUtils.getFullStackTrace(e));
	}

}
