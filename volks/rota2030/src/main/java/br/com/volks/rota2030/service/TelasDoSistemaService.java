package br.com.volks.rota2030.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.exceptions.TelaDoSistemaSearchException;
import br.com.volks.rota2030.model.TelaDoSitema;
import br.com.volks.rota2030.repository.TelaDoSistemaRepository;

@Service
public class TelasDoSistemaService {

	 @Autowired
	 private TelaDoSistemaRepository repository;
	 
	 
	 public List<TelaDoSitema> buscaTodasTelas(){
		 try {
			 return repository.findAll();
		 }catch(Exception e) {
			 throw new TelaDoSistemaSearchException(e);
		 }
	 }
	
}
