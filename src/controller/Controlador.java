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

    static TreeSet<Personas> personas = PersonasTXT.bajarPersonasTXT(localidades, tiposSangres);

    static TreeSet<Personas> personas2 = MedicamentosTXT.bajarPacientesMedicamentosTXT(personas, medicamentos);

    public static void ingresarPersona(FrameIngreso vista) {
    }

}
