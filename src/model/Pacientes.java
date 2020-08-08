package model;

import java.util.Calendar;

public class Pacientes extends Personas {
    private String enfermedad;
    private Hospital hospital;
    private Calendar inicioTratamiento;

    public Pacientes(String enfermedad, Hospital hospital, Calendar inicioTratamiento) {
        this.enfermedad = enfermedad;
        this.hospital = hospital;
        this.inicioTratamiento = inicioTratamiento;
    }

    public Pacientes(String nombre, String apellido, long dni, Localidades localidad, Calendar fechaNac, char sexo, TiposSangre tipoSangre, String enfermedad, Hospital hospital, Calendar inicioTratamiento) {
        super(nombre, apellido, dni, localidad, fechaNac, sexo, tipoSangre);
        this.enfermedad = enfermedad;
        this.hospital = hospital;
        this.inicioTratamiento = inicioTratamiento;
    }

    public Calendar getInicioTratamiento() {
        return inicioTratamiento;
    }

    public void setInicioTratamiento(Calendar inicioTratamiento) {
        this.inicioTratamiento = inicioTratamiento;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
}
