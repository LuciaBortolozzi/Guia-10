package model;

import java.util.TreeSet;

public class Provincias {

    private String nombreProv;
    private int idProvincia;

    public Provincias() {
    }

    public Provincias(String nombreProv, int idProvincia) {
        this.nombreProv = nombreProv;
        this.idProvincia = idProvincia;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public int getIdProvincia() { return idProvincia; }

    public void setIdProvincia(int idProvincia) { this.idProvincia = idProvincia; }
}
