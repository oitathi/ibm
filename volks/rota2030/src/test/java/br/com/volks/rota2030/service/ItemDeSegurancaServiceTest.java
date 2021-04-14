package br.com.volks.rota2030.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.google.gson.Gson;

import br.com.volks.rota2030.component.ItemDeSegurancaComponent;
import br.com.volks.rota2030.dto.ItemDeSegurancaDto;
import br.com.volks.rota2030.enums.AcoesEnum;
import br.com.volks.rota2030.enums.TabelasEnum;
import br.com.volks.rota2030.exceptions.ItemDeSeguracaNotUpdatedException;
import br.com.volks.rota2030.exceptions.ItemDeSegurancaNotDeletedException;
import br.com.volks.rota2030.exceptions.ItemDeSegurancaNotSalvedException;
import br.com.volks.rota2030.exceptions.ItemDeSegurancaSearchException;
import br.com.volks.rota2030.form.ItemDeSegurancaForm;
import br.com.volks.rota2030.model.ItemDeSegurancaGrupo;
import br.com.volks.rota2030.model.ItemDeSeguranca;
import br.com.volks.rota2030.model.Logs;
import br.com.volks.rota2030.model.Relatorio;
import br.com.volks.rota2030.model.ItemDeSegurancaTipo;
import br.com.volks.rota2030.repository.ItemDeSegurancaRepository;
import br.com.volks.rota2030.repository.LogsRepository;
import br.com.volks.rota2030.repository.RelatorioRepository;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(MockitoJUnitRunner.class)
public class ItemDeSegurancaServiceTest {

	@InjectMocks
	private ItemDeSegurancaService itemDeSegurancaService;
	
	@Mock
	private ItemDeSegurancaComponent itemSegurancaComponent;
	
	@Mock
	private ItemDeSegurancaRepository itemSegurancarepository;
	
	@Mock
	private RelatorioRepository relatorioRepository;
	
	@Mock
	private LogsRepository logsRepository;
		
	
	
