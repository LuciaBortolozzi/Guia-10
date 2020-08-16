package view;

import controller.FrameConsultaActCtrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameConsultaAct {

    private JFrame ventana = new JFrame("Consulta personas");
    private JPanel panelCentral = new JPanel();

    private JTextArea textArea = new JTextArea("-Ingrese el documento de la persona o paciente del cual desea realizar la consulta-");
    private JLabel labelDNI = new JLabel("Documento");
    private JTextField textDNI = new JTextField(20);
    private JButton buttonConsutar = new JButton("Consultar");
    private JButton buttonCancelar = new JButton("Cancelar");

    public FrameConsultaAct(FrameConsultaActCtrl frameConsultaActCtrl) {

        ventana.setSize(650, 650);

        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiar(true);
            }
        });

        //ARREGLAR ESTO PARA QUE QUEDE MAS LINDO
        panelCentral.setLayout(new FlowLayout());
        panelCentral.add(textArea);
        panelCentral.add(labelDNI);
        panelCentral.add(textDNI);
        panelCentral.add(buttonConsutar);
        panelCentral.add(buttonCancelar);

        ventana.add(panelCentral);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }

    public void limpiar(boolean conf) {
        int rta = !(conf) ? 0 : (JOptionPane.showConfirmDialog(null, "Los datos no fueron guardados. Confirma?", "Confirmacion", JOptionPane.YES_NO_OPTION));
        if (rta == JOptionPane.YES_OPTION) {

            textDNI.setText("");
        }
    }

}
