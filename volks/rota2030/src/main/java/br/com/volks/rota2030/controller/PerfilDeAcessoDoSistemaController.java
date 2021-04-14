package br.com.volks.rota2030.controller;

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

import br.com.volks.rota2030.dto.PerfilDeAcessoDoSistemaDto;
import br.com.volks.rota2030.form.PerfilDeAcessoDoSistemaForm;
import br.com.volks.rota2030.service.PerfilDeAcessoDoSistemaService;

@RestController 
@RequestMapping(path = "perfil-de-acesso")
public class PerfilDeAcessoDoSistemaController {
	
	@Autowired
	private PerfilDeAcessoDoSistemaService service;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/lista", produces = "application/json")
	public Page<PerfilDeAcessoDoSistemaDto> buscaTodos(	@RequestParam(defaultValue = "0") int pageNo, 
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
		return service.buscaTodosPerfisComTelasEUsuarios(pageNo, pageSize, sortBy);
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/lista/{descricao}", produces = "application/json")
	public PerfilDeAcessoDoSistemaDto buscaPorDescricao(@PathVariable String descricao) {
		return service.buscaPorDescricaoFullLoad(descricao);
		
	}
		
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/novo", consumes = "application/json", produces = "application/json")
	public PerfilDeAcessoDoSistemaDto salva(@RequestBody PerfilDeAcessoDoSistemaForm novo) {
		return service.salva(novo);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(path ="/edita",consumes = "application/json", produces = "application/json")
	public PerfilDeAcessoDoSistemaDto edita(@RequestBody PerfilDeAcessoDoSistemaDto editado)  {
		return service.edita(editado);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@DeleteMapping(path = "/deleta/{id}/{user}",produces = "application/json")
	public boolean deleta(@PathVariable Long id, @PathVariable String user) {
		return service.deleta(id, user);
	}
	

	
	
}
