package model.DAO;

import model.Hospitales;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalesTXT {

    private static final String directorio = "C:\\\\Users\\\\Flor\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";
//    private static final String directorio = "D:\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";

    public static ArrayList<Hospitales> bajarHospitalesTXT() {

        ArrayList<Hospitales> hospitales = new ArrayList<Hospitales>();
        try {
            File archivo = new File( directorio + "Hospitales.txt");
            if (archivo.exists()){
                Scanner leerArchivoHospitales = new Scanner(archivo);
                ArrayList<String> HospitalesST = new ArrayList<String>();

                //Guardar contenido en String
                while (leerArchivoHospitales.hasNext()) {
                    String lineaActual = leerArchivoHospitales.nextLine();
                    HospitalesST.add(lineaActual);
                }

                // Guardar objetos
                for (String s : HospitalesST) {

                    int idHospital = Integer.parseInt(s.substring(0,5).trim());
                    String nombre = s.substring(5,33).trim();
                    String direccion = s.substring(33,58).trim();

                    hospitales.add(new Hospitales(idHospital, nombre,direccion));
                }

                leerArchivoHospitales.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return hospitales;
    }
}
