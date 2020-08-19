package controller;

import model.Personas;
import view.FrameConsultaMas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

public class CtrlFrameConsultaMas implements ActionListener {

    private FrameConsultaMas vista;

    public void setVista(FrameConsultaMas vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getButtonBuscar()) {
            String provinciaST = vista.getTextProvincia().getText();
            String tipoDeSangreST = vista.getTextTipoSangre().getText();


            vista.getTableModel().setRowCount(0);

            TreeSet<Personas> personasAux = consultaPersonas(provinciaST, tipoDeSangreST);
            for (Personas pers : personasAux) {
                Object[] row = {pers.getDni(), pers.getNombre(),
                        pers.getApellido(), pers.getLocalidad().getNombreLoc(), pers.getFechaNac(), pers.getSexo()};
                vista.getTableModel().addRow(row);
            }

//            vista.getTxtVisualizados().setText(String.valueOf(personasAux.size()));
//            vista.getTxtTotales().setText(String.valueOf(personas.size()));

        }
    }

    public TreeSet<Personas> consultaPersonas(String provinciaST, String tipoDeSangreST) {

        TreeSet<Personas> personasAux = new TreeSet<Personas>();

        String provincia = "";
        if (provinciaST.length() != 0) {
            provincia = provinciaST.toUpperCase().trim();
        }

        String tipoDeSangre = "";
        if (tipoDeSangreST.length() != 0) {
            tipoDeSangre = tipoDeSangreST.toUpperCase().trim();
        }

        if (provincia.equals("") && tipoDeSangre.equals("")) {
            return Controlador.personasAux;
        }

        for (Personas p : Controlador.personasAux) {

            String tipo = p.getTipoSangre().getGrupo()+"RH"+p.getTipoSangre().getFactor();
            String prov = p.getLocalidad().getProvincia().getNombreProv();

            if (!provincia.equals("") && !tipoDeSangre.equals("")) {
                if (prov.equals(provincia) && tipo.equals(tipoDeSangre)) {
                    personasAux.add(p);
                }
            } else if (!provincia.equals("")) {
                if (prov.equals(provincia)) {
                    personasAux.add(p);
                }
            } else {
                if (tipo.equals(tipoDeSangre)) {
                    personasAux.add(p);
                }
            }
        }

        return personasAux;
    }
}
