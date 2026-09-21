package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

class TestConsumirCervezaJUnit {

	private NegocioMejorado negocio;
	private Maquina maquina;
	private Cliente cliente;

	private static final double DELTA = 0.0001; // margen de error para comparar double

	@BeforeEach
	void setUp() {
		negocio = new NegocioMejorado();

		// Máquina con capacidad de 1000 ml y precio de 0.05 por ml
		maquina = new Maquina("Cerveza Artesanal", "M-1", "Rubia", 0.05, 1000);
		maquina.llenarMaquina(); // cantidadActual queda en 900 (capacidadMaxima - 100)

		ArrayList<Maquina> maquinas = new ArrayList<>();
		maquinas.add(maquina);
		negocio.setMaquinas(maquinas);

		// registrarCliente asigna automáticamente el código 100 (ultimoCodigo inicial)
		negocio.registrarCliente("Juan Perez", "1234567890");
		cliente = negocio.getClientes().get(0);
	}

	@Test
	void testConsumirCerveza_clienteActualizado() {
		// Qué se prueba: que al consumir cerveza, el totalConsumido del cliente se actualice
		// Resultado esperado: totalConsumido debe ser igual a cantidad * precioPorMl (200 * 0.05 = 10.0)
		negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 200);

		assertEquals(10.0, cliente.getTotalConsumido(), DELTA,
				"El totalConsumido del cliente debe actualizarse correctamente");
	}

	@Test
	void testConsumirCerveza_maquinaAfectada() {
		// Qué se prueba: que al consumir cerveza, la cantidadActual de la máquina disminuya
		// Resultado esperado: cantidadActual debe reducirse exactamente en la cantidad servida (900 - 200 = 700)
		double cantidadAntes = maquina.getCantidadActual();

		negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 200);

		assertEquals(cantidadAntes - 200, maquina.getCantidadActual(), DELTA,
				"La cantidadActual de la máquina debe disminuir según lo consumido");
	}

	@Test
	void testConsumirCerveza_valoresCorrectos() {
		// Qué se prueba: que el cálculo de consumo sea el correcto tanto en cliente como en máquina
		// Resultado esperado: totalConsumido = 150 * 0.05 = 7.5, y cantidadActual = 900 - 150 = 750
		negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 150);

		assertEquals(7.5, cliente.getTotalConsumido(), DELTA, "El valor consumido calculado debe ser correcto");
		assertEquals(750, maquina.getCantidadActual(), DELTA, "El stock restante de la máquina debe ser correcto");
	}

	@Test
	void testConsumirCerveza_clienteAcumulaVariosConsumos() {
		// Qué se prueba: que dos consumos consecutivos se acumulen correctamente en totalConsumido
		// Resultado esperado: totalConsumido = (100*0.05) + (50*0.05) = 5.0 + 2.5 = 7.5
		negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 100);
		negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 50);

		assertEquals(7.5, cliente.getTotalConsumido(), DELTA,
				"El consumo acumulado del cliente debe sumar correctamente ambas transacciones");
	}

	@Test
	void testConsumirCerveza_codigoClienteInexistente_noAfectaMaquina() {
		// Qué se prueba: que si el código de cliente no existe, no se afecte la máquina ni se lance excepción
		// Resultado esperado: cantidadActual de la máquina permanece sin cambios
		double cantidadAntes = maquina.getCantidadActual();

		negocio.consumirCerveza(9999, maquina.getCodigo(), 200); // código de cliente inexistente

		assertEquals(cantidadAntes, maquina.getCantidadActual(), DELTA,
				"La máquina no debe verse afectada si el cliente no existe");
	}

	@Test
	void testConsumirCerveza_codigoMaquinaInexistente_noAfectaCliente() {
		// Qué se prueba: que si el código de máquina no existe, no se actualice el cliente ni se lance excepción
		// Resultado esperado: totalConsumido del cliente permanece en 0
		negocio.consumirCerveza(cliente.getCodigo(), "M-999", 200); // código de máquina inexistente

		assertEquals(0.0, cliente.getTotalConsumido(), DELTA,
				"El cliente no debe verse afectado si la máquina no existe");
	}

	@Test
	void testConsumirCerveza_cantidadMayorAlStock_noRegistraConsumo() {
		// Qué se prueba: que si se solicita más cantidad de la disponible, servirCerveza retorna 0
		// y por lo tanto no se incrementa el totalConsumido del cliente
		// Resultado esperado: totalConsumido permanece en 0 y la máquina no pierde stock
		double cantidadAntes = maquina.getCantidadActual(); // 900

		negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 5000); // excede el stock

		assertEquals(0.0, cliente.getTotalConsumido(), DELTA, "No debe registrarse consumo si no hay stock suficiente");
		assertEquals(cantidadAntes, maquina.getCantidadActual(), DELTA, "El stock de la máquina no debe cambiar");
	}
}