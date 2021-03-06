package br.com.volks.rota2030.form;

import javax.validation.constraints.NotBlank;

public class UsuarioDoSistemaForm {
	
	@NotBlank(message = "Login eh obrigatorio")
	private String login;
	
	@NotBlank(message = "Email eh obrigatorio")
	private String email;
	
	@NotBlank(message = "Nome eh obrigatorio")
	private String nome;
	
	@NotBlank(message = "Perfil eh obrigatorio")
	private String perfil;

	@NotBlank(message = "Usuario eh obrigatorio")
	private String usuarioLogado;
	
	private boolean isAcessoExpirado;
	
	private boolean isAcessoAtivo;
	
	
	
	public UsuarioDoSistemaForm( String login,String email, String nome,String perfil,String usuarioLogado, boolean isAcessoExpirado,
			boolean isAcessoAtivo) {
		
		this.login = login;
		this.email = email;
		this.nome = nome;
		this.perfil = perfil;
		this.usuarioLogado = usuarioLogado;
		this.isAcessoExpirado = isAcessoExpirado;
		this.isAcessoAtivo = isAcessoAtivo;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getPerfil() {
		return perfil;
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public boolean isAcessoExpirado() {
		return isAcessoExpirado;
	}

	public boolean isAcessoAtivo() {
		return isAcessoAtivo;
	}
	
	
	

}
