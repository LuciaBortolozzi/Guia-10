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

    static TreeSet<Personas> personas = PersonasTXT.bajarPersonasTXT(localidades, tiposSangres);

    static TreeSet<Personas> personas2 = MedicamentosTXT.bajarPacientesMedicamentosTXT(personas, medicamentos);

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
            String aux = tipo.getGrupo() + " RH " + tipo.getFactor();
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
  
/*  public static void ingresarPersona(FrameIngreso vista) {

        String nombre = vista.getTextNombre().getText();
        String apellido = vista.getTextApellido().getText();
        int dni = Integer.parseInt(vista.getTextDNI().getText());
        String nombreProvincia = vista.getComboProvincias().getSelectedItem().toString();
        String nombreLocalidad = vista.getComboLocalidades().getSelectedItem().toString();

        char sexo;
        if (vista.getRadioButtonFem().isSelected()) {
            sexo = 'F';
        } else {
            sexo = 'M';
        }

        String tipoSangre = vista.getComboTiposSangre().getSelectedItem().toString();
        String[] tipoSangreST = tipoSangre.split("-");
        String grupo = tipoSangreST[0];
        String factor = tipoSangreST[1];

        boolean esDonador = true;
        if (vista.getRadioButtonPaciente().isSelected()) {
            esDonador = false;
        }

        Personas persona = null;
        if (esDonador) {
            persona = new Donadores();
        } else {
            persona = new Pacientes();
        }

        //PACIENTE

        String enfermedad = vista.getTextEnfermedad().getText();

        //NI PÁLIDA DE COMO TRAER LAS LISTAS
        // List<String> listaMedicamentos = vista.getListMedicamentosAux();

        String inicioTratamiento = vista.getTextInicioTratamiento().getText();
        int diaInicioTrat = Integer.parseInt(inicioTratamiento.substring(0, 2));
        int mesInicioTrat = Integer.parseInt(inicioTratamiento.substring(2, 4));
        int anioInicioTrat = Integer.parseInt(inicioTratamiento.substring(4, 8));

        //DONADOR

        boolean sangre = false;
        boolean plasma = false;
        boolean plaquetas = false;
        if (vista.getBoxSangre().isSelected()) {
            sangre = true;
        }
        if (vista.getBoxPlasma().isSelected()) {
            plasma = true;
        }
        if (vista.getBoxPlaquetas().isSelected()) {
            plaquetas = true;
        }

        //VER SI METEMOS EXTRACCIONES POR OTRO LADO

        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setDni(dni);

        int codProvincia = 0;
        for (Provincias prov : provincias) {

            if (nombreProvincia.equals(prov.getNombreProv())) {

                codProvincia = prov.getIdProvincia();
            }

        }

        //SI HAGO ESTO.. TENGO ACCESO A LOCALIDAD???
        Localidades localidad = PersonasTXT.agregarLocalidad(localidades, nombreLocalidad, codProvincia);
        persona.setLocalidad(localidad);

        persona.setSexo(sexo);

        int tipoSangreID = 0;
        for (TiposSangre san : tiposSangres) {

            if (san.getFactor().equals(factor) && san.getGrupo().equals(grupo)) {

                tipoSangreID = san.getId();
            }
        }

        TiposSangre tipoSangres = PersonasTXT.agregarTipoSangre(tiposSangres, tipoSangreID);
        persona.setTipoSangre(tipoSangres);

        if (persona instanceof Donadores) {

            ((Donadores) persona).setDonaSangre(sangre);
            ((Donadores) persona).setDonaPlasma(plasma);
            ((Donadores) persona).setDonaPlaquetas(plaquetas);

        } else {

            ((Pacientes) persona).setEnfermedad(enfermedad);
        }

        if (vista.esIngreso()) {

            PersonasControlador.agregarPersona(personas, persona);

        } else {

            PersonasControlador.modificarPersona(personas, persona);

        }
    }*/
}
