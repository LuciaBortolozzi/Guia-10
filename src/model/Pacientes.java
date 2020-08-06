package model;

import java.util.Calendar;

public class Pacientes extends Personas {
    private String enfermedad;

    public Pacientes() {
    }

    public Pacientes(String nombre, String apellido, long dni, Provincias provincia, Calendar fechaNac, char sexo, TiposSangre tipoSangre, Hospital hospital) {
        super(nombre, apellido, dni, provincia, fechaNac, sexo, tipoSangre, hospital);
    }

    public Pacientes(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Pacientes(String nombre, String apellido, long dni, Provincias provincia, Calendar fechaNac, char sexo, TiposSangre tipoSangre, Hospital hospital, String enfermedad) {
        super(nombre, apellido, dni, provincia, fechaNac, sexo, tipoSangre, hospital);
        this.enfermedad = enfermedad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
}
