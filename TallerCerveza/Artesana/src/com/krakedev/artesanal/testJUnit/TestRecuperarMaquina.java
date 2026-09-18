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
 * Suite de pruebas para NegocioMejorado.recuperarMaquina(String codigo).
 *
 * Importante: esta suite prueba EXCLUSIVAMENTE recuperarMaquina().
 * No se invoca generarCodigo() ni agregarMaquina() en ningún caso;
 * las máquinas de prueba se crean directamente y se cargan con
 * setMaquinas(), para que el código de cada una sea conocido y fijo
 * (no dependa de un valor aleatorio).
 */
class TestRecuperarMaquina {

    @Test
    @DisplayName("Debe encontrar la máquina cuando el código existe en la lista")
    void recuperarMaquina_codigoExistente_debeRetornarLaMaquina() {
        NegocioMejorado negocio = new NegocioMejorado();
        Maquina esperada = new Maquina("IPA Artesanal", "M-10", "Cerveza amarga", 0.05);

        ArrayList<Maquina> maquinas = new ArrayList<>();
        maquinas.add(esperada);
        negocio.setMaquinas(maquinas);

        Maquina resultado = negocio.recuperarMaquina("M-10");

        assertFalse(resultado == null, "Se esperaba encontrar la máquina con código M-10");
        assertEquals("M-10", resultado.getCodigo(), "El código de la máquina retornada no coincide");
    }

    @Test
    @DisplayName("Debe retornar null cuando el código no existe en la lista")
    void recuperarMaquina_codigoInexistente_debeRetornarNull() {
        NegocioMejorado negocio = new NegocioMejorado();
        Maquina m1 = new Maquina("IPA Artesanal", "M-10", "Cerveza amarga", 0.05);

        ArrayList<Maquina> maquinas = new ArrayList<>();
        maquinas.add(m1);
        negocio.setMaquinas(maquinas);

        Maquina resultado = negocio.recuperarMaquina("M-99");

        assertTrue(resultado == null, "No debería encontrar una máquina con un código inexistente");
    }

    @Test
    @DisplayName("Debe retornar null cuando la lista de máquinas está vacía")
    void recuperarMaquina_listaVacia_debeRetornarNull() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.setMaquinas(new ArrayList<>());

        Maquina resultado = negocio.recuperarMaquina("M-1");

        assertTrue(resultado == null, "Con la lista vacía no debería encontrar ninguna máquina");
    }

    @Test
    @DisplayName("Debe retornar la máquina correcta cuando hay varias en la lista")
    void recuperarMaquina_variasMaquinas_debeRetornarLaCorrecta() {
        NegocioMejorado negocio = new NegocioMejorado();
        Maquina m1 = new Maquina("IPA Artesanal", "M-1", "Cerveza amarga", 0.05);
        Maquina m2 = new Maquina("Stout Negra", "M-2", "Cerveza tostada", 0.06);
        Maquina m3 = new Maquina("Lager Clara", "M-3", "Cerveza suave", 0.04);

        ArrayList<Maquina> maquinas = new ArrayList<>();
        maquinas.add(m1);
        maquinas.add(m2);
        maquinas.add(m3);
        negocio.setMaquinas(maquinas);

        Maquina resultado = negocio.recuperarMaquina("M-2");

        assertFalse(resultado == null, "Se esperaba encontrar la máquina con código M-2");
        assertEquals("Stout Negra", resultado.getNombreCerveza(),
                "Se retornó una máquina distinta a la esperada para el código M-2");
    }

    @Test
    @DisplayName("La búsqueda debe distinguir entre mayúsculas y minúsculas")
    void recuperarMaquina_codigoConDistintaCapitalizacion_debeRetornarNull() {
        NegocioMejorado negocio = new NegocioMejorado();
        Maquina m1 = new Maquina("IPA Artesanal", "M-10", "Cerveza amarga", 0.05);

        ArrayList<Maquina> maquinas = new ArrayList<>();
        maquinas.add(m1);
        negocio.setMaquinas(maquinas);

        Maquina resultado = negocio.recuperarMaquina("m-10");

        assertTrue(resultado == null,
                "equals() es sensible a mayúsculas/minúsculas; 'm-10' no debería coincidir con 'M-10'");
    }
}