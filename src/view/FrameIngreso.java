package view;

import controller.Controlador;
import controller.FrameIngresoCtrl;
import controller.FrameMenuCtrl;
import model.Medicamentos;
import model.Localidades;
import model.Provincias;
import model.TiposSangre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*La pantalla gráfica para el ingreso de la misma debe incluir:

        Dos listas desplegables, donde la segunda sea dependiente de la primera
        Listas estática y dinámica con selección múltiple en ambas
        Botones de dos opciones, dentro de un panel específico
        Botones de opciones dentro de otro panel específico
        Casillas de verificación, con una de ellas activa por defecto   //Preguntar

*/

public class FrameIngreso {

    private JFrame ventana = new JFrame("Ingreso personas");
    private JPanel contentPanel = new JPanel();

    private JTextArea textArea = new JTextArea("Complete con los datos de personas\n" + "sarasa\n" + "sarasa\n");

    private JLabel labelNombre = new JLabel("Nombre");
    private JLabel labelApellido = new JLabel("Apellido");
    private JLabel labelDNI = new JLabel("Documento");
    private JLabel labelFechaNac = new JLabel("Fecha de Nacimiento");
    private JLabel labelSexo = new JLabel("Sexo");
    private JLabel labelLocalidad = new JLabel("Localidad");
    private JLabel labelProvincia = new JLabel("Provincia");
    private JLabel labelTipoSangre = new JLabel("Tipo de Sangre");
    private JLabel labelPersona = new JLabel("Paciente o Donador");
    private JLabel labelInicioTratamiento = new JLabel("Fecha de inicio de Tratamiento");
    private JLabel labelEnfermedad = new JLabel("Enfermedad");
    private JLabel labelMedicamentos = new JLabel("Medicamentos");
    private JLabel labelDonacion = new JLabel("Tipo de donacion");

    private JTextField textNombre = new JTextField(20);
    private JTextField textApellido = new JTextField(20);
    private JTextField textDNI = new JTextField(20);
    private JTextField textFechaNac = new JTextField(8);
    private JTextField textInicioTratamiento = new JTextField(8);
    private JTextField textEnfermedad = new JTextField(50);

    private JRadioButton radioButtonMasc = new JRadioButton("Masculino");
    private JRadioButton radioButtonFem = new JRadioButton("Femenino");
    private ButtonGroup groupSexo = new ButtonGroup();

    private JRadioButton radioButtonPaciente = new JRadioButton("Paciente");
    private JRadioButton radioButtonDonador = new JRadioButton("Donador");
    private ButtonGroup groupTipoPersona = new ButtonGroup();

    private JCheckBox boxSangre = new JCheckBox("Sangre");
    private JCheckBox boxPlaquetas = new JCheckBox("Plaquetas");
    private JCheckBox boxPlasma = new JCheckBox("Plasma");

    private JComboBox<String> comboLocalidades = new JComboBox<String>();
    private JComboBox<String> comboProvincias = new JComboBox<String>();
    private JComboBox<String> comboTiposSangre = new JComboBox<String>();

    private JList<String> listMedicamentos = new JList<String>();
    private JList<String> listMedicamentosAux = new JList<String>();

    private JButton buttonAgregar = new JButton("Aceptar");
    private JButton buttonCancelar = new JButton("Cancelar");

    private JButton buttonCopiar;
    private JScrollPane scrollPane, scrollPaneAux;

