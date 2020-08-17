package controller;

import model.*;
import model.DAO.PersonasTXT;
import view.FrameIngreso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static controller.Controlador.*;

public class CtrlFrameIngreso implements ActionListener, ItemListener {

    private FrameIngreso vista;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getButtonAceptar()) {

            Controlador.ingresarPersona(vista);

            vista.limpiar(false);
        } else if (e.getSource() == vista.getButtonCopiar()) {
            vista.getMedsAux().removeAllElements();
            List<String> lst = vista.getListMedicamentos().getSelectedValuesList();
            for (int i = 0; i < lst.size(); i++) {
                vista.getMedsAux().add(i, lst.get(i));
            }

        } else if (e.getSource() == vista.getButtonEditar()) {
            vista.editable(true);
            vista.getButtonAceptar().setVisible(true);
            vista.getButtonCancelar().setVisible(true);
            vista.getButtonAceptar().setEnabled(true);
            vista.getButtonCancelar().setEnabled(true);
            vista.getButtonEditar().setVisible(false);
            vista.getButtonAnular().setVisible(false);

        } else if (e.getSource() == vista.getButtonAnular()) {
            int dni = Integer.parseInt(vista.getTextDNI().getText().trim());

            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la persona?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                PersonasTXT.eliminarPersona(dni);
                JOptionPane.showMessageDialog(null, "La persona se elimino correctamente");
        }
    }
    }

    public void setVista(FrameIngreso vista) {


        vista.getComboProvincias().addItem("Seleccione una Provincia");
        vista.getComboLocalidades().addItem("Seleccione una localidad");
        for (Provincias pro : provincias) {
            vista.getComboProvincias().addItem(pro.getNombreProv());

        }

        for(Medicamentos med: medicamentos) {
            vista.getMeds().addElement(med.getNombreMed());
        }

        this.vista = vista;

    }

    public static ArrayList<String> stringifyTiposSangres() {

        ArrayList<String> tiposSangresST = new ArrayList<String>();
        for (TiposSangre tipo : tiposSangres) {
            tiposSangresST.add(tipo.getGrupo() + " RH " + tipo.getFactor());
        }
        return tiposSangresST;
    }

    public static ArrayList<String> stringifyMedicamentos() {

        ArrayList<String> medicamentosST = new ArrayList<String>();
        for (Medicamentos med : medicamentos) {
            medicamentosST.add(med.getNombreMed());
        }
        return medicamentosST;
    }

    public List<String> getLocalidadesxProvincia(String provSeleccionada) {

        List<String> STLocalidades = new ArrayList();

        for (Localidades loc : localidades) {
            if (loc != null) {
                if (loc.getProvincia().getNombreProv().equals(provSeleccionada)) {

                    STLocalidades.add(loc.getNombreLoc());

                }
            }
        }

        return STLocalidades;
    }

    public void itemStateChanged(ItemEvent o) {
        String provinciaSeleccionada;
        List<String> STLocalidades;
        if (o.getSource() == vista.getComboProvincias()) {
            if (o.getStateChange() == ItemEvent.SELECTED) {
                if (vista.getComboProvincias().getSelectedIndex() > 0) {
                    provinciaSeleccionada = vista.getComboProvincias().getSelectedItem().toString();

                    vista.getComboLocalidades().removeAllItems();
                    vista.getComboLocalidades().addItem("Seleccione una localidad");

                    STLocalidades = getLocalidadesxProvincia(provinciaSeleccionada);
                    String[] locPorProvincia = new String[STLocalidades.size()];
                    locPorProvincia = STLocalidades.toArray(locPorProvincia);

                    for (int i = 0; i < locPorProvincia.length; i++) {
                        vista.getComboLocalidades().addItem(locPorProvincia[i]);

                    }
                    vista.getLabelLocalidad().setVisible(true);
                    vista.getComboLocalidades().setVisible(true);
                } else if (vista.getComboProvincias().getSelectedIndex() == 0) {

                    vista.getComboLocalidades().removeAllItems();
                    vista.getComboLocalidades().addItem("Seleccione una localidad");
                }
            }
        }

    }

    public void mostrarPersona(Personas persona) {

        vista.getTextDNI().setText(String.valueOf(persona.getDni()));
        vista.getTextApellido().setText(persona.getApellido());
        vista.getTextNombre().setText(persona.getNombre());
        String fechaNac = String.format("%02d", persona.getFechaNac().get(Calendar.DAY_OF_MONTH))
                + String.format("%02d", (persona.getFechaNac().get(Calendar.MONTH) + 1))
                +  String.format("%04d", (persona.getFechaNac().get(Calendar.YEAR)));
        vista.getTextFechaNac().setText(fechaNac);
        vista.getComboTiposSangre().setSelectedItem(persona.getTipoSangre().getGrupo() + " RH " + persona.getTipoSangre().getFactor());
        vista.getComboProvincias().setSelectedItem(persona.getLocalidad().getProvincia().getNombreProv());
        vista.getComboLocalidades().setSelectedItem(persona.getLocalidad().getNombreLoc());

        vista.getRadioButtonFem().setSelected(persona.getSexo() == 'F' ? true : false);
        vista.getRadioButtonMasc().setSelected(persona.getSexo() == 'M' ? true : false);

        if (persona instanceof Pacientes){
            vista.getRadioButtonPaciente().setSelected(true);
            vista.getRadioButtonDonador().setSelected(false);

            vista.getTextEnfermedad().setText(((Pacientes) persona).getEnfermedad());
            String fechaInicioTratamiento = String.format("%02d",((Pacientes) persona).getInicioTratamiento().get(Calendar.DAY_OF_MONTH))
                    + String.format("%02d",(((Pacientes) persona).getInicioTratamiento().get(Calendar.MONTH) + 1))
                    +  String.format("%04d",((Pacientes) persona).getInicioTratamiento().get(Calendar.YEAR));
            vista.getTextInicioTratamiento().setText(fechaInicioTratamiento);

            for (Medicamentos meds: medicamentos){
                vista.getMeds().addElement(meds.getNombreMed());
            }

            for (Medicamentos meds: ((Pacientes) persona).getMedicamentos()){
                vista.getMedsAux().addElement(meds.getNombreMed());
            }

        } else {
            vista.getRadioButtonPaciente().setSelected(false);
            vista.getRadioButtonDonador().setSelected(true);

            boolean plaquetas = ((Donadores) persona).isDonaPlaquetas();
            boolean plasma = ((Donadores) persona).isDonaPlasma();
            boolean sangre = ((Donadores) persona).isDonaSangre();

            vista.getBoxPlaquetas().setSelected(plaquetas);
            vista.getBoxPlasma().setSelected(plasma);
            vista.getBoxSangre().setSelected(sangre);

            // Extracciones

        }

    }
}