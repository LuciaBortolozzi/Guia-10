package model;

import java.util.ArrayList;

public class Localidades {
    private String nombreLoc;
    private String codigoPostal;
    private Provincias provincia;

    public Localidades() {
    }

    public Localidades(String nombreLoc, String codigoPostal, Provincias provincia) {
        this.nombreLoc = nombreLoc;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
    }

    public String getNombreLoc() {
        return nombreLoc;
    }

    public void setNombreLoc(String nombreLoc) {
        this.nombreLoc = nombreLoc;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Provincias getProvincia() { return provincia; }

    public void setProvincia(Provincias provincia) { this.provincia = provincia; }
}
