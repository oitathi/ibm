package br.com.volks.rota2030.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import br.com.volks.rota2030.dto.ItemDeSegurancaDto;
import br.com.volks.rota2030.util.StringOperations;

@NamedEntityGraph(name = "item-com-grupo-e-tipo", 
attributeNodes = { @NamedAttributeNode("grupo"),
				   @NamedAttributeNode("tipo") }

)

@Entity
@Table(name = "ITEM_DE_SEGURANCA")
public class ItemDeSeguranca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_DE_SEGURANCA_ID")
	private Long id;

	@Column(name = "ITEM_DE_SEGURANCA_DESCRICAO")
	private String descricao;

	@Column(name = "ITEM_DE_SEGURANCA_NORMA_CONTRAM")
	private String norma;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRUPO_ID", nullable = false)
	private ItemDeSegurancaGrupo grupo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_ID", nullable = false)
	private ItemDeSegurancaTipo tipo;

	@Column(name = "ITEM_DE_SEGURANCA_OBRIGATORIO")
	private boolean isObrigatorio;
	
	public ItemDeSeguranca() {

	}

	public ItemDeSeguranca(Long id, String descricao, String norma, boolean isObrigatorio, ItemDeSegurancaGrupo grupo, ItemDeSegurancaTipo tipo) {
		this.id = id;
		this.descricao = descricao;
		this.norma = norma;
		this.isObrigatorio = isObrigatorio;
		this.grupo = grupo;
		this.tipo = tipo;
	}

	public ItemDeSeguranca(String descricao, String norma, boolean isObrigatorio, ItemDeSegurancaGrupo grupo, ItemDeSegurancaTipo tipo) {

		this.descricao = descricao;
		this.norma = norma;
		this.isObrigatorio = isObrigatorio;
		this.grupo = grupo;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNorma() {
		return norma;
	}

	public boolean isObrigatorio() {
		return isObrigatorio;
	}

	public ItemDeSegurancaGrupo getGrupo() {
		return grupo;
	}

	public ItemDeSegurancaTipo getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "ItemDeSeguranca [id=" + id + ", descricao=" + descricao + ", normaContram=" + norma + ", isObrigatorio="
				+ isObrigatorio + ", grupo=" + grupo.getDescricao() + ", tipo=" + tipo.getDescricao() + "]";
	}

	public ItemDeSegurancaDto toDto() {
		return new ItemDeSegurancaDto(id, descricao, norma, grupo.getDescricao(), tipo.getDescricao(),
				isObrigatorio);
	}

}
