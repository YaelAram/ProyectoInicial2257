package mx.unam.aragon.fes.gui;

import mx.unam.aragon.fes.conector.Conector;
import mx.unam.aragon.fes.estilo.Estilo;
import mx.unam.aragon.fes.estilo.StringUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Empresarial extends JPanel implements ActionListener {
    private final Estilo estilo = new Estilo();
    private JTextField numeroEmpleadoTextField, departamentoTextField, sueldoTextField, horasExtraTextField;
    private JButton guardarButton, cargarButton, siguienteUsuario, anteriorUsuario, nuevoUsuario, enviarUsuario;

    public Empresarial(){
        estilo.panelEstilo(this);
        contruirUI();
    }

    private void contruirUI(){
        //JLabel section Empleado class
        estilo.labelEstilo(new JLabel(), new int[]{20, 10, 150, 30}, StringUI.NUMERO_EMPLEADO_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{20, 80, 150, 30}, StringUI.DEPARTAMENTO_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{20, 150, 150, 30}, StringUI.SUELDO_LABEL, this);
        estilo.labelEstilo(new JLabel(), new int[]{20, 220, 150, 30}, StringUI.HORAS_EXTRA_LABEL, this);

        //JTextField section Empleado class
        numeroEmpleadoTextField = new JTextField();
        estilo.textFieldEstilo(numeroEmpleadoTextField, new int[]{20, 40, 420, 30}, this);

        departamentoTextField = new JTextField();
        estilo.textFieldEstilo(departamentoTextField, new int[]{20, 110, 420, 30}, this);

        sueldoTextField = new JTextField();
        estilo.textFieldEstilo(sueldoTextField, new int[]{20, 180, 420, 30}, this);

        horasExtraTextField = new JTextField();
        estilo.textFieldEstilo(horasExtraTextField, new int[]{20, 250, 420, 30}, this);

        //JButton section
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
        try{
            if(actionEvent.getSource() == guardarButton){
                if(verificarCamposNoVacios())
                    if(verificarCamposSonCorrectos()){
                        Conector.getEmpleado().setHorasExtra(Integer.parseInt(horasExtraTextField.getText()));
                        Conector.getEmpleado().setDepartamento(departamentoTextField.getText());
                        Conector.getEmpleado().setNumeroEmpleado(Integer.parseInt(numeroEmpleadoTextField.getText()));
                        Conector.getEmpleado().setSueldo(Double.parseDouble(sueldoTextField.getText()));

                        System.out.println(Conector.getEmpleado().toString());
                    }
            }
            else if(actionEvent.getSource() == nuevoUsuario)
                vaciarCampos();
        }
        catch (Exception error){
            System.out.println("Error: " + error.getMessage());
            error.printStackTrace();
        }
    }

    public boolean verificarCamposNoVacios(){
        if(numeroEmpleadoTextField.getText().isEmpty() || numeroEmpleadoTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.NUMERO_EMPLEADO_CAMPO_VACIO);
        else if(departamentoTextField.getText().isEmpty() || departamentoTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.DEPARTAMENTO_CAMPO_VACIO);
        else if(sueldoTextField.getText().isEmpty() || sueldoTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.SUELDO_CAMPO_VACIO);
        else if(horasExtraTextField.getText().isEmpty() || horasExtraTextField.getText().isBlank())
            JOptionPane.showMessageDialog(null, StringUI.HORAS_EXTRA_CAMPO_VACIO);
        else
            return true;
        return false;
    }

    public boolean verificarCamposSonCorrectos(){
        int numeroEmpleado, horasExtra;
        double sueldo;

        try{
            numeroEmpleado = Integer.parseInt(numeroEmpleadoTextField.getText());
        }
        catch (Exception error){
            System.out.println("Error: " + error.getMessage());
            error.printStackTrace();
            return false;
        }
        try{
            horasExtra = Integer.parseInt(horasExtraTextField.getText());
        }
        catch (Exception error){
            System.out.println("Error: " + error.getMessage());
            error.printStackTrace();
            return false;
        }
        try{
            sueldo = Double.parseDouble(sueldoTextField.getText());
        }
        catch (Exception error){
            System.out.println("Error: " + error.getMessage());
            error.printStackTrace();
            return false;
        }

        if(numeroEmpleado < 0)
            JOptionPane.showMessageDialog(null, StringUI.NUMERO_EMPLEADO_RANGO_CORRECTO);
        else if(horasExtra < 0)
            JOptionPane.showMessageDialog(null, StringUI.HORAS_EXTRA_RANGO_CORRECTO);
        else if(sueldo < 0)
            JOptionPane.showMessageDialog(null, StringUI.SUELDO_RANGO_CORRECTO);
        else
            return true;

        return true;
    }

    public void vaciarCampos(){
        numeroEmpleadoTextField.setText("");
        departamentoTextField.setText("");
        sueldoTextField.setText("");
        horasExtraTextField.setText("");
    }
}
