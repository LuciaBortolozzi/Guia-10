package model.DAO;

import model.TiposSangre;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TiposSangreTXT {

    private static final String directorio = "C:\\\\Users\\\\Flor\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\";

    public static ArrayList<TiposSangre> bajarTiposSangreTXT() {

        ArrayList<TiposSangre> tiposSangre = new ArrayList<>();
        try {
            File archivo = new File( directorio + "TiposSangre.txt");
            if (archivo.exists()){
                Scanner leerArchivoTiposSangre = new Scanner(archivo);
                ArrayList<String> TiposSangreST = new ArrayList<>();

                //Guardar contenido en String
                while (leerArchivoTiposSangre.hasNext()) {
                    String lineaActual = leerArchivoTiposSangre.nextLine();
                    TiposSangreST.add(lineaActual);
                }

                // Guardar objetos
                for (String s : TiposSangreST) {

                    String grupo = s.substring(0,2);
                    String factor = s.substring(2,10);

                    tiposSangre.add(new TiposSangre(grupo,factor));
                }

                leerArchivoTiposSangre.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return tiposSangre;
    }
}
