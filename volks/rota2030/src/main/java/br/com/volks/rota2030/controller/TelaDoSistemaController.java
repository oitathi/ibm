package br.com.volks.rota2030.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.volks.rota2030.dto.TelaDoSistemaDto;
import br.com.volks.rota2030.service.TelasDoSistemaService;

@RestController 
@RequestMapping(path = "tela")
public class TelaDoSistemaController {
	
	@Autowired
	private TelasDoSistemaService service;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/lista", produces = "application/json")
	public TelaDoSistemaDto buscaTodasTelas() {
		return new TelaDoSistemaDto(service.buscaTodasTelas());
	}
}
