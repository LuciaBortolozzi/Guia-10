package controller;

import view.FrameMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenuCtrl implements ActionListener {

    private FrameMenu frameMenu;

    public FrameMenuCtrl() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frameMenu.getSubopcion1()) {
            JOptionPane.showMessageDialog(null, "SUBOPCION1", "SUBOPCION1", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == frameMenu.getSubopcion2()) {
            JOptionPane.showMessageDialog(null, "SUBOPCION2", "SUBOPCION2", JOptionPane.INFORMATION_MESSAGE);

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
