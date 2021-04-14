package br.com.volks.rota2030.form;

import java.util.List;

public class PerfilDeAcessoDoSistemaForm {
	
	private String descricao;
	private List<String> telas;
	private List<String> usuarios;
	private String usuarioLogado;
	
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
