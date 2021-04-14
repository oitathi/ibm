package br.com.volks.rota2030.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public static String toString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
        return dateFormat.format(date);  
    }
	
	public static Date toDate(String dateInString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 return formatter.parse(dateInString);
	}

}
