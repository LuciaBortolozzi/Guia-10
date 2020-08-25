package controller;

import model.DAO.EstadisticasJson;
import model.Donadores;
import model.Personas;
import view.FrameEstadisticas;

import java.util.Calendar;
import java.util.TreeSet;

import static controller.Controlador.personas;

public class CtrlFrameEstadisticas {

    private FrameEstadisticas vista;
    private double totalPeso;

    public FrameEstadisticas getVista() {
        return vista;
    }

    public CtrlFrameEstadisticas(double totalPeso) {

        this.totalPeso = totalPeso;
    }

    public void setVista(FrameEstadisticas vista) {

        this.vista = vista;
    }

    public void getEstadisticas() {

        vista.getTableModel().setRowCount(0);

        TreeSet<Personas> personasAux = consultaPersonas();

        for (Personas pers : personasAux) {
            Object[] row = {pers.getNombre(),
                    pers.getApellido(), pers.getDni(), pers.getTipoSangre().getGrupo() + pers.getTipoSangre().getFactor()};
            vista.getTableModel().addRow(row);
        }

        vista.getTextCantidadTotExt().setText(String.valueOf(calcularMililitros()));

        consultaPorParametro();

    }

    public TreeSet<Personas> consultaPersonas() {

        TreeSet<Personas> personasAux = new TreeSet<Personas>();

        String provincia = "CABA";

        for (Personas p : personas) {

            if (p.getLocalidad().getProvincia().getNombreProv().equals(provincia)) {

                personasAux.add(p);
            }
        }

        return personasAux;
    }

    public double calcularMililitros() {

        double cantidad = 0;

        Calendar seisMesesAntes = Calendar.getInstance();
        Validaciones.seisMesesAntes(seisMesesAntes);

        for (Personas p : personas) {

            if (p instanceof Donadores) {
                if (((Donadores) p).isDonaPlaquetas() && ((Donadores) p).isDonaSangre() && ((Donadores) p).isDonaPlasma()) {

                    for (int i = 0; i < ((Donadores) p).getExtracciones().size(); i++) {

                        if (((Donadores) p).getExtracciones().get(i).getFechaDonacion().after(seisMesesAntes)) {

                            cantidad = cantidad + ((Donadores) p).getExtracciones().get(i).getCantExtraida();
                        }
                    }
                }
            }
        }
        return cantidad;
    }

    public void consultaPorParametro() {

        TreeSet<Personas> personasAux = new TreeSet<Personas>();
        for (Personas p : personas) {

            if (p instanceof Donadores) {
                for (int i = 0; i < ((Donadores) p).getExtracciones().size(); i++) {
                    if (((Donadores) p).getExtracciones().get(i).getPesoDonador() != totalPeso) {

                        personasAux.add(p);
                    }
                }
            }
        }

        EstadisticasJson.grabarJsonStream(personasAux);

    }
}
