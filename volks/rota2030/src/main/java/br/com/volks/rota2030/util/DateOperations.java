package br.com.volks.rota2030.util;

import java.util.Calendar;
import java.util.Date;

public class DateOperations {
	
	public static boolean isUltimoAcessoHaMenosDe90Dias(Date dataDoUltimoAcesso) {
		Calendar ultimoAcesso = Calendar.getInstance();
		ultimoAcesso.setTime(dataDoUltimoAcesso);
		
		Calendar noventaDiasAtras = Calendar.getInstance();
		noventaDiasAtras.setTime(new Date());
		noventaDiasAtras.add(Calendar.DAY_OF_MONTH, -90);
		
		if(ultimoAcesso.before(noventaDiasAtras)) {
			return false;
		}
		
		return true;
	}

}
