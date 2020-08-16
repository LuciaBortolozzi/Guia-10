package controller;

import model.Localidades;
import model.Provincias;
import model.TiposSangre;
import view.FrameIngreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import static controller.Controlador.*;

public class FrameIngresoCtrl implements ActionListener, ItemListener {

    private FrameIngreso vista;

    public FrameIngresoCtrl() {
        vista = new FrameIngreso(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getButtonAgregar()) {

            Controlador.ingresarPersona(vista);

            vista.limpiar(false);
        }
    }

    public void setVista(FrameIngreso vista) {


        vista.getComboProvincias().addItem("Seleccione una Provincia");
        vista.getComboLocalidades().addItem("Seleccione una localidad");
        for (Provincias pro : provincias) {
            vista.getComboProvincias().addItem(pro.getNombreProv());

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

}
