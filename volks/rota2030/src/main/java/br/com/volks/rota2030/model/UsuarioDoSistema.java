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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import br.com.volks.rota2030.dto.UsuarioDoSistemaDto;
import br.com.volks.rota2030.util.DateOperations;
import br.com.volks.rota2030.util.StringOperations;

@NamedEntityGraph(name = "usuario-com-perfil", 
attributeNodes = { @NamedAttributeNode("perfil") }

)

@Entity
@Table(name = "USUARIO_DO_SISTEMA")
public class UsuarioDoSistema  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_DO_SISTEMA_ID")
	private Long id;

	@Column(name = "USUARIO_DO_SISTEMA_LOGIN")
	private String login;

	@Column(name = "USUARIO_DO_SISTEMA_NOME")
	private String nome;
	
	@Column(name = "USUARIO_DO_SISTEMA_EMAIL")
	private String email;
	
	@Column(name = "USUARIO_DO_SISTEMA_EXPIRADO")
	private boolean isAcessoExpirado;
	
	@Column(name = "USUARIO_DO_SISTEMA_ATIVO")
	private boolean isAcessoAtivo;

	@Column(name = "UUSUARIO_DO_SISTEMA_DATA_ULTIMO_ACESSO")
	private Date dataUltimoAcesso;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERFIL_DE_ACESSO_ID", nullable = false)
	private PerfilDeAcessoDoSistema perfil;
		

	
	
	public UsuarioDoSistema() {
	}

	public UsuarioDoSistema(String login, String nome, String email, PerfilDeAcessoDoSistema perfil) {
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
		
		//sempre q salva um novo usuario
		this.isAcessoExpirado = false;
		this.isAcessoAtivo = true;
	}

	

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public boolean isAcessoExpirado() {
		return isAcessoExpirado;
	}
	
	
	public boolean isAcessoAtivo() {
		return isAcessoAtivo;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public PerfilDeAcessoDoSistema getPerfil() {
		return perfil;
	}

	@Override
	public String toString() {
		return "UsuarioDoSistema [id=" + id + ", login=" + login + ", nome=" + nome + ", email=" + email
				+ ", perfil=" + perfil.getDescricao() + "]";
	}
	
	public UsuarioDoSistemaDto toDto() {
		return new UsuarioDoSistemaDto(id, nome, login, email, perfil.getDescricao(), isAcessoExpirado, isAcessoAtivo, DateOperations.toString(dataUltimoAcesso));
	}
	

	//DateOperations.isUltimoAcessoHaMenosDe90Dias(dataUltimoAcesso);

}
