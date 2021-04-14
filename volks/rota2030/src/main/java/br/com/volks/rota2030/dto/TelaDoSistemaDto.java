package br.com.volks.rota2030.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.volks.rota2030.model.TelaDoSistema;

public class TelaDoSistemaDto {

	private List<String> telas;

	public TelaDoSistemaDto(List<TelaDoSistema> telasEntities) {
		this.telas = new ArrayList<String>();
		telasEntities.forEach(t -> telas.add(t.getDescricao()));		
	}
	
	
}
