package com.krakedev.contacto.entidades.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

class DirectorioTest {

	private Directorio directorio;

	@BeforeEach
	void setUp() {
		// Se inicializa un Directorio limpio antes de cada prueba
		directorio = new Directorio();
	}

	@Test
	void testAgregarContactoNuevo_debeRetornarTrue() {
		// Qué se prueba: agregar un contacto que NO existe previamente en el directorio
		// Resultado esperado: el método debe retornar true porque el contacto fue agregado
		Contacto contacto = new Contacto();
		contacto.setNombre("Juan Perez");
		contacto.setCelular("0991234567");

		boolean resultado = directorio.agregarContacto(contacto);

		assertTrue(resultado, "Debe retornar true al agregar un contacto nuevo");
	}

	@Test
	void testAgregarContactoDuplicado_debeRetornarFalse() {
		// Qué se prueba: intentar agregar un contacto cuyo número ya existe en el directorio
		// Resultado esperado: el método debe retornar false porque el contacto es duplicado
		Contacto contacto1 = new Contacto();
		contacto1.setNombre("Juan Perez");
		contacto1.setCelular("0991234567");

		Contacto contacto2 = new Contacto();
		contacto2.setNombre("Otro Nombre");
		contacto2.setCelular("0991234567");

		directorio.agregarContacto(contacto1);
		boolean resultado = directorio.agregarContacto(contacto2);

		assertFalse(resultado, "Debe retornar false al intentar agregar un contacto con número duplicado");
	}

	@Test
	void testTamanioListaDespuesDeAgregarUnContacto() {
		// Qué se prueba: que el tamaño de la lista de contactos aumente correctamente al agregar
		// Resultado esperado: el tamaño de la lista debe ser 1 después de agregar un contacto
		Contacto contacto = new Contacto();
		contacto.setNombre("Maria Lopez");
		contacto.setCelular("0987654321");

		directorio.agregarContacto(contacto);

		assertEquals(1, directorio.obtenerCantidadContactos(), "El tamaño de la lista debe ser 1");
	}

	@Test
	void testTamanioListaNoAumentaConDuplicados() {
		// Qué se prueba: que el tamaño de la lista NO aumente al intentar agregar un duplicado
		// Resultado esperado: el tamaño de la lista debe seguir siendo 1
		Contacto contacto1 = new Contacto();
		contacto1.setNombre("Pedro Ramirez");
		contacto1.setCelular("0987654321");

		Contacto contacto2 = new Contacto();
		contacto2.setNombre("Pedro Ramirez Duplicado");
		contacto2.setCelular("0987654321");

		directorio.agregarContacto(contacto1);
		directorio.agregarContacto(contacto2);

		assertEquals(1, directorio.obtenerCantidadContactos(), "No deben agregarse contactos duplicados a la lista");
	}

	@Test
	void testNoSeAgreganDuplicados_contactoOriginalSePreserva() {
		// Qué se prueba: que al intentar agregar un duplicado, el contacto original en la lista
		// no sea reemplazado ni modificado
		// Resultado esperado: el contacto almacenado debe seguir siendo el original (mismo nombre)
		Contacto original = new Contacto();
		original.setNombre("Ana Torres");
		original.setCelular("0999999999");

		Contacto duplicado = new Contacto();
		duplicado.setNombre("Nombre Falso");
		duplicado.setCelular("0999999999");

		directorio.agregarContacto(original);
		directorio.agregarContacto(duplicado);

		Contacto encontrado = directorio.buscarContacto("0999999999");

		assertEquals("Ana Torres", encontrado.getNombre(), "El contacto original no debe ser sobrescrito por el duplicado");
	}

	@Test
	void testAgregarVariosContactosDistintos_debeAumentarTamanioCorrectamente() {
		// Qué se prueba: agregar múltiples contactos con números diferentes
		// Resultado esperado: el tamaño de la lista debe coincidir con la cantidad de contactos agregados
		Contacto c1 = new Contacto();
		c1.setNombre("Contacto Uno");
		c1.setCelular("0911111111");

		Contacto c2 = new Contacto();
		c2.setNombre("Contacto Dos");
		c2.setCelular("0922222222");

		Contacto c3 = new Contacto();
		c3.setNombre("Contacto Tres");
		c3.setCelular("0933333333");

		directorio.agregarContacto(c1);
		directorio.agregarContacto(c2);
		directorio.agregarContacto(c3);

		assertEquals(3, directorio.obtenerCantidadContactos(), "El tamaño de la lista debe ser 3 al agregar 3 contactos distintos");
	}
}