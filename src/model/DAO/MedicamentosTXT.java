package model.DAO;

import controller.Controlador;
import controller.PersonasControlador;
import model.Donadores;
import model.Medicamentos;
import model.Pacientes;
import model.Personas;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MedicamentosTXT {

          private static final String directorio = "C:\\\\Users\\\\Flor\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";
    //      private static final String directorio = "D:\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";

    public static ArrayList<Medicamentos> bajarMedicamentosTXT() {

        ArrayList<Medicamentos> medicamentos = new ArrayList<Medicamentos>();
        try {
            File archivo = new File(directorio + "Medicamentos.txt");
            if (archivo.exists()) {
                Scanner leerArchivoMedicamentos = new Scanner(archivo);
                ArrayList<String> medicamentosST = new ArrayList<String>();

                //Guardar contenido en String
                while (leerArchivoMedicamentos.hasNext()) {
                    String lineaActual = leerArchivoMedicamentos.nextLine();
                    medicamentosST.add(lineaActual);
                }

                // Guardar objetos
                for (String s : medicamentosST) {

                    int idMed = Integer.parseInt(s.substring(0, 10).trim());
                    String nombreMed = s.substring(10, 58).trim();
                    String nombreLab = s.substring(58, 83).trim();

                    medicamentos.add(new Medicamentos(idMed, nombreMed, nombreLab));
                }

                leerArchivoMedicamentos.close();
            }

        } catch (InputMismatchException | IOException e) {
            e.printStackTrace();
        }

        return medicamentos;
    }


    public static TreeSet<Personas> bajarPacientesMedicamentosTXT(TreeSet<Personas> personasTXT, ArrayList<Medicamentos> medicamentosTXT) {

        ArrayList<Medicamentos> medicamentos = new ArrayList<Medicamentos>();

        try {
            File archivo = new File(directorio + "PacientesMedicamentos.txt");
            if (archivo.exists()) {
                Scanner leerArchivoMedicamentos = new Scanner(archivo);
                ArrayList<String> medicamentosST = new ArrayList<String>();

                while (leerArchivoMedicamentos.hasNext()) {
                    String lineaActual = leerArchivoMedicamentos.nextLine();
                    medicamentosST.add(lineaActual);
                }

                boolean primeraVez = true;
                int documento = 0;
                Personas persona = null;
                Medicamentos medicamento;

                for (String s : medicamentosST) {

                    int dniPaciente = Integer.parseInt(s.substring(0, 8).trim());
                    int idMed = Integer.parseInt(s.substring(8, 18).trim());

                    if (primeraVez) {
                        persona = PersonasControlador.buscarPersona(dniPaciente);
                        documento = dniPaciente;
                        primeraVez = false;
                    }

                    if (persona instanceof Pacientes) {
                        if (documento == dniPaciente) {

                            medicamento = Controlador.agregarMedicamentos(medicamentosTXT, idMed);

                            if (medicamento != null) {
                                medicamentos.add(medicamento);
                            }

                        } else {

                            ((Pacientes) persona).setMedicamentos(medicamentos);
                            medicamentos.clear();
                            persona = PersonasControlador.buscarPersona(dniPaciente);

                            if (persona instanceof Pacientes) {

                                documento = dniPaciente;

                                medicamento = Controlador.agregarMedicamentos(medicamentosTXT, idMed);

                                if (medicamento != null) {

                                    medicamentos.add(medicamento);
                                }
                            }
                        }
                    }
                }

                if (persona instanceof Pacientes) {
                    ((Pacientes) persona).setMedicamentos(medicamentos);
                }

                leerArchivoMedicamentos.close();
            }

        } catch (InputMismatchException | IOException e) {
            e.printStackTrace();
        }

        return personasTXT;
    }

    public static void grabarPacientesPedicamentosTXT(TreeSet<Personas> personasTXT){

        try {
            File fichero = new File(directorio + "PacientesMedicamentos.txt");

            if (fichero.exists()) {
                PrintWriter archivoSalida = new PrintWriter(fichero);

                Personas persona;
                Iterator<Personas> per = personasTXT.iterator();
                while (per.hasNext()) {
                    persona = per.next();

                    if(persona instanceof Pacientes){

                        for(Medicamentos med : ((Pacientes)persona).getMedicamentos()){

                            archivoSalida.println(persona.getDni() + "" + String.format("%010d",med.getIdMed()));
                        }
                    }
                }
                archivoSalida.close();
            }

        } catch (IOException e) {
            System.out.println("No se puede grabar el archivo de PacientesMedicamentos.txt");
        }
    }

}