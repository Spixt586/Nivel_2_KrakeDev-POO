package com.krakedev.artesanal.testJUnit;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Suite de pruebas para NegocioMejorado.agregarMaquina(String, String, double).
 *
 * Esta versión del método ya no solo agrega: primero genera un código,
 * revisa con recuperarMaquina() si ese código ya existe, y solo agrega
 * la máquina (retornando true) si NO existe. Si ya existe, retorna
 * false y no modifica la lista.
 *
 * Como generarCodigo() es aleatorio y no se puede controlar sin mockear
 * Math.random(), la prueba del caso "código duplicado" se logra llenando
 * la lista con TODOS los códigos posibles (M-1 a M-100). Así, sin importar
 * qué número aleatorio salga, siempre va a coincidir con uno ya existente
 * y el método está obligado a retornar false de forma determinista.
 */
class TestAgregarMaquinaJUnit {

    @Test
    @DisplayName("Con la lista vacía, debe retornar true y agregar la máquina")
    void agregarMaquina_conListaVacia_debeRetornarTrueYAgregarLaMaquina() {
        NegocioMejorado negocio = new NegocioMejorado();

        boolean resultado = negocio.agregarMaquina("IPA Artesanal", "Cerveza amarga", 0.05);

        assertTrue(resultado, "Se esperaba que la máquina se agregara correctamente");
        assertEquals(1, negocio.getMaquinas().size(), "La lista debería tener exactamente una máquina");
    }

    @Test
    @DisplayName("Debe guardar correctamente los datos de la máquina agregada")
    void agregarMaquina_debeGuardarLosDatosCorrectamente() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("IPA Artesanal", "Cerveza amarga", 0.05);
        Maquina agregada = negocio.getMaquinas().get(0);

        assertEquals("IPA Artesanal", agregada.getNombreCerveza(), "El nombre de la cerveza no coincide");
        assertEquals("Cerveza amarga", agregada.getDescripcion(), "La descripción no coincide");
        assertEquals(0.05, agregada.getPrecioPorMl(), "El precio por ml no coincide");
    }

    @Test
    @DisplayName("El código asignado a la máquina agregada debe tener el formato M-<entero>")
    void agregarMaquina_codigoGenerado_debeTenerFormatoValido() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("IPA Artesanal", "Cerveza amarga", 0.05);
        String codigo = negocio.getMaquinas().get(0).getCodigo();

        assertTrue(codigo.matches("M-\\d+"),
                "El código asignado no cumple el formato 'M-<número entero>': " + codigo);
    }

    @Test
    @DisplayName("Si el código generado ya existe en la lista, debe retornar false y no agregar")
    void agregarMaquina_conCodigoYaExistente_debeRetornarFalseYNoAgregar() {
        NegocioMejorado negocio = new NegocioMejorado();

        // Se ocupan TODOS los códigos posibles (M-1 a M-100), así el código
        // aleatorio que genere agregarMaquina() siempre va a colisionar.
        ArrayList<Maquina> maquinas = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            maquinas.add(new Maquina("Cerveza " + i, "M-" + i, "Descripción " + i, 0.01));
        }
        negocio.setMaquinas(maquinas);

        boolean resultado = negocio.agregarMaquina("IPA Artesanal", "Cerveza amarga", 0.05);

        assertFalse(resultado, "No debería poder agregar una máquina con un código ya existente");
        assertEquals(100, negocio.getMaquinas().size(),
                "La lista no debería haberse modificado cuando el código ya existía");
    }
}