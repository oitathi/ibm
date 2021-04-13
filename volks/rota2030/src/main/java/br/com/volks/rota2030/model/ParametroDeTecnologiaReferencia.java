package br.com.volks.rota2030.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETRO_TECNOLOGIA_REFERENCIA")
public class ParametroDeTecnologiaReferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARAMETRO_TECNOLOGIA_REFERENCIA_ID")
	private Long id;
	
	@Column(name = "PARAMETRO_TECNOLOGIA_REFERENCIA_DESCRICAO")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "referencia")
	private Set<ParametroDeTecnologia> tecnologias;
	
	

}
