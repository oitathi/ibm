package br.com.volks.rota2030.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.volks.rota2030.dto.ItemDeSegurancaDto;
import br.com.volks.rota2030.form.ItemDeSegurancaForm;
import br.com.volks.rota2030.model.ItemDeSegurancaGrupo;
import br.com.volks.rota2030.model.ItemDeSeguranca;
import br.com.volks.rota2030.model.ItemDeSegurancaTipo;
import br.com.volks.rota2030.service.ItemDeSegurancaGrupoService;
import br.com.volks.rota2030.service.ItemDeSegurancaTipoService;

@Component
public class ItemDeSegurancaComponent {
	
	@Autowired
	private ItemDeSegurancaGrupoService grupoService;

	@Autowired
	private ItemDeSegurancaTipoService tipoService;
	
	
	public ItemDeSeguranca toEntity(ItemDeSegurancaForm form) {
		ItemDeSegurancaGrupo grupoEntity = grupoService.buscaPorDescricao(form.getGrupo());
		ItemDeSegurancaTipo tipoEntity = tipoService.buscaPorDescricao(form.getTipo());

		return new ItemDeSeguranca(form.getDescricao(), form.getNorma(), form.isObrigatorio(), grupoEntity, tipoEntity);
	}
	
	public ItemDeSeguranca toEntity(ItemDeSegurancaDto dto) {
		ItemDeSegurancaGrupo grupoEntity = grupoService.buscaPorDescricao(dto.getGrupo());
		ItemDeSegurancaTipo tipoEntity = tipoService.buscaPorDescricao(dto.getTipo());

		return new ItemDeSeguranca(dto.getId(),dto.getDescricao(), dto.getNorma(), dto.isObrigatorio(), grupoEntity, tipoEntity);
	}

}
