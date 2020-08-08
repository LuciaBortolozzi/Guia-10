package model.DAO;

import model.Personas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class PersonasTXT {

    private static final String directorio = "C:\\\\Users\\\\Flor\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\";
//    private static final String directorio = "D:\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";

    public static TreeSet<Personas> bajarPersonasTXT() {

        TreeSet<Personas> personas = new TreeSet<Personas>();
        try {
            File archivo = new File( directorio + "Personas.txt");
            if (archivo.exists()){
                Scanner leerArchivoPersonas = new Scanner(archivo);
                ArrayList<String> personasST = new ArrayList<String>();

                //Guardar contenido en String
                while (leerArchivoPersonas.hasNext()) {
                    String lineaActual = leerArchivoPersonas.nextLine();
                    personasST.add(lineaActual);
                }

                // Guardar objetos
                for (String s : personasST) {

                    String[] personaST = s.split("\t");

                    String nombre = personaST[0].toUpperCase();
                    String apellido = personaST[1].toUpperCase();
                    char sexo = personaST[2].toUpperCase().charAt(0);

                    personas.add(new Personas());
                }

                leerArchivoPersonas.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return personas;
    }
}
