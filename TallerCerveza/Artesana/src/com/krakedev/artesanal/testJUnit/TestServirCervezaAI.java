package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

class TestServirCervezaAI {

	// Tolerancia para comparaciones de tipo double
	private static final double DELTA = 0.0001;

	private Maquina maquinaConCapacidad;   // usa el constructor con capacidadMaxima explícita
	private Maquina maquinaSinCapacidad;   // usa el constructor con capacidadMaxima por defecto (10000)

	@BeforeEach
	void setUp() {
		// Constructor con los 4 parámetros (incluye capacidadMaxima)
		maquinaConCapacidad = new Maquina("IPA Artesanal", "03838", "Cerveza amarga con notas cítricas", 0.05, 1000);

		// Constructor con 3 parámetros (capacidadMaxima queda en 10000 por defecto)
		maquinaSinCapacidad = new Maquina("Stout Negra", "938736","Cerveza oscura y cremosa", 0.08);
	}

	@Test
	void testServirCervezaConStockSuficiente() {
		// Cargamos stock usando recargarCerveza (método real de la clase)
		maquinaConCapacidad.recargarCerveza(500);

		// Valida que al servir una cantidad menor al stock disponible,
		// se retorne el valor correcto (cantidad * precioPorMl)
		double valor = maquinaConCapacidad.servirCerveza(200);

		assertEquals(10.0, valor, DELTA); // 200 * 0.05 = 10.0
		// Valida que la cantidadActual se haya descontado correctamente
		assertEquals(300.0, maquinaConCapacidad.getCantidadActual(), DELTA);
	}

	@Test
	void testServirCervezaCantidadExactaAlStockDisponible() {
		maquinaConCapacidad.recargarCerveza(150);

		// Valida el caso límite: se sirve exactamente toda la cerveza disponible
		double valor = maquinaConCapacidad.servirCerveza(150);

		assertEquals(7.5, valor, DELTA); // 150 * 0.05 = 7.5
		// Al servir todo el stock, la cantidadActual debe quedar en 0
		assertEquals(0.0, maquinaConCapacidad.getCantidadActual(), DELTA);
	}

	@Test
	void testServirCervezaSinStockSuficiente() {
		maquinaConCapacidad.recargarCerveza(100);

		// Valida que si se pide más cerveza de la disponible, no se sirve nada
		double valor = maquinaConCapacidad.servirCerveza(300);

		// Debe retornar 0 al no poder completar el servicio
		assertEquals(0.0, valor, DELTA);
		// La cantidadActual no debe modificarse cuando no se sirve
		assertEquals(100.0, maquinaConCapacidad.getCantidadActual(), DELTA);
	}

	@Test
	void testServirCervezaMaquinaVacia() {
		// La máquina recién construida no tiene cerveza cargada (cantidadActual = 0)
		double valor = maquinaSinCapacidad.servirCerveza(50);

		// No hay stock, por lo que debe retornar 0
		assertEquals(0.0, valor, DELTA);
		// La cantidadActual debe permanecer en 0
		assertEquals(0.0, maquinaSinCapacidad.getCantidadActual(), DELTA);
	}

	@Test
	void testServirCervezaCantidadCero() {
		maquinaSinCapacidad.recargarCerveza(200);

		// Valida el caso donde se pide servir 0 ml: entra en la rama de éxito
		// (cantidadActual >= 0 es verdadero), pero no cambia nada realmente
		double valor = maquinaSinCapacidad.servirCerveza(0);

		assertEquals(0.0, valor, DELTA); // 0 * precioPorMl = 0
		// La cantidadActual no debe verse afectada al servir 0
		assertEquals(200.0, maquinaSinCapacidad.getCantidadActual(), DELTA);
	}

	@Test
	void testServirCervezaVariasVecesSeguidas() {
		// Usamos llenarMaquina() (método real) para llenar casi al máximo
		maquinaConCapacidad.llenarMaquina(); // cantidadActual = capacidadMaxima - 100 = 900

		// Primer servicio
		double primerValor = maquinaConCapacidad.servirCerveza(400);
		assertEquals(20.0, primerValor, DELTA); // 400 * 0.05
		assertEquals(500.0, maquinaConCapacidad.getCantidadActual(), DELTA);

		// Segundo servicio, valida que los descuentos se acumulen correctamente
		double segundoValor = maquinaConCapacidad.servirCerveza(500);
		assertEquals(25.0, segundoValor, DELTA); // 500 * 0.05
		assertEquals(0.0, maquinaConCapacidad.getCantidadActual(), DELTA);

		// Tercer servicio, ya no hay stock disponible
		double tercerValor = maquinaConCapacidad.servirCerveza(1);
		assertEquals(0.0, tercerValor, DELTA);
		assertEquals(0.0, maquinaConCapacidad.getCantidadActual(), DELTA);
	}

	@Test
	void testServirCervezaConConstructorDeCapacidadPorDefecto() {
		// Valida el comportamiento del método usando la máquina creada
		// con el constructor de 3 parámetros (capacidadMaxima = 10000 por defecto)
		maquinaSinCapacidad.recargarCerveza(1000);

		double valor = maquinaSinCapacidad.servirCerveza(600);

		assertEquals(48.0, valor, DELTA); // 600 * 0.08
		assertEquals(400.0, maquinaSinCapacidad.getCantidadActual(), DELTA);
		// Se confirma que la capacidadMaxima por defecto sigue siendo 10000
		assertEquals(10000.0, maquinaSinCapacidad.getCapacidadMaxima(), DELTA);
	}
}