package br.com.volks.rota2030.p2p;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import br.com.volks.rota2030.controller.UsuarioDoSistemaController;
import br.com.volks.rota2030.dto.UsuarioDoSistemaDto;
import br.com.volks.rota2030.form.UsuarioDoSistemaForm;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = ("spring.h2.console.enabled=true"))
public class UsuarioP2PTest {
	
	@Autowired
	private UsuarioDoSistemaController controller;
	
	private Map<String, String> filtro;
	
	@Test
	@Order(2)
	public void deveRetornarListaDeUsuariosSemFiltro() {
		filtro = new HashMap<>();
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		assertEquals(3, actual.getTotalElements());
	}
	
	@Test
	@Order(3)
	public void deveRetornarListaDeUsuariosFiltradoPorLogin() {
		filtro = new HashMap<>();
		filtro.put("login", "master");
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		
		assertEquals(1, actual.getTotalElements());
	}
	
	@Test
	@Order(4)
	public void deveRetornarListaDeUsuariosFiltradoPorNome() {
		filtro = new HashMap<>();
		filtro.put("nome", "Fulano");
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		
		assertEquals(1, actual.getTotalElements());
	}
	
	@Test
	@Order(5)
	public void deveRetornarListaDeUsuariosFiltradoPorEmail() {
		filtro = new HashMap<>();
		filtro.put("email", "fulano@teste.com");
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		
		assertEquals(1, actual.getTotalElements());
	}
	
	@Test
	@Order(6)
	public void deveRetornarListaDeUsuariosFiltradoPorAcessoExpirado() {
		filtro = new HashMap<>();
		filtro.put("acessoExpirado", "true");
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		
		assertEquals(1, actual.getTotalElements());
	}
	
	@Test
	@Order(7)
	public void deveRetornarListaDeUsuariosFiltradoPorAcessoInativo() {
		filtro = new HashMap<>();
		filtro.put("acessoAtivo", "false");
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		assertEquals(1, actual.getTotalElements());
	}
	
	@Test
	@Order(8)
	public void deveRetornarListaDeUsuariosFiltradoPorPerfil() {
		filtro = new HashMap<>();
		filtro.put("perfil", "master");
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		assertEquals(1, actual.getTotalElements());
	}
	
	@Test
	@Order(9)
	public void deveRetornarListaDeUsuariosFiltradoPorLoginNomeEmailAcessosPerfil() {
		filtro = new HashMap<>();
		filtro.put("login", "master");
		filtro.put("nome", "Fulano");
		filtro.put("email", "fulano@teste.com");
		filtro.put("acessoExpirado", "false");
		filtro.put("acessoAtivo", "true");
		filtro.put("perfil", "master");
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		assertEquals(1, actual.getTotalElements());
	}

	@Test
	@Order(10)
	public void deveSalvarUmContato() {
		UsuarioDoSistemaForm form = new UsuarioDoSistemaForm("tester", "tester@teste.com", "jose da silva", "user", "logado", false, true);
		UsuarioDoSistemaDto dto = controller.salva(form);
		assertTrue(dto.getId()>0);
	}
	
	@Test
	@Order(11)
	public void deveEditarUmContato() {
		UsuarioDoSistemaDto dto = new UsuarioDoSistemaDto(4,"tester","jose da silva santos","tester2@teste.com", "master", true, false,"01/04/2021", "logado");
		dto = controller.edita(dto);
		
		filtro = new HashMap<>();
		filtro.put("nome", "jose da silva santos");
		
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(filtro, 0, 10, "id");
		
		assertEquals(1, actual.getTotalElements());
	}
	
	@Test
	@Order(12)
	public void deveDeletarUmContato() {
		boolean isUsuariodeletado = controller.deleta(1L, "logado");
		
		Page<UsuarioDoSistemaDto> actual = controller.buscaDinamica(new HashMap<>(), 0, 10, "id");
		assertTrue(isUsuariodeletado);
		assertEquals(3, actual.getTotalElements());
	}

}
