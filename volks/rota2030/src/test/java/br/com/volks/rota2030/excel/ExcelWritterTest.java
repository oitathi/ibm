package br.com.volks.rota2030.excel;

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
import br.com.volks.rota2030.exceptions.ExcelException;
import br.com.volks.rota2030.model.Relatorio;
import br.com.volks.rota2030.repository.RelatorioRepository;

@RunWith(MockitoJUnitRunner.class)
public class ExcelWritterTest {
	
	@InjectMocks
	private ExcelWritter ew;
	
	@Mock
	private RelatorioRepository relatorioRepository;
	
	@Test
	public void deveRecuperarConteudoDadoUmToken() {
		Mockito.when(relatorioRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Relatorio(1L)));
     	ew.criaArquivo(1l);
		verify(relatorioRepository, times(1)).findById(1L);
	}
	
	@Test(expected = ExcelException.class)
	public void deveLancarExcecaoAoNaoEncontrarUmToken() {
		Mockito.when(relatorioRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
     	ew.criaArquivo(1l);
	}
	
	@Test(expected = ExcelException.class)
	public void deveLancarExcecaoAoBuscarToken() {
		Mockito.when(relatorioRepository.findById(Mockito.anyLong())).thenThrow(NullPointerException.class);
     	ew.criaArquivo(1l);
	}

}
