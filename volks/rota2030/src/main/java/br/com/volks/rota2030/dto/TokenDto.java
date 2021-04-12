package br.com.volks.rota2030.dto;

public class TokenDto {

	private String tokenLogin;
	private String tipo;

	public TokenDto(String tokenLogin, String tipo) {
		this.tokenLogin = tokenLogin;
		this.tipo = tipo;
	}

	public String getTokenLogin() {
		return tokenLogin;
	}

	public String getTipo() {
		return tipo;
	}
	
	

}
