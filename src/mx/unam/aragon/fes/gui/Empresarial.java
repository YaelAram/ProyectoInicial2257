package mx.unam.aragon.fes.gui;

import mx.unam.aragon.fes.estilo.Estilo;
import mx.unam.aragon.fes.estilo.StringUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Empresarial extends JPanel implements ActionListener {
    private final Estilo estilo = new Estilo();
    private JTextField numeroEmpleadoTextField, departamentoTextField, sueldoTextField, horasExtraTextField;
    private JButton guardarButton;

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
        numeroEmpleadoTextField.setName(StringUI.NUMERO_EMPLEADO_EJEMPLO);
        estilo.textFieldEstilo(numeroEmpleadoTextField, new int[]{20, 40, 420, 30}, this);

        departamentoTextField = new JTextField();
        departamentoTextField.setName(StringUI.DEPARTAMENTO_EJEMPLO);
        estilo.textFieldEstilo(departamentoTextField, new int[]{20, 110, 420, 30}, this);

        sueldoTextField = new JTextField();
        sueldoTextField.setName(StringUI.SUELDO_EJEMPLO);
        estilo.textFieldEstilo(sueldoTextField, new int[]{20, 180, 420, 30}, this);

        horasExtraTextField = new JTextField();
        horasExtraTextField.setName(StringUI.HORAS_EXTRA_EJEMPLO);
        estilo.textFieldEstilo(horasExtraTextField, new int[]{20, 250, 420, 30}, this);

        //JButton section
        guardarButton = new JButton();
        guardarButton.addActionListener(this);
        estilo.buttonEstilo(guardarButton, new int[]{20, 470, 200, 40}, StringUI.GUARDAR_BUTTON, this);

        JButton cargarButton = new JButton();
        cargarButton.addActionListener(this);
        estilo.buttonEstilo(cargarButton, new int[]{230, 470, 200, 40}, StringUI.CARGAR_BUTTON, this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try{
            if(actionEvent.getSource() == guardarButton){
                if(verificarCamposNoVacios())
                    if(verificarCamposSonCorrectos())
                        JOptionPane.showMessageDialog(null, "OK");
            }
            else
                JOptionPane.showMessageDialog(null, "OK");
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
}