    public FrameIngreso(FrameIngresoCtrl frameIngresoCtrl) {
        ventana.setSize(400, 600);
        ventana.setLayout(new FlowLayout());
        //ventana.setLayout(new GridLayout(15,1));

        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiar(true);
            }
        });

        buttonAgregar.addActionListener(frameIngresoCtrl);

        frameIngresoCtrl.setVista(this);
        comboProvincias.addItemListener(frameIngresoCtrl);
        comboProvincias.addActionListener(frameIngresoCtrl);
        comboLocalidades.addActionListener(frameIngresoCtrl);
  /*

        //comboLocalidades = new JComboBox((ComboBoxModel) localidadesST);
        comboLocalidades = new JComboBox(Controlador.stringifyLocalidades(comboProvincias.getSelectedIndex()).toArray());
        comboLocalidades.setMaximumRowCount(8);
        
        //comboProvincias = new JComboBox((ComboBoxModel) provinciasST);
        comboProvincias = new JComboBox(Controlador.stringifyProvincias().toArray());
        comboProvincias.setMaximumRowCount(8);
*/
        //comboTiposSangre = new JComboBox((ComboBoxModel) tiposDeSangreST);
        comboTiposSangre = new JComboBox(Controlador.stringifyTiposSangres().toArray());
        comboTiposSangre.setMaximumRowCount(8);

        textArea.setEditable(false);
        ventana.add(textArea);
        ventana.add(labelNombre);
        ventana.add(textNombre);
        ventana.add(labelApellido);
        ventana.add(textApellido);
        ventana.add(labelDNI);
        ventana.add(textDNI);
        ventana.add(labelFechaNac);
        ventana.add(textFechaNac);
        ventana.add(labelSexo);
        groupSexo.add(radioButtonFem);
        groupSexo.add(radioButtonMasc);
        ventana.add(radioButtonFem);
        ventana.add(radioButtonMasc);
        ventana.add(labelTipoSangre);
        ventana.add(comboTiposSangre);
        ventana.add(labelProvincia);
        ventana.add(comboProvincias);
        ventana.add(labelLocalidad);
        ventana.add(comboLocalidades);

        ventana.add(labelPersona);
        groupTipoPersona.add(radioButtonPaciente);
        groupTipoPersona.add(radioButtonDonador);
        ventana.add(radioButtonPaciente);
        ventana.add(radioButtonDonador);

        // Donador

        ventana.add(labelDonacion);
        ventana.add(boxSangre);
        ventana.add(boxPlaquetas);
        ventana.add(boxPlasma);

        // Paciente

        ventana.add(labelInicioTratamiento);
        ventana.add(textInicioTratamiento);
        ventana.add(labelEnfermedad);
        ventana.add(textEnfermedad);
        ventana.add(labelMedicamentos);
        ventana.add(listMedicamentos);
       // ventana.add(buttonCopiar);
        ventana.add(listMedicamentosAux);


        ItemListener itemListener = new ItemListener() {

            public void itemStateChanged(ItemEvent e){

                if (radioButtonDonador.isSelected()){
                    if (e.getStateChange() ==  ItemEvent.SELECTED) {
                        labelDonacion.setVisible(true);
                        boxSangre.setVisible(true);
                        boxPlaquetas.setVisible(true);
                        boxPlasma.setVisible(true);

                        labelInicioTratamiento.setVisible(false);
                        textInicioTratamiento.setVisible(false);
                        labelEnfermedad.setVisible(false);
                        textEnfermedad.setVisible(false);
                        labelMedicamentos.setVisible(false);
                        listMedicamentos.setVisible(false);
                        buttonCopiar.setVisible(false);
                        listMedicamentosAux.setVisible(false);
                    }
                } else if (radioButtonPaciente.isSelected()){
                    labelInicioTratamiento.setVisible(true);
                    textInicioTratamiento.setVisible(true);
                    labelEnfermedad.setVisible(true);
                    textEnfermedad.setVisible(true);
                    labelMedicamentos.setVisible(true);
                    listMedicamentos.setVisible(true);
                    buttonCopiar.setVisible(true);
                    listMedicamentosAux.setVisible(true);

                    labelDonacion.setVisible(false);
                    boxSangre.setVisible(false);
                    boxPlaquetas.setVisible(false);
                    boxPlasma.setVisible(false);
                }
            }
        };
        radioButtonDonador.addItemListener(itemListener);
        radioButtonPaciente.addItemListener(itemListener);

        // Abajo
        ventana.add(buttonAgregar);
        ventana.add(buttonCancelar);
        ventana.setVisible(true);
    }

    public void limpiar(boolean conf) {
        int rta = !(conf) ? 0 : (JOptionPane.showConfirmDialog(null, "Los datos no fueron guardados. Confirma?", "Confirmacion", JOptionPane.YES_NO_OPTION));
        if (rta == JOptionPane.YES_OPTION) {
            textNombre.setText("");
            textApellido.setText("");
            textDNI.setText("");
            textFechaNac.setText("");
            textEnfermedad.setText("");
            textInicioTratamiento.setText("");
            radioButtonFem.setSelected(true);
            radioButtonMasc.setSelected(false);
            radioButtonPaciente.setSelected(false);
            radioButtonDonador.setSelected(true);
            boxSangre.setSelected(false);
            boxPlaquetas.setSelected(false);
            boxPlasma.setSelected(false);
        }
    }


    public JFrame getVentana() {
        return ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JLabel getLabelNombre() {
        return labelNombre;
    }

    public void setLabelNombre(JLabel labelNombre) {
        this.labelNombre = labelNombre;
    }

    public JLabel getLabelApellido() {
        return labelApellido;
    }

    public void setLabelApellido(JLabel labelApellido) {
        this.labelApellido = labelApellido;
    }

    public JLabel getLabelDNI() {
        return labelDNI;
    }

    public void setLabelDNI(JLabel labelDNI) {
        this.labelDNI = labelDNI;
    }

    public JLabel getLabelFechaNac() {
        return labelFechaNac;
    }

    public void setLabelFechaNac(JLabel labelFechaNac) {
        this.labelFechaNac = labelFechaNac;
    }

    public JLabel getLabelSexo() {
        return labelSexo;
    }

    public void setLabelSexo(JLabel labelSexo) {
        this.labelSexo = labelSexo;
    }

    public JLabel getLabelLocalidad() {
        return labelLocalidad;
    }

    public void setLabelLocalidad(JLabel labelLocalidad) {
        this.labelLocalidad = labelLocalidad;
    }

    public JLabel getLabelProvincia() {
        return labelProvincia;
    }

    public void setLabelProvincia(JLabel labelProvincia) {
        this.labelProvincia = labelProvincia;
    }

    public JLabel getLabelTipoSangre() {
        return labelTipoSangre;
    }

    public void setLabelTipoSangre(JLabel labelTipoSangre) {
        this.labelTipoSangre = labelTipoSangre;
    }

    public JTextField getTextNombre() {
        return textNombre;
    }

    public void setTextNombre(JTextField textNombre) {
        this.textNombre = textNombre;
    }

    public JTextField getTextApellido() {
        return textApellido;
    }

    public void setTextApellido(JTextField textApellido) {
        this.textApellido = textApellido;
    }

    public JTextField getTextDNI() {
        return textDNI;
    }

    public void setTextDNI(JTextField textDNI) {
        this.textDNI = textDNI;
    }

    public JTextField getTextFechaNac() {
        return textFechaNac;
    }

    public void setTextFechaNac(JTextField textFechaNac) {
        this.textFechaNac = textFechaNac;
    }

    public JRadioButton getRadioButtonMasc() {
        return radioButtonMasc;
    }

    public void setRadioButtonMasc(JRadioButton radioButtonMasc) {
        this.radioButtonMasc = radioButtonMasc;
    }

    public JRadioButton getRadioButtonFem() {
        return radioButtonFem;
    }

    public void setRadioButtonFem(JRadioButton radioButtonFem) {
        this.radioButtonFem = radioButtonFem;
    }

    public ButtonGroup getGroupSexo() {
        return groupSexo;
    }

    public void setGroupSexo(ButtonGroup groupSexo) {
        this.groupSexo = groupSexo;
    }

    public JRadioButton getRadioButtonPaciente() {
        return radioButtonPaciente;
    }

    public void setRadioButtonPaciente(JRadioButton radioButtonPaciente) {
        this.radioButtonPaciente = radioButtonPaciente;
    }

    public JRadioButton getRadioButtonDonador() {
        return radioButtonDonador;
    }

    public void setRadioButtonDonador(JRadioButton radioButtonDonador) {
        this.radioButtonDonador = radioButtonDonador;
    }

    public ButtonGroup getGroupTipoPersona() {
        return groupTipoPersona;
    }

    public void setGroupTipoPersona(ButtonGroup groupTipoPersona) {
        this.groupTipoPersona = groupTipoPersona;
    }

    public JCheckBox getBoxSangre() {
        return boxSangre;
    }

    public void setBoxSangre(JCheckBox boxSangre) {
        this.boxSangre = boxSangre;
    }

    public JCheckBox getBoxPlaquetas() {
        return boxPlaquetas;
    }

    public void setBoxPlaquetas(JCheckBox boxPlaquetas) {
        this.boxPlaquetas = boxPlaquetas;
    }

    public JCheckBox getBoxPlasma() {
        return boxPlasma;
    }

    public void setBoxPlasma(JCheckBox boxPlasma) {
        this.boxPlasma = boxPlasma;
    }

    public JComboBox<String> getComboLocalidades() {
        return comboLocalidades;
    }

    public void setComboLocalidades(JComboBox<String> comboLocalidades) {
        this.comboLocalidades = comboLocalidades;
    }

    public JComboBox<String> getComboProvincias() {
        return comboProvincias;
    }

    public void setComboProvincias(JComboBox<String> comboProvincias) {
        this.comboProvincias = comboProvincias;
    }

    public JComboBox<String> getComboTiposSangre() {
        return comboTiposSangre;
    }

    public void setComboTiposSangre(JComboBox<String> comboTiposSangre) {
        this.comboTiposSangre = comboTiposSangre;
    }

    public JList<String> getListMedicamentos() {
        return listMedicamentos;
    }

    public void setListMedicamentos(JList<String> listMedicamentos) {
        this.listMedicamentos = listMedicamentos;
    }

    public JList<String> getListMedicamentosAux() {
        return listMedicamentosAux;
    }

    public void setListMedicamentosAux(JList<String> listMedicamentosAux) {
        this.listMedicamentosAux = listMedicamentosAux;
    }

    public JButton getButtonAgregar() {
        return buttonAgregar;
    }

    public void setButtonAgregar(JButton buttonAgregar) {
        this.buttonAgregar = buttonAgregar;
    }

    public JButton getButtonCancelar() {
        return buttonCancelar;
    }

    public void setButtonCancelar(JButton buttonCancelar) {
        this.buttonCancelar = buttonCancelar;
    }

    public JButton getButtonCopiar() {
        return buttonCopiar;
    }

    public void setButtonCopiar(JButton buttonCopiar) {
        this.buttonCopiar = buttonCopiar;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JScrollPane getScrollPaneAux() {
        return scrollPaneAux;
    }

    public void setScrollPaneAux(JScrollPane scrollPaneAux) {
        this.scrollPaneAux = scrollPaneAux;
    }
}
