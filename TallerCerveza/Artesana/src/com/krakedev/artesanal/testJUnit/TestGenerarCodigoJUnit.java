package com.krakedev.artesanal.testJUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Suite de pruebas para NegocioMejorado.generarCodigo().
 *
 * Importante: esta suite prueba EXCLUSIVAMENTE generarCodigo().
 * No se invoca ni se cubre agregarMaquina() en ningún caso.
 *
 * No se usa Mockito ni MockedStatic: como Math.random() no se puede
 * controlar aquí, las pruebas verifican las propiedades que SIEMPRE
 * deben cumplirse en el resultado (formato y rango), en lugar de un
 * valor exacto. El @RepeatedTest compensa la aleatoriedad, ejecutando
 * la verificación muchas veces para dar mayor confianza sobre los
 * límites del rango.
 */
class TestGenerarCodigoJUnit {

    private final NegocioMejorado negocio = new NegocioMejorado();

    @Test
    @DisplayName("El código generado no debe estar vacío")
    void generarCodigo_noDebeEstarVacio() {
        String resultado = negocio.generarCodigo();
        assertFalse(resultado.isBlank(), "El código no debería estar vacío");
    }

    @Test
    @DisplayName("El código debe iniciar con el prefijo 'M-'")
    void generarCodigo_debeIniciarConPrefijo() {
        String resultado = negocio.generarCodigo();
        assertTrue(resultado.startsWith("M-"),
                "Se esperaba que el código iniciara con 'M-', pero fue: " + resultado);
    }

    @Test
    @DisplayName("El código debe cumplir el formato M-<entero>")
    void generarCodigo_debeCumplirFormatoEsperado() {
        String resultado = negocio.generarCodigo();
        assertTrue(resultado.matches("M-\\d+"),
                "El código no cumple el formato 'M-<número entero>': " + resultado);
    }

    @RepeatedTest(50)
    @DisplayName("El número generado siempre debe estar en el rango [1, 100]")
    void generarCodigo_numeroDentroDelRangoValido() {
        String resultado = negocio.generarCodigo();
        int numero = Integer.parseInt(resultado.substring(2)); // quita "M-"
        assertTrue(numero >= 1, "El número " + numero + " es menor al mínimo esperado (1)");
        assertTrue(numero <= 100, "El número " + numero + " es mayor al máximo esperado (100)");
    }

    @Test
    @DisplayName("El prefijo 'M-' siempre debe medir exactamente 2 caracteres")
    void generarCodigo_prefijoDebeMedirDosCaracteres() {
        String resultado = negocio.generarCodigo();
        String prefijo = resultado.substring(0, 2);
        assertEquals("M-", prefijo, "El prefijo extraído no coincide con 'M-'");
    }
}