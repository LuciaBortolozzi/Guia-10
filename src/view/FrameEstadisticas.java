package view;

import controller.CtrlFrameEstadisticas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrameEstadisticas {
    private CtrlFrameEstadisticas ctrlFrameEstadisticas;

    private JFrame ventana = new JFrame("Estadisticas");
    private ImageIcon icon = new ImageIcon("src/resources/blood-donation-1.png");
    private JPanel panelEstadistica0 = new JPanel(new FlowLayout());
    private JPanel panelEstadistica1 = new JPanel(new FlowLayout());
    private JPanel panelEstadistica2 = new JPanel(new FlowLayout());
    private JLabel labelProvincia = new JLabel("En CABA:");
    private String[] columnas = {"Nombre", "Apellido", "DNI", "Tipo Sangre"};
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable tabla = new JTable(tableModel);
    private JScrollPane scrollPane = new JScrollPane(tabla);
    private JLabel labelCantidadTotExt = new JLabel("Cantidad total extraida (en ml)");
    private JTextField textCantidadTotExt = new JTextField(10);

    public FrameEstadisticas(CtrlFrameEstadisticas ctrlFrameEstadisticas) {
        this.ctrlFrameEstadisticas = ctrlFrameEstadisticas;
        ctrlFrameEstadisticas.setVista(this);

        ventana.setIconImage(icon.getImage());
        ventana.setSize(550, 600);
        ventana.setLayout(new FlowLayout());
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        panelEstadistica0.add(labelProvincia);
        for (int i = 0; i < columnas.length; i++) {
            tableModel.addColumn(columnas[i]);
        }
        panelEstadistica1.add(scrollPane);

        panelEstadistica2.add(labelCantidadTotExt);
        panelEstadistica2.add(labelCantidadTotExt);
        panelEstadistica2.add(textCantidadTotExt);
        textCantidadTotExt.setEnabled(false);

        ventana.add(panelEstadistica0);
        ventana.add(panelEstadistica1);
        ventana.add(panelEstadistica2);

        ctrlFrameEstadisticas.getEstadisticas();



    }
}
