package br.com.volks.rota2030.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.volks.rota2030.model.PerfilDeAcessoDoSistema;

public interface PerfilDeAcessoDoSistemaRepository extends JpaRepository<PerfilDeAcessoDoSistema, Long>, PagingAndSortingRepository<PerfilDeAcessoDoSistema, Long>{  

	@Query("SELECT p FROM PerfilDeAcessoDoSistema p JOIN p.telas t ON p.id = t.id WHERE p.descricao = ?1")
	Optional<PerfilDeAcessoDoSistema> buscaPerfilETelasPorDescricao(String descricao);
	
	@Query("SELECT p FROM PerfilDeAcessoDoSistema p JOIN p.telas t ON p.id = t.id  JOIN p.usuarios u ON p.id = u.id WHERE p.descricao = ?1")
	Optional<PerfilDeAcessoDoSistema> buscaPerfilETelasEUsuariosPorDescricao(String descricao);
	
	@Query("SELECT p FROM PerfilDeAcessoDoSistema p JOIN p.telas t ON p.id = t.id  JOIN p.usuarios u ON p.id = u.id")
	List<PerfilDeAcessoDoSistema> buscaTodosPerfisETelasEUsuarios();
	
	@Query("SELECT p FROM PerfilDeAcessoDoSistema p JOIN p.usuarios u ON p.id = u.id WHERE p.id = ?1")
	Optional<PerfilDeAcessoDoSistema> buscaPerfilEUsuariosPorId(long id);
	
}
