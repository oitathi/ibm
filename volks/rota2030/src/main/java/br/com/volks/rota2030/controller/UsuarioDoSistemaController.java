package br.com.volks.rota2030.controller;

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

import br.com.volks.rota2030.dto.UsuarioDoSistemaDto;
import br.com.volks.rota2030.form.UsuarioDoSistemaForm;
import br.com.volks.rota2030.service.UsuarioDoSistemaService;

@RestController 
@RequestMapping(path = "usuario")
public class UsuarioDoSistemaController {
	
	@Autowired
	private UsuarioDoSistemaService service;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/lista", produces = "application/json")
	public Page<UsuarioDoSistemaDto> buscaDinamica(
			 @RequestParam (required = false) Map<String,String> filtro,
			 @RequestParam(defaultValue = "0") int pageNo, 
             @RequestParam(defaultValue = "10") int pageSize,
             @RequestParam(defaultValue = "id") String sortBy) {
		
		return service.buscaDinamica(filtro, pageNo, pageSize, sortBy);
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/lista/{id}", produces = "application/json")
	public UsuarioDoSistemaDto buscaPorId(@PathVariable Long id) {
		return service.buscaPorId(id);
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/novo", consumes = "application/json", produces = "application/json")
	public UsuarioDoSistemaDto salva(@RequestBody UsuarioDoSistemaForm novo) {
		return service.salva(novo);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(path ="/edita",consumes = "application/json", produces = "application/json")
	public UsuarioDoSistemaDto edita(@RequestBody UsuarioDoSistemaDto editado)  {
		return service.edita(editado);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@DeleteMapping(path = "/deleta/{id}/{user}",produces = "application/json")
	public boolean deleta(@PathVariable Long id, @PathVariable String user) {
		return service.deleta(id, user);
	}
	
	
}
