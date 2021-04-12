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
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RunWith(MockitoJUnitRunner.class)
public class RabbitProducerTest {
	
	@InjectMocks
	private RabbitProducer producer;
	
	@Mock
	private RabbitTemplate template;
	
	@Test
	public void deveProduzirUmaMensagem() {
		Mockito.doNothing().when(template).convertAndSend(Mockito.anyString(), Mockito.anyString(), Mockito.anyLong());
		producer.producer(1L);
		verify(template, times(1)).convertAndSend(null, null, 1L);
	}
	
	@Test(expected = AmqpRejectAndDontRequeueException.class)
	public void deveLancarExcecaoAoProduzirUmaMensagem() {
		doThrow(new NullPointerException()).when(template).convertAndSend(Mockito.anyString(), Mockito.anyString(), Mockito.anyLong());
		producer.producer(1L);
	}

}
