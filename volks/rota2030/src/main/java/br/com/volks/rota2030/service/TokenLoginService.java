package br.com.volks.rota2030.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenLoginService {
	
	@Value("${rota2030.jwt.expiration}")
	private String expiration;
	
	@Value("${rota2030.jwt.secret}")
	private String secret;

	public String gerarTokenLogin(Authentication authenticate) {
		Usuario usuarioLogado = (Usuario)authenticate.getPrincipal();
		
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.valueOf(expiration));
		
		return Jwts.builder()
				.setIssuer("rota2030")
				.setSubject(usuarioLogado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
