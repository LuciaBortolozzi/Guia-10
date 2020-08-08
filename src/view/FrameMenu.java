package view;

import controller.FrameMenuCtrl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenu extends JFrame {

    JMenu opcion1 = new JMenu("Operaciones");
    JMenuItem opcion2 = new JMenuItem("Estadisticas");
    JMenu opcion3 = new JMenu("Sistema");
    JMenuItem opcion4 = new JMenuItem("Salir");

    JMenuItem subopcion1 = new JMenuItem("Ingreso");
    JMenuItem subopcion2 = new JMenuItem("Consulta y Actualizacion");
    JMenuItem subopcion3 = new JMenuItem("Consulta Masiva");

    JMenuItem subopcion4 = new JMenuItem("Acerca de");

    private FrameMenuCtrl frameMenuCtrl;

    public FrameMenu(FrameMenuCtrl frameMenuCtrl) {

        this.frameMenuCtrl = frameMenuCtrl;
        this.frameMenuCtrl.setFrameMenu(this);

        this.setTitle("Banco de Sangre");

        JMenu solapa = new JMenu("Opciones");

        opcion1.add(subopcion1);
        opcion1.add(subopcion2);
        opcion1.add(subopcion3);
        opcion3.add(subopcion4);

        subopcion1.addActionListener(frameMenuCtrl);
        subopcion2.addActionListener(frameMenuCtrl);
        subopcion3.addActionListener(frameMenuCtrl);
        opcion2.addActionListener(frameMenuCtrl);

        solapa.add(opcion1);
        solapa.add(opcion2);
        solapa.add(opcion3);
        solapa.add(opcion4);


        subopcion4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Banco de Sangre\n" +
                                "Versión 1.0\n" +
                                "2020 - Schmidt y Bortolozzi", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        opcion4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir de la aplicación?",
                        "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        barraMenu.add(solapa);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public JMenu getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(JMenu opcion1) {
        this.opcion1 = opcion1;
    }

    public JMenuItem getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(JMenuItem opcion2) {
        this.opcion2 = opcion2;
    }

    public JMenu getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(JMenu opcion3) {
        this.opcion3 = opcion3;
    }

    public JMenuItem getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(JMenuItem opcion4) {
        this.opcion4 = opcion4;
    }

    public JMenuItem getSubopcion1() {
        return subopcion1;
    }

    public void setSubopcion1(JMenuItem subopcion1) {
        this.subopcion1 = subopcion1;
    }

    public JMenuItem getSubopcion2() {
        return subopcion2;
    }

    public void setSubopcion2(JMenuItem subopcion2) {
        this.subopcion2 = subopcion2;
    }

    public JMenuItem getSubopcion3() {
        return subopcion3;
    }

    public void setSubopcion3(JMenuItem subopcion3) {
        this.subopcion3 = subopcion3;
    }

    public JMenuItem getSubopcion4() {
        return subopcion4;
    }

    public void setSubopcion4(JMenuItem subopcion4) {
        this.subopcion4 = subopcion4;
    }
}
