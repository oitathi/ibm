package br.com.volks.rota2030.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.volks.rota2030.dto.TokenDto;
import br.com.volks.rota2030.form.LoginForm;
import br.com.volks.rota2030.service.TokenLoginService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenLoginService tokenLoginService;
	
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm dto){
		UsernamePasswordAuthenticationToken dadosLogin = dto.converter(); 
		try {
			Authentication authenticate = authManager.authenticate(dadosLogin); //chama authService
			
			String tokenLogin = tokenLoginService.gerarTokenLogin(authenticate);
			
			return ResponseEntity.ok(new TokenDto(tokenLogin, "Bearer"));
		}catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
