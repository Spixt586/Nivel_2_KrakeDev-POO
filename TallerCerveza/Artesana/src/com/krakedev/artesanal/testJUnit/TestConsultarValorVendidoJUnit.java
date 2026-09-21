package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

class TestConsultarValorVendidoJUnit {

	private NegocioMejorado negocio;

	private static final double DELTA = 0.0001; // margen de error para comparar double

	@BeforeEach
	void setUp() {
		negocio = new NegocioMejorado();
	}

	@Test
	void testConsultarValorVendido_sinClientes_debeRetornarCero() {
		// Qué se prueba: consultar el valor vendido cuando no hay clientes registrados
		// Resultado esperado: debe retornar 0.0 porque la lista de clientes está vacía
		double total = negocio.consultarValorVendido();

		assertEquals(0.0, total, DELTA, "Debe retornar 0.0 cuando no hay clientes registrados");
	}

	@Test
	void testConsultarValorVendido_unSoloCliente_debeRetornarSuConsumo() {
		// Qué se prueba: consultar el valor vendido cuando existe un único cliente con consumo registrado
		// Resultado esperado: el total debe ser igual al totalConsumido de ese cliente (15.0)
		negocio.registrarCliente("Juan Perez", "1234567890");
		Cliente cliente = negocio.getClientes().get(0);
		cliente.setTotalConsumido(15.0);

		double total = negocio.consultarValorVendido();

		assertEquals(15.0, total, DELTA, "El total debe coincidir con el consumo del único cliente registrado");
	}

	@Test
	void testConsultarValorVendido_variosClientes_debeSumarTodosLosConsumos() {
		// Qué se prueba: que el método sume correctamente el consumo de TODOS los clientes registrados
		// Resultado esperado: el total debe ser la suma de los tres consumos (10.0 + 20.0 + 5.5 = 35.5)
		negocio.registrarCliente("Juan Perez", "1111111111");
		negocio.registrarCliente("Maria Lopez", "2222222222");
		negocio.registrarCliente("Pedro Ramirez", "3333333333");

		negocio.getClientes().get(0).setTotalConsumido(10.0);
		negocio.getClientes().get(1).setTotalConsumido(20.0);
		negocio.getClientes().get(2).setTotalConsumido(5.5);

		double total = negocio.consultarValorVendido();

		assertEquals(35.5, total, DELTA, "El total debe ser la suma del consumo de todos los clientes");
	}

	@Test
	void testConsultarValorVendido_algunosClientesSinConsumo_debeIgnorarLosQueEstanEnCero() {
		// Qué se prueba: que clientes con totalConsumido en 0 no alteren la suma final
		// Resultado esperado: el total solo debe reflejar el consumo del cliente que sí consumió (30.0)
		negocio.registrarCliente("Juan Perez", "1111111111");
		negocio.registrarCliente("Maria Lopez", "2222222222"); // no consume nada, queda en 0.0 por defecto

		negocio.getClientes().get(0).setTotalConsumido(30.0);
		// getClientes().get(1) se deja sin modificar, totalConsumido = 0.0 por defecto

		double total = negocio.consultarValorVendido();

		assertEquals(30.0, total, DELTA, "El cliente sin consumo no debe afectar el total, solo suma el que consumió");
	}

	@Test
	void testConsultarValorVendido_noModificaListaDeClientes() {
		// Qué se prueba: que consultarValorVendido sea una operación de solo lectura
		// Resultado esperado: la cantidad de clientes registrados debe permanecer igual después de la consulta
		negocio.registrarCliente("Juan Perez", "1111111111");
		negocio.registrarCliente("Maria Lopez", "2222222222");

		negocio.consultarValorVendido();

		assertEquals(2, negocio.getClientes().size(), "El método no debe agregar ni eliminar clientes de la lista");
	}
}