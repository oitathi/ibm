package br.com.volks.rota2030.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.dto.ParametroDeTecnologiaDto;
import br.com.volks.rota2030.form.ParametroDeTecnologiaForm;

@Service
public class ParametroDeTecnologiaService {

	public Page<ParametroDeTecnologiaDto> buscaDinamica(Map<String, String> filtro, int pageNo, int pageSize, String sortBy) {
		List<ParametroDeTecnologiaDto> listDto = new ArrayList<ParametroDeTecnologiaDto>();
		return null;
	}

	public ParametroDeTecnologiaDto buscaPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ParametroDeTecnologiaDto salva(ParametroDeTecnologiaForm novoParametro) {
		// TODO Auto-generated method stub
		return null;
	}

	public ParametroDeTecnologiaDto edita(ParametroDeTecnologiaForm parametroEditado) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleta(Long id, String user) {
		// TODO Auto-generated method stub
		return false;
	}

	public long criaTokenDeAcompanhamento(List<ParametroDeTecnologiaDto> parametrosDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
