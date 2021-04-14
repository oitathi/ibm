package br.com.volks.rota2030.repository;

import java.util.Date;
import java.util.Optional;

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
				+ " u.nome = ?2,"
				+ " u.email = ?3,"
				+ " u.isAcessoExpirado = ?4,"
				+ " u.isAcessoAtivo = ?5,"
				+ " u.dataUltimoAcesso =?6,"
				+ " u.perfil ="
				+ 		" (SELECT p FROM PerfilDeAcessoDoSistema p WHERE p.descricao =?7)"
				+ " WHERE u.id =?1")
	int update(long usuarioId, String usuarioNome, String usuarioEmail, boolean usuarioIsExpirado, boolean usuarioIsAtivo, Date usuarioDataUltimoAcesso, String usuarioPerfil);

	
	Optional<UsuarioDoSistema> findByLogin(String login);
}
