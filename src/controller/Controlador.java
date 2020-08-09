package controller;

import model.*;
import model.DAO.*;
import view.FrameIngreso;

import java.util.ArrayList;
import java.util.TreeSet;

public class Controlador {

    static ArrayList<Provincias> provincias = ProvinciasTXT.bajarProvinciasTXT();
    static ArrayList<Localidades> localidades = LocalidadesTXT.bajarLocalidadesTXT(provincias);
    static ArrayList<TiposSangre> tiposSangres = TiposSangreTXT.bajarTiposSangreTXT();
    static ArrayList<Medicamentos> medicamentos = MedicamentosTXT.bajarMedicamentosTXT();

//    static TreeSet<Personas> personas = PersonasTXT.bajarPersonasTXT(localidades, tiposSangres, medicamentos);

    public static ArrayList<String> stringifyLocalidades() {

        ArrayList<String> localidadesST = new ArrayList<String>();
        for (Localidades loc : localidades) {
            localidadesST.add(loc.getNombreLoc());
        }
        return localidadesST;
    }

    public static ArrayList<String> stringifyProvincias() {

        ArrayList<String> provinciasST = new ArrayList<String>();
        for (Provincias prov : provincias) {
            provinciasST.add(prov.getNombreProv());
        }
        return provinciasST;
    }

    public static ArrayList<String> stringifyTiposSangres() {

        ArrayList<String> tiposSangresST = new ArrayList<String>();
        for (TiposSangre tipo : tiposSangres) {
            tiposSangresST.add(tipo.getGrupo() + tipo.getFactor());
        }
        return tiposSangresST;
    }

    public static ArrayList<String> stringifyMedicamentos() {

        ArrayList<String> provinciasST = new ArrayList<String>();
        for (Medicamentos med : medicamentos) {
            provinciasST.add(med.getNombreMed());
        }
        return provinciasST;
    }

/*    public static ArrayList<Localidades> devolverLocalidades() {
        return localidades;
    }*/

    public static Localidades buscarLocalidad(String nombreLoc) {

        for (Localidades loc : localidades) {
            if (loc.getNombreLoc().equals(nombreLoc)) {
                return loc;
            }
        }

        return null;
    }

    public static void ingresarPersona(FrameIngreso vista) {
    }
}
