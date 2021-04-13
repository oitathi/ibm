package br.com.volks.rota2030.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import br.com.volks.rota2030.model.UsuarioDoSistema;

@Repository
public class UsuarioDoSistemaRepositoryImpl implements UsuarioDoSistemaRepositoryCustom {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public Page<UsuarioDoSistema> buscaPorFiltros(Map<String, String> filtro, int pageNo, int pageSize, String sortBy) {
		EntityGraph entityGraph = em.getEntityGraph("usuario-com-perfil");
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<UsuarioDoSistema> cq = cb.createQuery(UsuarioDoSistema.class);
	    
	    Root<UsuarioDoSistema> usuario = cq.from(UsuarioDoSistema.class);
	    Predicate predicate = cb.conjunction();
	    
	    for (Map.Entry<String, String> entry : filtro.entrySet()) {
	    	if(StringUtils.isNotBlank(entry.getValue())) {
		    	switch (entry.getKey()) {
			    	case"id":
		    			predicate = cb.and(cb.equal(usuario.get("id"), entry.getValue()));
		    			break;
		    			
			    	case"login":
		    			predicate = cb.and(cb.equal(usuario.get("login"), entry.getValue()));
		    			break;
		    			
			    	case"email":
		    			predicate = cb.and(cb.equal(usuario.get("email"), entry.getValue()));
		    			break;
		    			
			    	case"acessoExpirado":
		    			predicate = cb.and(cb.equal(usuario.get("isAcessoExpirado"), entry.getValue()));
		    			break;
		    			
			    	case"perfil":
		    			predicate = cb.and(cb.equal(usuario.get("perfil").get("descricao"), entry.getValue()));
		    			break;
		    	}
	    	}
	    }
	    
	    TypedQuery<UsuarioDoSistema> tp = em
    			.createQuery(cq.where(predicate)
    			.orderBy(cb.asc(usuario.get(sortBy))))
    		    .setHint("javax.persistence.loadgraph", entityGraph); 
    
    
	    tp.setFirstResult(pageNo * pageNo);
	    tp.setMaxResults(pageSize);
	    
	    List<UsuarioDoSistema> resultado = tp.getResultList();
	   	   	    
	    Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
	    Page<UsuarioDoSistema> resultPaged = new PageImpl<UsuarioDoSistema>(resultado, page, resultado.size());
	
	    return resultPaged;
	}

	@Override
	public UsuarioDoSistema findByIdFullLoad(long id) {
		EntityGraph entityGraph = em.getEntityGraph("usuario-com-perfil");
	    Map<String, Object> properties = new HashMap<>();
	    properties.put("javax.persistence.fetchgraph", entityGraph);
	    UsuarioDoSistema usuario = em.find(UsuarioDoSistema.class, id, properties);
	    return usuario;
	}

}
