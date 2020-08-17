package controller;

import model.Personas;

import java.util.Iterator;
import java.util.TreeSet;

public class PersonasControlador {

    public static Personas buscarPersonas(int dniPersona, TreeSet<Personas> personas) {

        Personas persona;
        Iterator<Personas> iteratorPersonas = personas.iterator();
        while (iteratorPersonas.hasNext()) {
            persona = iteratorPersonas.next();

            if (persona.getDni() == dniPersona) {
                return persona;
            }
        }
        return null;
    }
}
