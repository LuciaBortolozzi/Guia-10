package controller;

import model.DAO.LocalidadesTXT;
import model.DAO.ProvinciasTXT;
import model.Localidades;
import model.Provincias;
import view.FrameIngreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class FrameIngresoCtrl implements ActionListener, ItemListener {

    static ArrayList<Provincias> provincias = ProvinciasTXT.bajarProvinciasTXT();
    static ArrayList<Localidades> localidades = LocalidadesTXT.bajarLocalidadesTXT(provincias);

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
        for(Provincias pro:provincias){
        vista.getComboProvincias().addItem(pro.getNombreProv());

        }
        this.vista = vista;

    }

    public List<String> getLocalidadesxProvincia (String marcaSeleccionada) {

        List<String> STLocalidades= new ArrayList();

        for (Localidades loc : localidades) {
            if (loc!=null) {
                if (loc.getProvincia().getNombreProv().equals(marcaSeleccionada)) {

                    STLocalidades.add(loc.getNombreLoc());

                }
            }
        }

        return STLocalidades;
    }

    public void itemStateChanged(ItemEvent o) {
        String provinciaSeleccionada;
        List <String> STLocalidades;
        if (o.getSource() == vista.getComboProvincias()) {  // AGREGUE ESTO
            if (o.getStateChange()== ItemEvent.SELECTED)
            {
                if (vista.getComboProvincias().getSelectedIndex()>0)
                {
                    provinciaSeleccionada = vista.getComboProvincias().getSelectedItem().toString();

                    vista.getComboLocalidades().removeAllItems();
                    vista.getComboLocalidades().addItem("Seleccione una localidad");

                    STLocalidades = getLocalidadesxProvincia(provinciaSeleccionada);
                    String[] modelosPorMarca = new String [STLocalidades.size()];
                    modelosPorMarca = STLocalidades.toArray(modelosPorMarca);

                    for (int i=0; i<modelosPorMarca.length; i++)
                    {
                        vista.getComboLocalidades().addItem(modelosPorMarca[i]);

                    }
                    vista.getLabelLocalidad().setVisible(true);
                    vista.getComboLocalidades().setVisible(true);
                }
            }}

    }

}
