package br.com.volks.rota2030.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ItemDeSegurancaForm {

	@NotBlank(message = "Descricao eh obrigatoria")
	private String descricao;

	@NotBlank(message = "Norma Contram eh obrigatoria")
	private String norma;

	@NotBlank(message = "Grupo eh obrigatorio")
	private String grupo;

	@NotBlank(message = "Tipo eh obrigatorio")
	private String tipo;

	private boolean obrigatorio;

	
	private String usuario;
	
	public ItemDeSegurancaForm() {
		
	}

	public ItemDeSegurancaForm(String descricao, String norma, String grupo, String tipo, boolean obrigatorio, String usuario) {
		this.descricao = descricao;
		this.norma = norma;
		this.grupo = grupo;
		this.tipo = tipo;
		this.obrigatorio = obrigatorio;
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNorma() {
		return norma;
	}

	public void setNorma(String norma) {
		this.norma = norma;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

}
