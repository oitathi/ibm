package br.com.volks.rota2030.dto;

public class UsuarioDoSistemaDto {
	
	private long id;
	private String login;
	private String nome;
	private String email;
	private String perfil;
	private boolean isExpirado;
	private String dataUltimoAcesso;
	private String usuario;
	
	public UsuarioDoSistemaDto(long id, String login, String nome, String email, String perfil, boolean isExpirado, String dataUltimoAcesso) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
		this.isExpirado = isExpirado;
		this.dataUltimoAcesso = dataUltimoAcesso;
	}


	public long getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getPerfil() {
		return perfil;
	}


	public boolean isExpirado() {
		return isExpirado;
	}


	public String getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}


	public String getUsuario() {
		return usuario;
	}



	
	

}
