package br.com.volks.rota2030.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volks.rota2030.exceptions.TelaDoSistemaNotFoundException;
import br.com.volks.rota2030.exceptions.TelaDoSistemaSearchException;
import br.com.volks.rota2030.model.TelaDoSistema;
import br.com.volks.rota2030.repository.TelaDoSistemaRepository;

@Service
public class TelasDoSistemaService {

	 @Autowired
	 private TelaDoSistemaRepository repository;
	 
	 public TelaDoSistema buscaPorDescricao(String descricao) {
		 try {
			 Optional<TelaDoSistema> telaOp = repository.findByDescricao(descricao);
			 if(telaOp.isPresent()) {
				 return telaOp.get();
			 }
			 throw new TelaDoSistemaNotFoundException(descricao);
		 }catch(Exception e) {
			 throw new TelaDoSistemaSearchException(e);
		 }
	 }
	 
	 public List<TelaDoSistema> buscaTodasTelas(){
		 try {
			 return repository.findAll();
		 }catch(Exception e) {
			 throw new TelaDoSistemaSearchException(e);
		 }
	 }
	
}
