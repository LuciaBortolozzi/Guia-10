package controller;

import view.FrameConsultaAct;
import view.FrameIngreso;
import view.FrameMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlFrameMenu implements ActionListener {

    private FrameMenu frameMenu;

    public CtrlFrameMenu() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frameMenu.getSubopcion1()) {
            new FrameIngreso(new CtrlFrameIngreso(), true);
        } else if (e.getSource() == frameMenu.getSubopcion2()) {
            new FrameConsultaAct(new CtrlFrameConsultaAct());
        } else if (e.getSource() == frameMenu.getSubopcion3()) {
            JOptionPane.showMessageDialog(null, "SUBOPCION3", "SUBOPCION3", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == frameMenu.getOpcion2()) {
            JOptionPane.showMessageDialog(null, "OPCION2", "OPCION2", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public FrameMenu getFrameMenu() {
        return frameMenu;
    }

    public void setFrameMenu(FrameMenu frameMenu) {
        this.frameMenu = frameMenu;
    }
}