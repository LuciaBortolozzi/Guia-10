package view;

import controller.CtrlFrameEstadisticas;

import javax.swing.*;
import java.awt.*;

public class FrameEstadisticas {
    private CtrlFrameEstadisticas ctrlFrameEstadisticas;

    private JFrame ventana = new JFrame("Estadisticas");
    private ImageIcon icon = new ImageIcon("src/resources/blood-donation-1.png");
    private JPanel panelEstadistica1 = new JPanel(new FlowLayout());
    private JPanel panelEstadistica2 = new JPanel(new FlowLayout());
    private JPanel panelEstadistica3 = new JPanel(new FlowLayout());
    private JPanel panelCentral = new JPanel();

    public FrameEstadisticas(CtrlFrameEstadisticas ctrlFrameEstadisticas) {
        this.ctrlFrameEstadisticas = ctrlFrameEstadisticas;
        ctrlFrameEstadisticas.setVista(this);

        ventana.setIconImage(icon.getImage());
        ventana.setSize(650, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }
}
