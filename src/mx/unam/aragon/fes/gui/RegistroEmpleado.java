package mx.unam.aragon.fes.gui;

import mx.unam.aragon.fes.estilo.Estilo;
import mx.unam.aragon.fes.estilo.StringUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroEmpleado extends JPanel implements ActionListener {
    private final Estilo estilo = new Estilo();
    private JTextField nombreTextField, paternoTextField, maternoTextField, edadTextField, curpTextField;
    private JTextField calleTextField, numeroTextField, coloniaTextField, delegacionTextField, estadoTextField, cpTextField;

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
        nombreTextField.setName(StringUI.NOMBRE_EJEMPLO);
        estilo.textFieldEstilo(nombreTextField, new int[]{20, 40, 420, 30}, this);

        paternoTextField = new JTextField();
        paternoTextField.addActionListener(this);
        paternoTextField.setName(StringUI.PATERNO_EJEMPLO);
        estilo.textFieldEstilo(paternoTextField, new int[]{20, 110, 200, 30}, this);

        maternoTextField = new JTextField();
        maternoTextField.addActionListener(this);
        maternoTextField.setName(StringUI.MATERNO_EJEMPLO);
        estilo.textFieldEstilo(maternoTextField, new int[]{240, 110, 200, 30}, this);

        edadTextField = new JTextField();
        edadTextField.addActionListener(this);
        edadTextField.setName(StringUI.EDAD_EJEMPLO);
        estilo.textFieldEstilo(edadTextField, new int[]{20, 180, 200, 30}, this);

        curpTextField = new JTextField();
        curpTextField.addActionListener(this);
        curpTextField.setName(StringUI.CURP_EJEMPLO);
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
        calleTextField.setName(StringUI.CALLE_EJEMPLO);
        estilo.textFieldEstilo(calleTextField, new int[]{20, 280, 200, 30}, this);

        numeroTextField = new JTextField();
        numeroTextField.addActionListener(this);
        numeroTextField.setName(StringUI.NUMERO_EJEMPLO);
        estilo.textFieldEstilo(numeroTextField, new int[]{240, 280, 200, 30}, this);

        coloniaTextField = new JTextField();
        coloniaTextField.addActionListener(this);
        coloniaTextField.setName(StringUI.COLONIA_EJEMPLO);
        estilo.textFieldEstilo(coloniaTextField, new int[]{20, 350, 200, 30}, this);

        delegacionTextField = new JTextField();
        delegacionTextField.addActionListener(this);
        delegacionTextField.setName(StringUI.DELEGACION_EJEMPLO);
        estilo.textFieldEstilo(delegacionTextField, new int[]{240, 350, 200, 30}, this);

        estadoTextField = new JTextField();
        estadoTextField.addActionListener(this);
        estadoTextField.setName(StringUI.ESTADO_EJEMPLO);
        estilo.textFieldEstilo(estadoTextField, new int[]{20, 420, 200, 30}, this);

        cpTextField = new JTextField();
        cpTextField.addActionListener(this);
        cpTextField.setName(StringUI.CP_EJEMPLO);
        estilo.textFieldEstilo(cpTextField, new int[]{240, 420, 200, 30}, this);

        //Save button
        JButton guardarButton = new JButton();
        guardarButton.addActionListener(this);
        estilo.buttonEstilo(guardarButton, new int[]{80, 470, 300, 40}, StringUI.GUARDAR_BUTTON, this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(verificarCamposNoVacios())
            if(verificarCamposSonCorrectos())
                JOptionPane.showMessageDialog(null, "Ok");
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
}
