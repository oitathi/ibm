package br.com.volks.rota2030.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.component.ItemDeSegurancaComponent;
import br.com.volks.rota2030.dto.ItemDeSegurancaDto;
import br.com.volks.rota2030.enums.AcoesEnum;
import br.com.volks.rota2030.enums.StatusRelatorioEnum;
import br.com.volks.rota2030.enums.TabelasEnum;
import br.com.volks.rota2030.exceptions.ItemDeSeguracaUpdatedException;
import br.com.volks.rota2030.exceptions.ItemDeSegurancaNotDeletedException;
import br.com.volks.rota2030.exceptions.ItemDeSegurancaNotSalvedException;
import br.com.volks.rota2030.exceptions.ItemDeSegurancaSearchException;
import br.com.volks.rota2030.form.ItemDeSegurancaForm;
import br.com.volks.rota2030.model.ItemDeSeguranca;
import br.com.volks.rota2030.model.Logs;
import br.com.volks.rota2030.model.Relatorio;
import br.com.volks.rota2030.repository.ItemDeSegurancaRepository;
import br.com.volks.rota2030.repository.LogsRepository;
import br.com.volks.rota2030.repository.RelatorioRepository;
import br.com.volks.rota2030.util.StringOperations;

@Service 
public class ItemDeSegurancaService {
	
	@Autowired
	private ItemDeSegurancaComponent itemSegurancaComponent;
	
	@Autowired
	private ItemDeSegurancaRepository itemSegurancarepository;
	
	@Autowired
	private RelatorioRepository relatorioRepository;
	
	@Autowired
	private LogsRepository logsRepository;
	
	public Page<ItemDeSegurancaDto> buscaDinamica(Map<String, String> filtro,  int pageNo, int pageSize, String sortBy){
		try {
			List<ItemDeSegurancaDto> listDto = new ArrayList<ItemDeSegurancaDto>();
			
			Page<ItemDeSeguranca> entitiesList = itemSegurancarepository.buscaPorFiltros(filtro, pageNo, pageSize, sortBy);
			entitiesList.forEach(entity -> listDto.add(entity.toDto()));
			
			Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<ItemDeSegurancaDto> resultPaged = new PageImpl<ItemDeSegurancaDto>(listDto, page, listDto.size());
					
			return resultPaged; 
			
		}catch (Exception e) {
			throw new ItemDeSegurancaSearchException(e);
		}
	}
	
	public ItemDeSegurancaDto buscaPorId(Long id) {
		try {
		  ItemDeSeguranca iseg = itemSegurancarepository.findByIdFullLoad(id);
		  return iseg.toDto();
		}catch (Exception e) {
			throw new ItemDeSegurancaSearchException(e);
		}
		
	}

	
	public ItemDeSegurancaDto salva(ItemDeSegurancaForm form) {
		try {
			ItemDeSeguranca itemSeg =  itemSegurancaComponent.toEntity(form);
			itemSeg = itemSegurancarepository.save(itemSeg);
			
			Logs log = new Logs(form.getUsuario(), AcoesEnum.CRIAR, TabelasEnum.ITEM_DE_SEGURANCA, itemSeg.getId(), itemSeg.toString(), new Date());
			logsRepository.save(log);
						
			return itemSeg.toDto();	
			
		}catch (Exception e) {
			throw new ItemDeSegurancaNotSalvedException(e);
		}
	}
	
		
	public ItemDeSegurancaDto edita(ItemDeSegurancaDto dto) {
		try {
				itemSegurancarepository.update(dto.getId(),dto.getDescricao(),dto.getNorma(),dto.isObrigatorio(), dto.getGrupo(), dto.getTipo());
				Logs log = new Logs(dto.getUsuario(), AcoesEnum.EDITAR, TabelasEnum.ITEM_DE_SEGURANCA, dto.getId(), dto.toString(), new Date());
				return dto;
				
		}catch (Exception e) {
			throw new ItemDeSeguracaUpdatedException(e);
		}
	}
	
	public boolean deleta( Long id, String user) {
		try {
			itemSegurancarepository.deleteById(id);
			Logs log = new Logs(user, AcoesEnum.EXCLUIR, TabelasEnum.ITEM_DE_SEGURANCA,id, "", new Date());
			return true;
		}catch(Exception e) {
			throw new ItemDeSegurancaNotDeletedException(e);
		}
	}
	
	public long criaTokenDeAcompanhamento(List<ItemDeSegurancaDto> itens) {
		Relatorio relatorio = new Relatorio(StatusRelatorioEnum.CRIADO, StringOperations.listToCsv(itens), new Date());
		relatorio = relatorioRepository.save(relatorio);
		
		return relatorio.getId(); 
	}
	

}
