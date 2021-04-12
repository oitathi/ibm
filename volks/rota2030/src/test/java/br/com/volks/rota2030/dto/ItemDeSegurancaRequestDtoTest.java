package br.com.volks.rota2030.dto;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.volks.rota2030.form.ItemDeSegurancaForm;


public class ItemDeSegurancaRequestDtoTest {

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void deveRetornarItemDeSegurancaValido() {
		ItemDeSegurancaForm dto = new ItemDeSegurancaForm();
		dto.setDescricao("descricao");
		dto.setNorma("norma");
		dto.setGrupo("GRUPO_A");
		dto.setTipo("TIPO_AUTOMOVEL");
		dto.setObrigatorio(true);
		dto.setUsuario("usuario");
		
		Set<ConstraintViolation<ItemDeSegurancaForm>> violations = validator.validate(dto);
        Assert.assertTrue(violations.isEmpty());
	}
	
	@Test
	public void deveRetornarItemDeSegurancaInvalido() {
		ItemDeSegurancaForm dto = new ItemDeSegurancaForm();
		dto.setDescricao("");
		dto.setNorma("");
		dto.setGrupo("");
		dto.setTipo("");
		dto.setObrigatorio(true);
		dto.setUsuario("");
		
		Set<ConstraintViolation<ItemDeSegurancaForm>> violations = validator.validate(dto);
        Assert.assertEquals(5, violations.size());
	}
	
	@Test
	public void loadClass() {
		ItemDeSegurancaForm dto = new ItemDeSegurancaForm("Item X", "Norma Alfa", "Grupo C", "Caminhonete",  false, "tester");
		assertNotNull(dto.getDescricao());
		assertNotNull(dto.getNorma());
		assertNotNull(dto.getGrupo());
		assertNotNull(dto.getTipo());
		assertNotNull(dto.isObrigatorio());
		assertNotNull(dto.getUsuario());
		
	}

}
