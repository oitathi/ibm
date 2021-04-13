package br.com.volks.rota2030.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETRO_GERAL")
public class ParametroGeral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARAMETRO_GERAL_ID")
	private Long id;
	
	@Column(name = "PARAMETRO_GREAL_CNPJ_EMPRESA_HABILITADA")
	private String cnpjEmpresaHabilitada;
	
	@Column(name = "PARAMETRO_GERAL_FABRICANTE")
	private String fabricante;
	
	@Column(name = "PARAMETRO_GERAL_PERFIL_NOTIF_WKF")
	private String perfilNotifWfk;
	
	@Column(name = "PARAMETRO_GERAL_PERFIL_NOTIF_PFL")
	private String perfilNotifPfl;
}
