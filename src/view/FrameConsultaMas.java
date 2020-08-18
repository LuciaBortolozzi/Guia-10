package view;

import controller.CtrlFrameConsultaMas;
import model.Localidades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;

public class FrameConsultaMas {
    private JFrame ventana = new JFrame("Consulta masiva");
    private CtrlFrameConsultaMas ctrlFrameConsultaMas;
    private JPanel panelConsulta = new JPanel(new FlowLayout());

    private JLabel labelProvincia = new JLabel("Provincia");
    private JTextField textProvincia = new JTextField(20);
    private JLabel labelTipoSangre = new JLabel("Tipo de Sangre");
    private JTextField textTipoSangre = new JTextField(20);
    private JButton buttonBuscar = new JButton("Buscar");
    private String[] columnas = {"DNI", "Nombre", "Apellido", "Localidad", "Fecha de Nacimiento", "Sexo"};
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable tabla = new JTable(tableModel);
    private JScrollPane scrollPane = new JScrollPane(tabla);

    public FrameConsultaMas(CtrlFrameConsultaMas ctrlFrameConsultaMas) {
        this.ctrlFrameConsultaMas = ctrlFrameConsultaMas;
        ctrlFrameConsultaMas.setVista(this);

        ventana.setSize(650, 650);
        ventana.setLayout(new FlowLayout());
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        buttonBuscar.addActionListener(ctrlFrameConsultaMas);

        textTipoSangre.setToolTipText("Grupo + RH + Factor. Ej: ABRHPOSITIVO");

        panelConsulta.add(labelProvincia);
        panelConsulta.add(textProvincia);
        panelConsulta.add(labelTipoSangre);
        panelConsulta.add(textTipoSangre);

        panelConsulta.add(scrollPane);

        for (int i = 0; i < columnas.length; i++) {
            tableModel.addColumn(columnas[i]);
        }
        panelConsulta.add(buttonBuscar);
        ventana.add(panelConsulta);


    }

    public JTextField getTextProvincia() {
        return textProvincia;
    }

    public void setTextProvincia(JTextField textProvincia) {
        this.textProvincia = textProvincia;
    }

    public JTextField getTextTipoSangre() {
        return textTipoSangre;
    }

    public void setTextTipoSangre(JTextField textTipoSangre) {
        this.textTipoSangre = textTipoSangre;
    }

    public JButton getButtonBuscar() {
        return buttonBuscar;
    }

    public void setButtonBuscar(JButton buttonBuscar) {
        this.buttonBuscar = buttonBuscar;
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
}
