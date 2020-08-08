package model.DAO;

import model.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static controller.Validaciones.convertirAFechaCalendar;

public class PersonasTXT {

//    private static final String directorio = "C:\\\\Users\\\\Flor\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";
    private static final String directorio = "D:\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";

    public static TreeSet<Personas> bajarPersonasTXT(ArrayList<Localidades> localidades, ArrayList<TiposSangre> tiposSangre, ArrayList<Hospitales> hospitales) {

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

                    int tipo = Integer.parseInt(personaST[0].trim());
                    Calendar fechaSist = convertirAFechaCalendar(personaST[1].trim());
                    String nombre = personaST[2].toUpperCase().trim();
                    String apellido = personaST[3].toUpperCase().trim();
                    long dni = Long.parseLong(personaST[4].trim());
                    Localidades localidad = agregarLocalidad(localidades, personaST[5].toUpperCase().trim());
                    Calendar fechaNac = convertirAFechaCalendar(personaST[6].trim());
                    char sexo = personaST[7].toUpperCase().trim().charAt(0);
                    TiposSangre tipoSangre = agregarTipoSangre(tiposSangre, Integer.parseInt(personaST[8].trim()));

                    if (tipo == 1) {
                        String enfermedad = personaST[9].toUpperCase().trim();
                        Hospitales hospital = agregarHospital(hospitales, Integer.parseInt(personaST[10].trim()));
                        Calendar inicioTratamiento = convertirAFechaCalendar(personaST[11].trim());

                        personas.add(new Pacientes(nombre, apellido, dni, localidad, fechaNac, sexo, tipoSangre, enfermedad, hospital, inicioTratamiento));

                    } else if (tipo == 2) {
                        boolean donaSangre = Boolean.parseBoolean(personaST[9].trim());
                        boolean donaPlaquetas = Boolean.parseBoolean(personaST[10].trim());
                        boolean donaPlasma = Boolean.parseBoolean(personaST[11].trim());

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

    public static Localidades agregarLocalidad(ArrayList<Localidades> localidades, String localidadST) {

        Localidades localidad = null;

        Iterator<Localidades> loc = localidades.iterator();
        while (loc.hasNext()) {
            localidad = loc.next();

            if (localidad.getNombreLoc().equals(localidadST)) {
                break;
            }
        }
        return localidad;
    }

    public static TiposSangre agregarTipoSangre(ArrayList<TiposSangre> tiposSangres, int tipoDeSangre) {

        TiposSangre tipoSangre = null;

        Iterator<TiposSangre> tipoSang = tiposSangres.iterator();
        while (tipoSang.hasNext()) {
            tipoSangre = tipoSang.next();

            if (tipoSangre.getId() == tipoDeSangre) {
                break;
            }
        }
        return tipoSangre;
    }

    public static Hospitales agregarHospital(ArrayList<Hospitales> hospitales, int idHospital) {

        Hospitales hospital = null;

        Iterator<Hospitales> hosp = hospitales.iterator();
        while (hosp.hasNext()) {
            hospital = hosp.next();

            if (hospital.getIdHospital() == idHospital) {
                break;
            }
        }
        return hospital;
    }
}
