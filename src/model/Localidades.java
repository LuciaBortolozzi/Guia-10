package model;

public class Localidades {
    private String nombreLoc;
    private int codigoPostal;

    public Localidades() {
    }

    public Localidades(String nombreLoc, int codigoPostal) {
        this.nombreLoc = nombreLoc;
        this.codigoPostal = codigoPostal;
    }

    public String getNombreLoc() {
        return nombreLoc;
    }

    public void setNombreLoc(String nombreLoc) {
        this.nombreLoc = nombreLoc;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
