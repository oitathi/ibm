package br.com.volks.rota2030.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.volks.rota2030.dto.UsuarioDoSistemaDto;


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


	public String getNorma() {
		return norma;
	}


	public String getGrupo() {
		return grupo;
	}


	public String getTipo() {
		return tipo;
	}


	public boolean isObrigatorio() {
		return obrigatorio;
	}


	public String getUsuario() {
		return usuario;
	}

	

	

}
