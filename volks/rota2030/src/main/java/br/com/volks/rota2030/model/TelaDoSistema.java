package br.com.volks.rota2030.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TELA_SISTEMA")
public class TelaDoSistema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TELA_SISTEMA_ID")
	private Long id;

	@Column(name = "TELA_SISTEMA_DESCRICAO")
	private String descricao;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "telas")
	private Set<PerfilDeAcessoDoSistema> perfis;

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Set<PerfilDeAcessoDoSistema> getPerfis() {
		return perfis;
	}

	@Override
	public String toString() {
		return "TelaDoSistema [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	

}
