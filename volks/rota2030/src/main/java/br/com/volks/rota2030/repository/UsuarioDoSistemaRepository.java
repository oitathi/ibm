package br.com.volks.rota2030.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.volks.rota2030.model.UsuarioDoSistema;

public interface UsuarioDoSistemaRepository extends JpaRepository<UsuarioDoSistema, Long>,PagingAndSortingRepository<UsuarioDoSistema, Long>, UsuarioDoSistemaRepositoryCustom {
	
	@Transactional
	@Modifying
	@Query("UPDATE UsuarioDoSistema u SET"
				+ " u.email = ?2,"
				+ " u.isAcessoExpirado = ?3,"
				+ " u.dataUltimoAcesso =?4,"
				+ " u.perfil ="
				+ 		" (SELECT p FROM PerfilDeAcessoDoSistema p WHERE p.descricao =?5)"
				+ " WHERE u.id =?1")
	int update(long usuarioId, String usuarioEmail, boolean usuarioIsExpirado, String usuarioDataUltimoAcesso, String usuarioPerfil);

}
