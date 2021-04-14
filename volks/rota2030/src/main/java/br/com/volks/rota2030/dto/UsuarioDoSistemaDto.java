package br.com.volks.rota2030.dto;

public class UsuarioDoSistemaDto {
	
	private long id;
	private String login;
	private String nome;
	private String email;
	private String perfil;
	private boolean isAcessoExpirado;
	private boolean isAcessoAtivo;
	private String dataUltimoAcesso;
	private String usuarioLogado;
		
	
	
	public UsuarioDoSistemaDto(long id, String login, String nome, String email, String perfil, boolean isAcessoExpirado, boolean isAcessoAtivo, String dataUltimoAcesso, String usuarioLogado) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
		this.isAcessoExpirado = isAcessoExpirado;
		this.isAcessoAtivo = isAcessoAtivo;
		this.dataUltimoAcesso = dataUltimoAcesso;
		this.usuarioLogado = usuarioLogado;
		
	}
	
	


	public UsuarioDoSistemaDto(long id, String login, String nome, String email, String perfil,
			boolean isAcessoExpirado, boolean isAcessoAtivo, String dataUltimoAcesso) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
		this.isAcessoExpirado = isAcessoExpirado;
		this.isAcessoAtivo = isAcessoAtivo;
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


	
	public boolean isAcessoExpirado() {
		return isAcessoExpirado;
	}


	public boolean isAcessoAtivo() {
		return isAcessoAtivo;
	}


	public String getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}


	public String getUsuarioLogado() {
		return usuarioLogado;
	}




	@Override
	public String toString() {
		return "UsuarioDoSistemaDto [id=" + id + ", login=" + login + ", nome=" + nome + ", email=" + email
				+ ", perfil=" + perfil + ", isAcessoExpirado=" + isAcessoExpirado + ", isAcessoAtivo=" + isAcessoAtivo
				+ ", dataUltimoAcesso=" + dataUltimoAcesso +"]";
	}


	
	

	

	
	

}
