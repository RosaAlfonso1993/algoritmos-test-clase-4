package com.example.clase4.agenda;

import com.example.clase4.exceptions.ContactError;
import com.example.clase4.shopping.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class AgendaTest extends Agenda {

    @Test
    @DisplayName("Tests happy path add")
    public void testHappyPathAdd() {
        Agenda.nuevoContacto("Laura", 1131391999);

        assertTrue(miAgenda().contains(1131391999));
    }

    @Test
    @DisplayName("Tests happy path modify")
    public void testHappyPathModify() {
        Agenda.nuevoContacto("Laura", 1131391999);
        Agenda.modificarTelefono("Laura", 1131391998);

        assertTrue(miAgenda().contains(1131391998));
    }

    @Test
    @DisplayName("Tests happy path show value")
    public void testHappyPathShowValue() {
        Agenda.nuevoContacto("Laura", 1131391999);
        Integer telefono = Agenda.obtenerTelefono("Laura");

        assertEquals(1131391999, telefono);
    }

    @Test
    @DisplayName("Tests happy path eliminated true")
    public void testHappyPathEliminatedTrue() {
        Agenda.nuevoContacto("Laura", 1131391999);
        Boolean eliminado = Agenda.eliminarTelefono("Laura");

        assertTrue(eliminado);
    }
/*
    @Test
    @DisplayName("Tests happy path eliminated false")
    public void testHappyPathEliminatedFalse() {
        Agenda.nuevoContacto("Laura", 1131391999);
        Boolean eliminado = Agenda.eliminarTelefono("Barbara");

        assertFalse(eliminado);
    }

    Como devuelve una excepcion no llega a devolver el valor
    solo se cortas
 */

    @Test
    @DisplayName("Tests happy path collection of telephones")
    public void testHappyPathCollectionOfTelephones() {
        Agenda.nuevoContacto("Laura", 1131391999);
        List<Integer> listaTelefonos = Agenda.miAgenda();

        assertTrue(listaTelefonos.contains(1131391999));
    }
}
