package controller;

import model.DAO.PersonasTXT;
import model.Personas;

import javax.swing.*;
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

    public static void agregarPersona(TreeSet<Personas> personas, Personas persona){

        if(!personaEncontrada(personas, persona)){

            personas.add(persona);
            PersonasTXT.grabarPersonasTXT(personas);

        }else{

            JOptionPane.showMessageDialog(null, "No se puede ingresar la persona, la misma ya se encuentra ingresada");
        }
    }

    public static boolean personaEncontrada(TreeSet<Personas> personas, Personas persona){

        boolean personaEncontrada = false;
        Personas personaAux = null;

        Iterator<Personas> per = personas.iterator();
        while (per.hasNext()) {
            personaAux = per.next();

            if (personaAux.getDni() == persona.getDni()) {
                personaEncontrada = true;
                break;
            }
        }
        return personaEncontrada;
    }

    public static void modificarPersona(TreeSet<Personas> personas, Personas persona){
        //PROBAR SI ESTO FUNCIONA BIEN
        if(personaEncontrada(personas, persona)){

            Personas personaAux = null;

            Iterator<Personas> per = personas.iterator();
            while (per.hasNext()) {
                personaAux = per.next();

                if (personaAux.getDni() == persona.getDni()) {

                    personaAux = persona;
                    break;
                }
            }

        }else{

            JOptionPane.showMessageDialog(null, "No se puede modificar la persona, la misma no se encuentra ingresada");
        }
    }

}
