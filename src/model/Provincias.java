package model;

public class Provincias {
    private String nombreProv;
    private Localidades localidad;

    public Provincias() {
    }

    public Provincias(String nombreProv, Localidades localidad) {
        this.nombreProv = nombreProv;
        this.localidad = localidad;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public Localidades getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidades localidad) {
        this.localidad = localidad;
    }
}
