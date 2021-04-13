package br.com.volks.rota2030.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.volks.rota2030.dto.ParametroDeTecnologiaDto;
import br.com.volks.rota2030.form.ParametroDeTecnologiaForm;
import br.com.volks.rota2030.service.ParametroDeTecnologiaService;

@RestController 
@RequestMapping(path = "parametro_de_tecnologia")
public class ParametroDeTecnologiaController {

	@Autowired
	private ParametroDeTecnologiaService service;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/lista", produces = "application/json")
	public Page<ParametroDeTecnologiaDto> buscaDinamica(
			 @RequestParam (required = false) Map<String,String> filtro,
			 @RequestParam(defaultValue = "0") int pageNo, 
             @RequestParam(defaultValue = "10") int pageSize,
             @RequestParam(defaultValue = "id") String sortBy) {
		
		return service.buscaDinamica(filtro, pageNo, pageSize, sortBy);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/lista/{id}", produces = "application/json")
	public ParametroDeTecnologiaDto buscaPorId(@PathVariable Long id) {
		return service.buscaPorId(id);
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/novo", consumes = "application/json", produces = "application/json")
	public ParametroDeTecnologiaDto salva(@RequestBody ParametroDeTecnologiaForm novoParametro) {
		return service.salva(novoParametro);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(path ="/edita/{id}",consumes = "application/json", produces = "application/json")
	public ParametroDeTecnologiaDto edita(@RequestBody ParametroDeTecnologiaForm parametroEditado)  {
		return service.edita(parametroEditado);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@DeleteMapping(path = "/deleta/{id}/{user}",produces = "application/json")
	public boolean deleta(@PathVariable Long id, @PathVariable String user) {
		return service.deleta(id, user);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping(path= "/download-relatorio", produces = "application/json")
	public long donwloadRelatorio(@RequestBody List<ParametroDeTecnologiaDto> parametrosDto) {
		return service.criaTokenDeAcompanhamento(parametrosDto);
	}
	
}
