package mx.unam.aragon.fes.gui;

import mx.unam.aragon.fes.Direccion;
import mx.unam.aragon.fes.conector.Conector;
import mx.unam.aragon.fes.estilo.Estilo;
import mx.unam.aragon.fes.estilo.StringUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroEmpleado extends JPanel implements ActionListener {
    private final Estilo estilo = new Estilo();
    private JTextField nombreTextField, paternoTextField, maternoTextField, edadTextField, curpTextField;
    private JTextField calleTextField, numeroTextField, coloniaTextField, delegacionTextField, estadoTextField, cpTextField;
    private JButton guardarButton, cargarButton, siguienteUsuario, anteriorUsuario, nuevoUsuario, enviarUsuario;

    public RegistroEmpleado(){
        estilo.panelEstilo(this);
        contruirUI();
    }

    private void contruirUI(){
        //JLabel section Persona class
        estilo.labelEstilo(new JLabel(), new int[]{20, 10, 100, 30}, StringUI.NOMBRE_LABEL_TEXT, this);
        estilo.labelEstilo(new JLabel(), new int[]{20, 80, 150, 30}, StringUI.APELLIDO_PATERNO_LABEL_TEXT, this);
        estilo.labelEstilo(new JLabel(), new int[]{240, 80, 150, 30}, StringUI.APELLIDO_MATERNO_LABEL_TEXT, this);
        estilo.labelEstilo(new JLabel(), new int[]{20, 150, 100, 30}, StringUI.EDAD_LABEL_TEXT, this);
        estilo.labelEstilo(new JLabel(), new int[]{240, 150, 100, 30}, StringUI.CURP_LABEL_TEXT, this);

        //JTextField section Persona class
        nombreTextField = new JTextField();
        nombreTextField.addActionListener(this);
        estilo.textFieldEstilo(nombreTextField, new int[]{20, 40, 420, 30}, this);

        paternoTextField = new JTextField();
        paternoTextField.addActionListener(this);
        estilo.textFieldEstilo(paternoTextField, new int[]{20, 110, 200, 30}, this);

        maternoTextField = new JTextField();
        maternoTextField.addActionListener(this);
        estilo.textFieldEstilo(maternoTextField, new int[]{240, 110, 200, 30}, this);

        edadTextField = new JTextField();
        edadTextField.addActionListener(this);
        estilo.textFieldEstilo(edadTextField, new int[]{20, 180, 200, 30}, this);

        curpTextField = new JTextField();
        curpTextField.addActionListener(this);
        estilo.textFieldEstilo(curpTextField, new int[]{240, 180, 200, 30}, this);

        //JLabel section Direccion class
        estilo.labelEstilo(new JLabel(), new int[]{20, 220, 150, 30}, StringUI.DIRECCION_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{20, 250, 150, 30}, StringUI.CALLE_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{240, 250, 150, 30}, StringUI.NUMERO_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{20, 320, 150, 30}, StringUI.COLONIA_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{240, 320, 150, 30}, StringUI.DELEGACION_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{20, 390, 150, 30}, StringUI.ESTADO_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{240, 390, 150, 30}, StringUI.CP_LABEL, this);

        //JTextField section direccion class
        calleTextField = new JTextField();
        calleTextField.addActionListener(this);
        estilo.textFieldEstilo(calleTextField, new int[]{20, 280, 200, 30}, this);

        numeroTextField = new JTextField();
        numeroTextField.addActionListener(this);
        estilo.textFieldEstilo(numeroTextField, new int[]{240, 280, 200, 30}, this);

        coloniaTextField = new JTextField();
        coloniaTextField.addActionListener(this);
        estilo.textFieldEstilo(coloniaTextField, new int[]{20, 350, 200, 30}, this);

        delegacionTextField = new JTextField();
        delegacionTextField.addActionListener(this);
        estilo.textFieldEstilo(delegacionTextField, new int[]{240, 350, 200, 30}, this);

        estadoTextField = new JTextField();
        estadoTextField.addActionListener(this);
        estilo.textFieldEstilo(estadoTextField, new int[]{20, 420, 200, 30}, this);

        cpTextField = new JTextField();
        cpTextField.addActionListener(this);
        estilo.textFieldEstilo(cpTextField, new int[]{240, 420, 200, 30}, this);

        //Save button
        nuevoUsuario = new JButton();
        nuevoUsuario.addActionListener(this);
        estilo.buttonEstilo(nuevoUsuario, new int[]{15, 470, 70, 40}, StringUI.NUEVO_BUTTON, this);

        enviarUsuario = new JButton();
        enviarUsuario.addActionListener(this);
        enviarUsuario.setEnabled(false);
        estilo.buttonEstilo(enviarUsuario, new int[]{95, 470, 70, 40}, StringUI.ENVIAR_BUTTON, this);

        anteriorUsuario = new JButton();
        anteriorUsuario.addActionListener(this);
        estilo.buttonEstilo(anteriorUsuario, new int[]{175, 470, 50, 40}, "<-", this);

        siguienteUsuario = new JButton();
        siguienteUsuario.addActionListener(this);
        estilo.buttonEstilo(siguienteUsuario, new int[]{235, 470, 50, 40}, "->", this);

        guardarButton = new JButton();
        guardarButton.addActionListener(this);
        estilo.buttonEstilo(guardarButton, new int[]{295, 470, 70, 40}, StringUI.GUARDAR_BUTTON, this);

        cargarButton = new JButton();
        cargarButton.addActionListener(this);
        estilo.buttonEstilo(cargarButton, new int[]{375, 470, 70, 40}, StringUI.CARGAR_BUTTON, this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == guardarButton){
            if(verificarCamposNoVacios())
                if(verificarCamposSonCorrectos()){
                    vaciarCampos();
                    Conector.getEmpleado().setNombre(nombreTextField.getText());
                    Conector.getEmpleado().setApellidoPaterno(paternoTextField.getText());
                    Conector.getEmpleado().setApellidoMaterno(maternoTextField.getText());
                    Conector.getEmpleado().setEdad(Integer.parseInt(edadTextField.getText().trim()));
                    Conector.getEmpleado().setCurp(curpTextField.getText());

                    Direccion direccion = new Direccion(calleTextField.getText(), numeroTextField.getText(), coloniaTextField.getText(), delegacionTextField.getText(), estadoTextField.getText(), cpTextField.getText());
                    Conector.getEmpleado().setDireccion(direccion);
                }
        }
        else if(actionEvent.getSource() == nuevoUsuario)
            vaciarCampos();
    }

    private boolean verificarCamposNoVacios(){
        if(nombreTextField.getText().isEmpty() || nombreTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.NOMBRE_CAMPO_VACIO);
        else if(paternoTextField.getText().isEmpty() || paternoTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.PATERNO_CAMPO_VACIO);
        else if(maternoTextField.getText().isEmpty() || maternoTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.MATERNO_CAMPO_VACIO);
        else if(edadTextField.getText().isEmpty() || edadTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.EDAD_CAMPO_VACIO);
        else if(curpTextField.getText().isEmpty() || curpTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.CURP_CAMPO_VACIO);
        else if(calleTextField.getText().isEmpty() || calleTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.CALLE_CAMPO_VACIO);
        else if(numeroTextField.getText().isEmpty() || numeroTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.NUMERO_CAMPO_VACIO);
        else if(coloniaTextField.getText().isEmpty() || coloniaTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.COLONIA_CAMPO_VACIO);
        else if(delegacionTextField.getText().isEmpty() || delegacionTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.DELEGACION_CAMPO_VACIO);
        else if(estadoTextField.getText().isEmpty() || estadoTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.ESTADO_CAMPO_VACIO);
        else if(cpTextField.getText().isEmpty() || cpTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.CP_CAMPO_VACIO);
        else
            return true;
        return false;
    }

    private boolean verificarCamposSonCorrectos(){
        int edad, numero;
        try{
            edad = Integer.parseInt(edadTextField.getText());
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, StringUI.EDAD_ES_NUMERO);
            System.out.println(error.getMessage());
            error.printStackTrace();
            return false;
        }
        try{
            numero = Integer.parseInt(numeroTextField.getText());
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, StringUI.NUMERO_ES_NUMERO);
            System.out.println(error.getMessage());
            error.printStackTrace();
            return false;
        }
        if(edad < 0 || edad > 100)
            JOptionPane.showMessageDialog(null, StringUI.EDAD_RANGO_CORRECTO);
        else if(numero < 0)
            JOptionPane.showMessageDialog(null, StringUI.NUMERO_RANGO_CORRECTO);
        else if(curpTextField.getText().length() != 18)
            JOptionPane.showMessageDialog(null, StringUI.CURP_LONGITUD_CORRECTA);
        else if(cpTextField.getText().length() != 5)
            JOptionPane.showMessageDialog(null, StringUI.CP_LONGITUD_CORRECTA);
        else
            return true;
        return false;
    }

    public void vaciarCampos(){
        nombreTextField.setText("");
        paternoTextField.setText("");
        maternoTextField.setText("");
        edadTextField.setText("");
        curpTextField.setText("");

        calleTextField.setText("");
        numeroTextField.setText("");
        coloniaTextField.setText("");
        delegacionTextField.setText("");
        estadoTextField.setText("");
        cpTextField.setText("");
    }
}