	private ItemDeSegurancaForm mockaRequestDto() {
		return new ItemDeSegurancaForm("item de seguranaca x", "norma x", "Grupo A" , "Automovel", false, "tester");
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
	
	private ItemDeSeguranca mockaItemDeSeguranca() {
		return new ItemDeSeguranca(1L, "item de Seguranca x" , "norma x", false, mockaGrupo(), mockaTipo());
	}
	
	private Logs mockaLogs() {
		return  new Logs("tester", AcoesEnum.CRIAR, TabelasEnum.ITEM_DE_SEGURANCA, 1L, "FOO", new Date());

	}
	
	@Order(1)
	@Test
	public void deveSalvarUmItem() {
		Mockito.when(itemSegurancaComponent.toEntity(Mockito.<ItemDeSegurancaForm>any())).thenReturn(mockaItemDeSeguranca());
		Mockito.when(itemSegurancarepository.save(Mockito.<ItemDeSeguranca>any())).thenReturn(mockaItemDeSeguranca());
		Mockito.when(logsRepository.save(Mockito.<Logs>any())).thenReturn(mockaLogs());
		
		ItemDeSegurancaDto actual = itemDeSegurancaService.salva(mockaRequestDto());
		assertEquals(1L, actual.getId());
	}
	
	@Order(2)
	@Test(expected = ItemDeSegurancaNotSalvedException.class)
	public void deveLancarExcecaoAoSalvarUmItem() {
		Mockito.when(itemSegurancaComponent.toEntity(Mockito.<ItemDeSegurancaForm>any())).thenThrow(NullPointerException.class);
		itemDeSegurancaService.salva(mockaRequestDto());
	}
	
	@Order(3)
	@Test
	public void deveFiltrarItem() {
		Map<String, String> filtro = new HashMap<String, String>();
		
		List<ItemDeSeguranca> resultado = Arrays.asList(mockaItemDeSeguranca());
		Pageable page = PageRequest.of(0, 1, Sort.by("id"));
		Page<ItemDeSeguranca> resultPaged = new PageImpl<ItemDeSeguranca>(resultado, page, resultado.size());
		
		Mockito.when(itemSegurancarepository.buscaPorFiltros(
				Mockito.anyMap(),
				Mockito.anyInt(),
				Mockito.anyInt(),
				Mockito.anyString()))
		.thenReturn(resultPaged);
		
		Page<ItemDeSegurancaDto> actual = itemDeSegurancaService.buscaDinamica(filtro, 1, 1, "id");
		assertEquals(1, actual.getNumberOfElements());
	}
	
	@Order(4)
	@Test(expected = ItemDeSegurancaSearchException.class)
	public void deveLancarExcecaoAoFiltrarItem() {
		Map<String, String> filtro = new HashMap<String, String>();
		Mockito.when(itemSegurancarepository.buscaPorFiltros(
				Mockito.anyMap(),
				Mockito.anyInt(),
				Mockito.anyInt(),
				Mockito.anyString()))
		.thenThrow(NullPointerException.class);
		
		itemDeSegurancaService.buscaDinamica(filtro, 0, 1, "id");
	}
	
	@Order(5)
	@Test
	public void deveBuscarPorId() {
		Mockito.when(itemSegurancarepository.findByIdFullLoad(1L)).thenReturn(mockaItemDeSeguranca());
		ItemDeSegurancaDto actual = itemDeSegurancaService.buscaPorId(1L);
		assertEquals("Automovel", actual.getTipo());
	}
	
	@Order(6)
	@Test(expected = ItemDeSegurancaSearchException.class)
	public void deveLancarExcecaoAoBuscarPorId() {
		Mockito.when(itemSegurancarepository.findByIdFullLoad(1L)).thenThrow(NullPointerException.class);
		itemDeSegurancaService.buscaPorId(1L);
	}
	
	@Order(7)
	@Test
	public void deveEditarUmItem() {
		Mockito.when(itemSegurancarepository.update(
				Mockito.anyLong(),
				Mockito.<String>any(),
				Mockito.<String>any() , 
				Mockito.anyBoolean() , 
				Mockito.<String>any(),
				Mockito.<String>any()))
		.thenReturn(1);
		
		ItemDeSegurancaDto dto = mockaResponseDto();
		ItemDeSegurancaDto actual = itemDeSegurancaService.edita(dto);
		
		assertEquals("Automovel", actual.getTipo());
	}
	
	@Order(8)
	@Test(expected = ItemDeSeguracaNotUpdatedException.class)
	public void deveLancarExcecaoAoEditarUmItem() {
		Mockito.when(itemSegurancarepository.update(
				Mockito.anyLong(),
				Mockito.<String>any(),
				Mockito.<String>any() , 
				Mockito.anyBoolean() , 
				Mockito.<String>any(),
				Mockito.<String>any()))
		.thenThrow(NullPointerException.class);
		
		itemDeSegurancaService.edita(mockaResponseDto());
	}
	
	@Order(9)
	@Test
	public void deveDeletarUmItem() {
		Mockito.doNothing().when(itemSegurancarepository).deleteById(Mockito.anyLong());
		boolean actual = itemDeSegurancaService.deleta(1L, "tester");
		
		assertTrue(actual);
	}
	
	@Order(10)
	@Test(expected = ItemDeSegurancaNotDeletedException.class)
	public void deveLancarExcecaoAoDeletarUmItem() {
		Mockito.doThrow(new NullPointerException()).when(itemSegurancarepository).deleteById(Mockito.anyLong());
		itemDeSegurancaService.deleta(1L, "tester");
		
	}
	
	@Order(11)
	@Test
	public void deveCriarTokenDeAcompanhamanto() {
		Mockito.when(relatorioRepository.save(Mockito.<Relatorio>any())).thenReturn(new Relatorio(1L));
		long actual = itemDeSegurancaService.criaTokenDeAcompanhamento(Arrays.asList(mockaResponseDto()));
		assertTrue(actual > 0);
	}
	
}
