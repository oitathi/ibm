package br.com.volks.rota2030.dto;

import java.util.List;

public class PerfilDeAcessoDoSistemaDto {
	
	private long id;
	private String descricao;
	private List<String> telas;
	private List<String> usuarios;
	private String usuarioLogado;
	
	public PerfilDeAcessoDoSistemaDto(long id, String descricao, List<String> telas) {
		this.id = id;
		this.descricao = descricao;
		this.telas = telas;
	}
	
	public PerfilDeAcessoDoSistemaDto(long id, String descricao, List<String> telas, List<String> usuarios) {
		this.id = id;
		this.descricao = descricao;
		this.telas = telas;
		this.usuarios = usuarios;
	}

	public long getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}


	public List<String> getTelas() {
		return telas;
	}


	public List<String> getUsuarios() {
		return usuarios;
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}	
	
	

}
