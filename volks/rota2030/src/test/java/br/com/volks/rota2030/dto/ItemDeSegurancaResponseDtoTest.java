package br.com.volks.rota2030.dto;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ItemDeSegurancaResponseDtoTest {
	
	@Test
	public void loadClass() {
		ItemDeSegurancaDto dto = new ItemDeSegurancaDto();
		ItemDeSegurancaDto dto2 = new ItemDeSegurancaDto(1L,"Item X", "Norma Alfa", "Grupo C", "Caminhonete",  false, "tester");

		assertNotNull(dto2.getDescricao());
		
	}

}
