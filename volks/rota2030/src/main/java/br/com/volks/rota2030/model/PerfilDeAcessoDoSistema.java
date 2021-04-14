package br.com.volks.rota2030.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERFIL_DE_ACESSO_SISTEMA")
public class PerfilDeAcessoDoSistema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERFIL_DE_ACESSO_ID")
	private Long id;

	@Column(name = "PERFIL_DE_ACESSO_DESCRICAO")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	private Set<UsuarioDoSistema> usuarios;
	
	

	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JoinTable(name = "PERFIL_DE_ACESSO_TELA", joinColumns = { 
	            @JoinColumn(name = "PERFIL_DE_ACESSO_ID", nullable = false, updatable = false) }, 
	            inverseJoinColumns = { @JoinColumn(name = "TELA_SISTEMA_ID", 
	                    nullable = false, updatable = false) })
	 private Set<TelaDoSitema> telas;
	 
	 
	 
	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Set<UsuarioDoSistema> getUsuarios() {
		return usuarios;
	}

	public Set<TelaDoSitema> getTelas() {
		return telas;
	}



	

}
