package model.DAO;

import model.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static controller.Validaciones.convertirAFechaCalendar;

public class PersonasTXT {

//    private static final String directorio = "C:\\\\Users\\\\Flor\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";
    private static final String directorio = "D:\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";

    public static TreeSet<Personas> bajarPersonasTXT(ArrayList<Localidades> localidades, ArrayList<Hospitales> hospitales, ArrayList<TiposSangre> tiposSangre) {

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

                    String[] personaST = s.split(";");

                    int tipo = Integer.parseInt(personaST[0]);
                    Calendar fechaSist = convertirAFechaCalendar(personaST[1]);
                    String nombre = personaST[2].toUpperCase();
                    String apellido = personaST[3].toUpperCase();
                    long dni = Long.parseLong(personaST[4]);
                    String localidadST = personaST[5].toUpperCase();
                    Calendar fechaNac = convertirAFechaCalendar(personaST[6]);
                    char sexo = personaST[7].toUpperCase().charAt(0);
                    int tipoDeSangre = Integer.parseInt(personaST[8]);

                    // Agregar localidad
                    Localidades localidad = null;
                    for (Localidades loc : localidades) {
                        localidad = loc;
                        if (localidad.getNombreLoc().equals(localidadST)) {
                            break;
                        }
                    }

                    // Agregar tipoSangre
                    TiposSangre tipoSangre = null;
                    for (TiposSangre tipoSang : tiposSangre) {
                        tipoSangre = tipoSang;
                        if (tipoSangre.getId() == tipoDeSangre) {
                            break;
                        }
                    }

                    if (tipo == 1) {
                        String enfermedad = personaST[9].toUpperCase();
                        int idHospital = Integer.parseInt(personaST[10]);
                        Calendar inicioTratamiento = convertirAFechaCalendar(personaST[11]);

                        // Agregar hospital
                        Hospitales hospital = null;
                        for (Hospitales hosp : hospitales) {
                            hospital = hosp;
                            if (hospital.getIdHospital() == idHospital) {
                                break;
                            }
                        }

                        personas.add(new Pacientes(nombre, apellido, dni, localidad, fechaNac, sexo, tipoSangre, enfermedad, hospital, inicioTratamiento));

                    } else if (tipo == 2) {
                        boolean donaSangre = Boolean.parseBoolean(personaST[9]);
                        boolean donaPlaquetas = Boolean.parseBoolean(personaST[10]);
                        boolean donaPlasma = Boolean.parseBoolean(personaST[11]);

                        personas.add(new Donadores(nombre, apellido, dni, localidad, fechaNac, sexo, tipoSangre, donaSangre, donaPlaquetas, donaPlasma));

                    } else {
                        personas.add(new Personas(nombre, apellido, dni, localidad, fechaNac, sexo, tipoSangre));
                    }

                }

                leerArchivoPersonas.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return personas;
    }

}
