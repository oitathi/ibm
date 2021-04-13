package br.com.volks.rota2030.model;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TipoTest {
	
	@Test
	public void loadClass() {
		ItemDeSegurancaTipo tipo = new ItemDeSegurancaTipo();
		assertNull(tipo.getId());
		assertNull(tipo.getDescricao());
		assertNull(tipo.getItensDeSeguranca());
	}

}
