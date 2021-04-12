package br.com.volks.rota2030.message;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;

import br.com.volks.rota2030.exceptions.RabbitException;
import br.com.volks.rota2030.service.RabbitService;

@RunWith(MockitoJUnitRunner.class)
public class RabbitConsumerTest {
	
	@InjectMocks
	private RabbitConsumer consumer;
	
	@Mock
	private RabbitService service;
	
	@Test
	public void deveConsumirUmMensagem() {
		Mockito.doNothing().when(service).receiveFromConsumer(Mockito.anyLong());
		consumer.consume(1L);
		verify(service, times(1)).receiveFromConsumer(1L);
	}
	
	@Test(expected = RabbitException.class)
	public void deveLancarExcecaoAoConsumirMensagem() {
		doThrow(new NullPointerException()).when(service).receiveFromConsumer(Mockito.anyLong());
		consumer.consume(1L);

	}

}
