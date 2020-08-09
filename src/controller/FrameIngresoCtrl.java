package controller;

import view.FrameIngreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameIngresoCtrl implements ActionListener {

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
        this.vista = vista;
    }

}
