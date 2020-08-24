package model.DAO;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.*;
import java.io.FileOutputStream;

public class EstadisticasJson {

    private static final String directorio = "C:\\\\Users\\\\Flor\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";
    //private static final String directorio = "D:\\\\IdeaProjects\\\\Guia-10\\\\src\\\\resources\\\\";

    public static void grabarJsonStream() {

        try {

            File aJson = new File(directorio + "RecomendacionesSeriesJovenes.json");
            FileOutputStream fsOutJson = new FileOutputStream(aJson);
            JsonGenerator genJson = Json.createGenerator(fsOutJson);

            genJson.writeStartObject(); //objeto inicial

            {
                genJson.write("documento", "35645780");
                genJson.write("edad", "29");
                genJson.writeStartObject("domicilio");
                genJson.write("calle", "Villa Maria GC 2570");
                genJson.write("localidad", "Manuel Alberti");
                genJson.write("codigoPostal", "1604");
                genJson.writeEnd();

                /*
                genJson.writeStartArray("telefonos");
                for(Telefonos tel : otraPers.getTelefonos())
                {
                    if (tel.getTipo()!=null)
                    {
                        genJson.writeStartObject();
                        genJson.write("tipo", tel.getTipo());
                        genJson.write("numero", tel.getNumero());
                        genJson.writeEnd();
                    }
                }

                genJson.writeEnd();


                genJson.writeStartArray("deportes");

                for(String dep : otraPers.getDeportes())
                {
                    if (dep!=null) objJsonGen.write(dep);

                }

                genJson.writeEnd();

                genJson.write("estudia", true));


                genJson.writeStartArray("salarios");
                for(double sal : otraPers.getSalarios())
                {
                    if (sal!=0) genJson.write(sal);

                }
                genJson.writeEnd();
                */
                genJson.writeEnd();
            }

            genJson.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
