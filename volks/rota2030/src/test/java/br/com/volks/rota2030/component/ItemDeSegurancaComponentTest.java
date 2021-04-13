package br.com.volks.rota2030.component;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.volks.rota2030.dto.ItemDeSegurancaDto;
import br.com.volks.rota2030.form.ItemDeSegurancaForm;
import br.com.volks.rota2030.model.ItemDeSegurancaGrupo;
import br.com.volks.rota2030.model.ItemDeSeguranca;
import br.com.volks.rota2030.model.ItemDeSegurancaTipo;
import br.com.volks.rota2030.service.ItemDeSegurancaGrupoService;
import br.com.volks.rota2030.service.ItemDeSegurancaTipoService;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(MockitoJUnitRunner.class)
public class ItemDeSegurancaComponentTest {
	
	@InjectMocks
	private ItemDeSegurancaComponent component;
	
	@Mock
	private ItemDeSegurancaGrupoService grupoService;
	
	@Mock
	private ItemDeSegurancaTipoService tipoService;
	
	
	private ItemDeSegurancaForm mockaRequestDto() {
		return new ItemDeSegurancaForm("item de seguranca x", "norma x", "Grupo A" , "Automovel", false, "tester");
	}
	
	private ItemDeSegurancaDto mockaResponseDto() {
		return new ItemDeSegurancaDto(1L, "item de seguranca x", "norma x", "Grupo A ", "Automovel", false);
	}
	
	private ItemDeSegurancaGrupo mockaGrupo() {
		return new ItemDeSegurancaGrupo(1L, "Grupo A");
	}
	
	private ItemDeSegurancaTipo mockaTipo() {
		return new ItemDeSegurancaTipo(1L, "Automovel");
	}
	
	@Test
	public void deveConverterResquestDtoParaEntity() {
		Mockito.when(grupoService.buscaPorDescricao(Mockito.<String>any())).thenReturn(mockaGrupo());
		Mockito.when(tipoService.buscaPorDescricao(Mockito.<String>any())).thenReturn(mockaTipo());
		
		ItemDeSeguranca actual = component.toEntity(mockaRequestDto());
		
		assertEquals("item de seguranca x", actual.getDescricao());
		
	}
	
	@Test
	public void deveConverterResponseDtoToEntity() {
		Mockito.when(grupoService.buscaPorDescricao(Mockito.<String>any())).thenReturn(mockaGrupo());
		Mockito.when(tipoService.buscaPorDescricao(Mockito.<String>any())).thenReturn(mockaTipo());
		
		ItemDeSeguranca actual = component.toEntity(mockaResponseDto());
		
		assertEquals("item de seguranca x", actual.getDescricao());
	}
	
	
}
