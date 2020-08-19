package controller;

import model.DAO.PersonasTXT;
import model.Personas;

import javax.swing.*;
import java.util.Iterator;
import java.util.TreeSet;

import static controller.Controlador.personas;
import static controller.Controlador.personasAux;

public class PersonasControlador {

    public static Personas buscarPersona(int dniPersona) {

        Personas persona;
        Iterator<Personas> iteratorPersonas = personasAux.iterator();
        while (iteratorPersonas.hasNext()) {
            persona = iteratorPersonas.next();

            if (persona.getDni() == dniPersona) {
                return persona;
            }
        }
        return null;
    }

    /*public static void agregarPersona(TreeSet<Personas> personas, Personas persona){

        if(!personaEncontrada(personas, persona)){

            personas.add(persona);
            PersonasTXT.grabarPersonasTXT(personas);

        }else{

            // Esto tiene que ser con excepcion propia y una vez que analiza el dni

            JOptionPane.showMessageDialog(null, "No se puede ingresar la persona, la misma ya se encuentra ingresada");
        }
    }*/

    public static boolean personaEncontrada(Personas persona){

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

    public static void modificarPersona(Personas persona){
        //PROBAR SI ESTO FUNCIONA BIEN
        if(personaEncontrada(persona)){

            Personas personaAux = null;
            Iterator<Personas> per = personas.iterator();
            while (per.hasNext()) {
                personaAux = per.next();

                if (personaAux.getDni() == persona.getDni()) {

                    personaAux.setNombre(persona.getNombre());
                    personaAux.setApellido(persona.getApellido());
                    personaAux.setTipoSangre(persona.getTipoSangre());
                    personaAux.setLocalidad(persona.getLocalidad());
                    personaAux.setSexo(persona.getSexo());

                    // Verificar si cambia de paciente a donador o viceversa

                    break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede modificar la persona, la misma no se encuentra ingresada");
        }
    }

}
