package br.com.volks.rota2030.model;

import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.volks.rota2030.util.DateOperations;

@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_ID")
	private Long id;

	@Column(name = "USUARIO_LOGIN")
	private String login;

	@Column(name = "USUARIO_EMAIL")
	private String email;

	@Column(name = "USUARIO_DATA_ULTIMO_ACESSO")
	private Date dataUltimoAcesso;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_PERFIL", joinColumns = {
			@JoinColumn(name = "USUARIO_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "PERFIL_ID", nullable = false, updatable = false) })
	private Set<PerfilAcessoUsuario> perfis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return DateOperations.isUltimoAcessoHaMenosDe90Dias(dataUltimoAcesso);
	}

	@Override
	public boolean isAccountNonLocked() {
		return DateOperations.isUltimoAcessoHaMenosDe90Dias(dataUltimoAcesso);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return DateOperations.isUltimoAcessoHaMenosDe90Dias(dataUltimoAcesso);
	}

	@Override
	public boolean isEnabled() {
		return DateOperations.isUltimoAcessoHaMenosDe90Dias(dataUltimoAcesso);
	}

}
