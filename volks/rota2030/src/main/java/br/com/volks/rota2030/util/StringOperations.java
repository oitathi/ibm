package br.com.volks.rota2030.util;

import java.util.ArrayList;
import java.util.List;

import br.com.volks.rota2030.dto.ItemDeSegurancaDto;
import br.com.volks.rota2030.exceptions.ToCsvException;
import br.com.volks.rota2030.model.PerfilDeAcessoDoSistema;
import br.com.volks.rota2030.model.UsuarioDoSistema;

public class StringOperations {
	
	public static String listToCsv(List<ItemDeSegurancaDto> itens) {
		try {
			StringBuilder sb = new StringBuilder();
			itens.forEach(responseDto -> sb.append(responseDto.toCsv()));
			return sb.toString();
		}catch(Exception e ) {
			throw new ToCsvException(e);
		}
	}
	
	public static List<String> getTelasList(PerfilDeAcessoDoSistema perfil){
		List<String> telas = new ArrayList<String>();
		perfil.getTelas().forEach(t -> telas.add(t.getDescricao()));
		return telas;
		
	}
	
	public static List<String> getUsuariosList(PerfilDeAcessoDoSistema perfil){
		List<String> usuarios = new ArrayList<String>();
		perfil.getUsuarios().forEach(u -> usuarios.add(u.getLogin()));
		return usuarios;
		
	}

}
