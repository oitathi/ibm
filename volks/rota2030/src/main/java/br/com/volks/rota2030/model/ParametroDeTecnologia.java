package br.com.volks.rota2030.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETRO_TECNOLOGIA")
public class ParametroDeTecnologia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARAMETRO_TECNOLOGIA_ID")
	private Long id;
	
	@Column(name = "PARAMETRO_TECNOLOGIA_INCORPORADA")
	private String tecnologiaIncorporada;
	
	@Column(name = "PARAMETRO_TECNOLOGIA_NOME_COMERCIAL")
	private String nomeComercial;
	
	@Column(name = "PARAMETRO_TECNOLOGIA_MARCA")
	private String marca;
	
	@Column(name = "PARAMETRO_TECNOLOGIA_CREDITO")
	private String credito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TECNOLOGIA_REFERENCIA_ID", nullable = false)
	private ParametroDeTecnologiaReferencia referencia;

	
	@Column(name = "PARAMETRO_TECNOLOGIA_DESPACHO_SDP")
	private String despachoSdp;
	
	@Column(name = "PARAMETRO_TECNOLOGIA_DESPACHO_SDCI")
	private String despachoSdci;
	
	@Column(name = "PARAMETRO_TECNOLOGIA_NUMERO_DECRETO")
	private String numDecreto;
	
	@Column(name = "PARAMETRO_TECNOLOGIA_DATA_DECRETO")
	private Date dataDecreto;

	public ParametroDeTecnologia() {
		
	}


	

	
}
