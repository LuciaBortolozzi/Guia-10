package controller;

import model.*;
import model.DAO.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Controlador {

    static ArrayList<Provincias> provincias = ProvinciasTXT.bajarProvinciasTXT();
    static ArrayList<Localidades> localidades = LocalidadesTXT.bajarLocalidadesTXT(provincias);
    static ArrayList<TiposSangre> tiposSangres = TiposSangreTXT.bajarTiposSangreTXT();
    static ArrayList<Medicamentos> medicamentos = MedicamentosTXT.bajarMedicamentosTXT();

    static TreeSet<Personas> personasAux = PersonasTXT.bajarPersonasTXT(localidades, tiposSangres);

    static TreeSet<Personas> personas = MedicamentosTXT.bajarPacientesMedicamentosTXT(personasAux, medicamentos);

    public static Localidades buscarLocalidad(String localidadST) {
        Localidades localidad = null;

        for (Localidades loc: localidades) {
            if (loc.getNombreLoc().equals(localidadST)){
                return loc;
            }
        }

        return localidad;
    }

    public static TiposSangre buscarTipoSangre(String tipoSangreST) {
        TiposSangre tiposSangre = null;

        for (TiposSangre tipo : tiposSangres) {
            String aux = tipo.getGrupo() + "-RH" + tipo.getFactor();
            if (aux.equals(tipoSangreST)) {
                return tipo;
            }
        }
        return tiposSangre;
    }

    public static ArrayList<Medicamentos> buscarMedicamentos(List<String> medicamentosST) {
        ArrayList<Medicamentos> meds = new ArrayList<Medicamentos>();

        for (Medicamentos med: medicamentos) {
            for (String medAux: medicamentosST) {
                if (med.getNombreMed().equals(medAux)){
                    meds.add(med);
                }
            }

        }

        return meds;
    }
}
