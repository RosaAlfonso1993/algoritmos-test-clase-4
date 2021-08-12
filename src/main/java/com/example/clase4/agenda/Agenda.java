package com.example.clase4.agenda;

import com.example.clase4.exceptions.ContactError;
import com.example.clase4.shopping.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;


/*
Empelando la clase HashMap<String,Integer>() de la biblioteca de java (una
implementación de tablas hash con un string (nombre) de clave y un entero (telefono) de valor)

1) crear un nuevo contacto
2) modificar un telefono, si el telefono no existe devolver excepcion
3) obtener un telefono, si el telefono no existe devolver excepcion
4) eliminar un telefono, si el telefono no existe devolver excepcion
5) devolver telefonos

 */
public class Agenda {


    private static HashMap<String, Integer> miAgenda =
            new HashMap<>();

    public static void nuevoContacto(String nombre, int telefono) {
        miAgenda.put(nombre,telefono);
    }

    public static void modificarTelefono(String nombre, int telefono) {
         if (miAgenda.containsKey(nombre)) miAgenda.put(nombre,telefono);
    }

    public static Integer obtenerTelefono(String nombre) {
        Integer tel =  miAgenda.get(nombre);
        if(!Objects.nonNull(tel)){
            throw new ContactError("El contacto no existe");
        }
        return tel;
    }

    public static boolean eliminarTelefono(String nombre) {
        if(!miAgenda.containsKey(nombre)){
            throw new ContactError("El contacto no existe");

        }
        miAgenda.remove(nombre);
        return !miAgenda.containsKey(nombre);
    }

    protected static List<Integer> miAgenda() {
        return miAgenda.values().stream().collect(Collectors.toList());
    }


}
