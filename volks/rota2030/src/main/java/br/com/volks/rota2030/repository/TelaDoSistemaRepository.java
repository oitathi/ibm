package br.com.volks.rota2030.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.volks.rota2030.model.TelaDoSitema;

public interface TelaDoSistemaRepository extends JpaRepository<TelaDoSitema, Long>,PagingAndSortingRepository<TelaDoSitema, Long>{

}
