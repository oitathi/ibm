package br.com.volks.rota2030.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.volks.rota2030.exceptions.TipoNotFoundException;
import br.com.volks.rota2030.model.ItemDeSegurancaTipo;
import br.com.volks.rota2030.repository.ItemDeSegurancaTipoRepository;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(MockitoJUnitRunner.class)
public class TipoServiceTest {
	
	@InjectMocks
	private ItemDeSegurancaTipoService service;
	
	@Mock
	private ItemDeSegurancaTipoRepository repository;
	
	private ItemDeSegurancaTipo mockaTipo() {
		return new ItemDeSegurancaTipo(1L, "Automovel");
	}
	
	@Order(1)
	@Test
	public void deveListarTodosTipos() {
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(mockaTipo()));
		
		List<ItemDeSegurancaTipo> actual = service.listarTodos();
		assertEquals(1, actual.size());
	}
	
	@Order(2)
	@Test
	public void deveBuscarPorDescricao() {
		Mockito.when(repository.findByDescricao(Mockito.anyString())).thenReturn(Arrays.asList(mockaTipo()));
		
		ItemDeSegurancaTipo actual = service.buscaPorDescricao("Automovel");
		assertEquals("Automovel", actual.getDescricao());
	}
	
	@Order(3)
	@Test(expected = TipoNotFoundException.class)
	public void deveLancarExcecaoAoBuscarPorDescricaoNaoExistente() {
		Mockito.when(repository.findByDescricao(Mockito.anyString())).thenReturn(new ArrayList<>());
		
		service.buscaPorDescricao("Trator");
	}

}
