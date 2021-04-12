package br.com.volks.rota2030.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.volks.rota2030.excel.ExcelWritter;
import br.com.volks.rota2030.message.RabbitProducer;
import br.com.volks.rota2030.model.Relatorio;
import br.com.volks.rota2030.repository.RelatorioRepository;

@RunWith(MockitoJUnitRunner.class)
public class RabbitServiceTest {
	
	@InjectMocks
	private RabbitService service;
	
	@Mock
	private RabbitProducer rabbit;
	
	@Mock
	private RelatorioRepository repository;
	
	@Mock
	private ExcelWritter excelWritter;
	
	@Test
	public void deveMandarParaOConsumidor() {
		Mockito.doNothing().when(rabbit).producer(Mockito.anyLong());
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Relatorio()));
		Mockito.when(repository.save(Mockito.<Relatorio>any())).thenReturn(new Relatorio());
		assertTrue(service.sendToConsumerSuccess(1L));
 
	}
	
	@Test
	public void deveReceberMensagem() {
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Relatorio()));
		Mockito.when(repository.save(Mockito.<Relatorio>any())).thenReturn(new Relatorio());
		Mockito.doNothing().when(excelWritter).criaArquivo(Mockito.anyLong());
		service.receiveFromConsumer(1L);
		verify(excelWritter, times(1)).criaArquivo(1L);
 
	}
	
	

}
