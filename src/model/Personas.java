package model;

import java.util.Calendar;

public class Personas {
    protected String nombre;
    protected String apellido;
    protected long dni;
    protected Provincias provincia;
    protected Calendar fechaNac;
    protected char sexo;
    protected TiposSangre tipoSangre;
    protected Hospital hospital;

    public Personas() {
    }

    public Personas(String nombre, String apellido, long dni, Provincias provincia, Calendar fechaNac, char sexo, TiposSangre tipoSangre, Hospital hospital) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.provincia = provincia;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.tipoSangre = tipoSangre;
        this.hospital = hospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }

    public Calendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Calendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public TiposSangre getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(TiposSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
