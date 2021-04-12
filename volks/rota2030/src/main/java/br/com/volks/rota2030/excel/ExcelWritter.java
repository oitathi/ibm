package br.com.volks.rota2030.excel;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.volks.rota2030.exceptions.ExcelException;
import br.com.volks.rota2030.model.Relatorio;
import br.com.volks.rota2030.repository.RelatorioRepository;

@Component
public class ExcelWritter {
	
	@Autowired
	private RelatorioRepository relatorioRepository;
	 
		
	private String recuperaConteudo(long token)  {
		try {
			Optional<Relatorio> relatorioOp = relatorioRepository.findById(token);
			if(relatorioOp.isPresent()) {
				Relatorio relatorio = relatorioOp.get();
				return relatorio.getConteudo();
			}
			throw new ExcelException(token);
		}catch (Exception e) {
			throw new ExcelException(e);
		}
	}
	
	public void criaArquivo(long token) {
		String conteudo = recuperaConteudo(token);
	}

}
