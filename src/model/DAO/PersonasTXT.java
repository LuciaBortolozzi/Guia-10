package model.DAO;

import model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static controller.Validaciones.convertirAFechaCalendar;

public class PersonasTXT {

    //    private static final String directorio = "C:\\\\Users\\\\Flor\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";
    private static final String directorio = "D:\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";

    public static TreeSet<Personas> bajarPersonasTXT(ArrayList<Localidades> localidades, ArrayList<TiposSangre> tiposSangre) {

        TreeSet<Personas> personas = new TreeSet<Personas>();
        try {
            File archivo = new File(directorio + "Personas.txt");
            if (archivo.exists()) {
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
                    int dni = Integer.parseInt(personaST[4].trim());
                    String provincia = personaST[6].trim();
                    Localidades localidad = agregarLocalidad(localidades, personaST[5].toUpperCase().trim(), Integer.parseInt(provincia));
                    Calendar fechaNac = convertirAFechaCalendar(personaST[7].trim());
                    char sexo = personaST[8].toUpperCase().trim().charAt(0);
                    TiposSangre tipoSangre = agregarTipoSangre(tiposSangre, Integer.parseInt(personaST[9].trim()));

                    if (tipo == 1) {
                        String enfermedad = personaST[10].toUpperCase().trim();

                        ArrayList<Medicamentos> meds = new ArrayList<Medicamentos>();

                        //agregarMedicamentos(medicamentos, Integer.parseInt(personaST[10].trim()));

                        Calendar inicioTratamiento = convertirAFechaCalendar(personaST[11].trim());

                        personas.add(new Pacientes(nombre, apellido, dni, localidad, fechaNac, sexo, tipoSangre, enfermedad, meds, inicioTratamiento));

                    } else if (tipo == 2) {
                        boolean donaSangre = Boolean.parseBoolean(personaST[10].trim());
                        boolean donaPlaquetas = Boolean.parseBoolean(personaST[11].trim());
                        boolean donaPlasma = Boolean.parseBoolean(personaST[12].trim());

                        personas.add(new Donadores(nombre, apellido, dni, localidad, fechaNac, sexo, tipoSangre, donaSangre, donaPlaquetas, donaPlasma));

                    }/* else {
                        personas.add(new Personas(nombre, apellido, dni, localidad, fechaNac, sexo, tipoSangre));
                    }*/

                }

                leerArchivoPersonas.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return personas;
    }

    public static Localidades agregarLocalidad(ArrayList<Localidades> localidades, String localidadST, int provincia) {

        Localidades localidad = null;

        Iterator<Localidades> loc = localidades.iterator();
        while (loc.hasNext()) {
            localidad = loc.next();

            if (localidad.getNombreLoc().equals(localidadST) && localidad.getProvincia().getIdProvincia() == provincia) {
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

    public static void grabarPersonasTXT(Personas persona) {

        try {
            FileWriter fichero = new FileWriter(directorio + "Personas.txt", true);
            Calendar fecha = Calendar.getInstance();

            PrintWriter archivoSalida = new PrintWriter(fichero);

            if (persona instanceof Pacientes) {
                archivoSalida.println("1" + ";" +
                        String.format("%02d", fecha.get(Calendar.DAY_OF_MONTH)) + "/" +
                        String.format("%02d",(fecha.get(Calendar.MONTH) + 1)) + "/" +
                        fecha.get(Calendar.YEAR) + ";" +
                        persona.getNombre() + ";" +
                        persona.getApellido() + ";" +
                        persona.getDni() + ";" +
                        persona.getLocalidad().getNombreLoc() + ";" +
                        String.format("%02d",persona.getLocalidad().getProvincia().getIdProvincia()) + ";" +
                        String.format("%02d",persona.getFechaNac().get(Calendar.DAY_OF_MONTH)) + "/" +
                        String.format("%02d",(persona.getFechaNac().get(Calendar.MONTH) + 1)) + "/" +
                        persona.getFechaNac().get(Calendar.YEAR) + ";" +
                        persona.getSexo() + ";" +
                        persona.getTipoSangre().getId() + ";" +
                        ((Pacientes) persona).getEnfermedad() + ";" +
                        //Medicamentos.txt
                        String.format("%02d",((Pacientes) persona).getInicioTratamiento().get(Calendar.DAY_OF_MONTH)) + "/" +
                        String.format("%02d",(((Pacientes) persona).getInicioTratamiento().get(Calendar.MONTH) + 1)) + "/" +
                        ((Pacientes) persona).getInicioTratamiento().get(Calendar.YEAR)
                );
            } else if (persona instanceof Donadores) {
                archivoSalida.println("2" + ";" +
                        String.format("%02d", fecha.get(Calendar.DAY_OF_MONTH)) + "/" +
                        String.format("%02d",(fecha.get(Calendar.MONTH) + 1)) + "/" +
                        fecha.get(Calendar.YEAR) + ";" +
                        persona.getNombre() + ";" +
                        persona.getApellido() + ";" +
                        persona.getDni() + ";" +
                        persona.getLocalidad().getNombreLoc() + ";" +
                        String.format("%02d",persona.getLocalidad().getProvincia().getIdProvincia()) + ";" +
                        String.format("%02d",persona.getFechaNac().get(Calendar.DAY_OF_MONTH)) + "/" +
                        String.format("%02d",(persona.getFechaNac().get(Calendar.MONTH) + 1)) + "/" +
                        persona.getFechaNac().get(Calendar.YEAR) + ";" +
                        persona.getSexo() + ";" +
                        persona.getTipoSangre().getId() + ";" +
                        ((Donadores) persona).isDonaSangre() + ";" +
                        ((Donadores) persona).isDonaPlaquetas() + ";" +
                        ((Donadores) persona).isDonaPlasma()
                );
            }

            archivoSalida.close();

        } catch (IOException e3) {
            System.out.println("No se puede grabar el archivo de Personas.txt");
        }
    }

    public static void eliminarPersona(int dni) {
        System.out.println("Elimine persona");
    }


}
