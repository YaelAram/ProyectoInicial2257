package mx.unam.aragon.fes.gui;

import mx.unam.aragon.fes.Direccion;
import mx.unam.aragon.fes.Empleado;
import mx.unam.aragon.fes.estilo.Estilo;
import mx.unam.aragon.fes.estilo.StringUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaEmpleado implements ActionListener {
    private final Estilo estilo = new Estilo();
    private JTextField nombreTextField, paternoTextField, maternoTextField, edadTextField, curpTextField;
    private JTextField calleTextField, numeroTextField, coloniaTextField, delegacionTextField, estadoTextField, cpTextField;
    private JTextField numeroEmpleadoTextField, departamentoTextField, sueldoTextField, horasExtraTextField;
    private JButton guardarButton, cargarButton, siguienteUsuario, anteriorUsuario, nuevoUsuario, enviarUsuario;


    public AltaEmpleado(){
        JFrame jFrame = new JFrame();
        estilo.frameEstilo(jFrame, StringUI.TITULO_VENTANA, WindowConstants.EXIT_ON_CLOSE, new int[]{1, 2, 690, 580});
        construirUI();
        jFrame.setVisible(true);
    }

    private void construirUI(){
        //JLabel section Persona class
        estilo.labelEstilo(new JLabel(), new int[]{20, 10, 100, 30}, StringUI.NOMBRE_LABEL_TEXT);
        estilo.labelEstilo(new JLabel(), new int[]{240, 10, 150, 30}, StringUI.APELLIDO_PATERNO_LABEL_TEXT);
        estilo.labelEstilo(new JLabel(), new int[]{460, 10, 150, 30}, StringUI.APELLIDO_MATERNO_LABEL_TEXT);
        estilo.labelEstilo(new JLabel(), new int[]{20, 80, 100, 30}, StringUI.EDAD_LABEL_TEXT);
        estilo.labelEstilo(new JLabel(), new int[]{240, 80, 100, 30}, StringUI.CURP_LABEL_TEXT);

        //JTextField section Persona class
        nombreTextField = new JTextField();
        nombreTextField.addActionListener(this);
        estilo.textFieldEstilo(nombreTextField, new int[]{20, 40, 200, 30});

        paternoTextField = new JTextField();
        paternoTextField.addActionListener(this);
        estilo.textFieldEstilo(paternoTextField, new int[]{240, 40, 200, 30});

        maternoTextField = new JTextField();
        maternoTextField.addActionListener(this);
        estilo.textFieldEstilo(maternoTextField, new int[]{460, 40, 200, 30});

        edadTextField = new JTextField();
        edadTextField.addActionListener(this);
        estilo.textFieldEstilo(edadTextField, new int[]{20, 110, 200, 30});

        curpTextField = new JTextField();
        curpTextField.addActionListener(this);
        estilo.textFieldEstilo(curpTextField, new int[]{240, 110, 200, 30});

        //JLabel section Direccion class
        estilo.labelEstilo(new JLabel(), new int[]{20, 150, 150, 30}, StringUI.DIRECCION_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{20, 170, 150, 30}, StringUI.CALLE_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{240, 170, 150, 30}, StringUI.NUMERO_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{460, 170, 150, 30}, StringUI.COLONIA_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{20, 240, 150, 30}, StringUI.DELEGACION_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{240, 240, 150, 30}, StringUI.ESTADO_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{460, 240, 150, 30}, StringUI.CP_LABEL);

        //JTextField section direccion class
        calleTextField = new JTextField();
        calleTextField.addActionListener(this);
        estilo.textFieldEstilo(calleTextField, new int[]{20, 200, 200, 30});

        numeroTextField = new JTextField();
        numeroTextField.addActionListener(this);
        estilo.textFieldEstilo(numeroTextField, new int[]{240, 200, 200, 30});

        coloniaTextField = new JTextField();
        coloniaTextField.addActionListener(this);
        estilo.textFieldEstilo(coloniaTextField, new int[]{460, 200, 200, 30});

        delegacionTextField = new JTextField();
        delegacionTextField.addActionListener(this);
        estilo.textFieldEstilo(delegacionTextField, new int[]{20, 270, 200, 30});

        estadoTextField = new JTextField();
        estadoTextField.addActionListener(this);
        estilo.textFieldEstilo(estadoTextField, new int[]{240, 270, 200, 30});

        cpTextField = new JTextField();
        cpTextField.addActionListener(this);
        estilo.textFieldEstilo(cpTextField, new int[]{460, 270, 200, 30});

        //JLabel section Empleado class
        estilo.labelEstilo(new JLabel(), new int[]{20, 310, 150, 30}, StringUI.EMPLEADO_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{20, 330, 150, 30}, StringUI.NUMERO_EMPLEADO_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{240, 330, 150, 30}, StringUI.DEPARTAMENTO_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{460, 330, 150, 30}, StringUI.SUELDO_LABEL);
        estilo.labelEstilo(new JLabel(), new int[]{20, 400, 150, 30}, StringUI.HORAS_EXTRA_LABEL);

        //JTextField section Empleado class
        numeroEmpleadoTextField = new JTextField();
        estilo.textFieldEstilo(numeroEmpleadoTextField, new int[]{20, 360, 200, 30});

        departamentoTextField = new JTextField();
        estilo.textFieldEstilo(departamentoTextField, new int[]{240, 360, 200, 30});

        sueldoTextField = new JTextField();
        estilo.textFieldEstilo(sueldoTextField, new int[]{460, 360, 200, 30});

        horasExtraTextField = new JTextField();
        estilo.textFieldEstilo(horasExtraTextField, new int[]{20, 430, 200, 30});

        //Save button
        nuevoUsuario = new JButton();
        nuevoUsuario.addActionListener(this);
        estilo.buttonEstilo(nuevoUsuario, new int[]{20, 490, 130, 40}, StringUI.NUEVO_BUTTON);

        enviarUsuario = new JButton();
        enviarUsuario.addActionListener(this);
        enviarUsuario.setEnabled(false);
        estilo.buttonEstilo(enviarUsuario, new int[]{160, 490, 130, 40}, StringUI.ENVIAR_BUTTON);

        anteriorUsuario = new JButton();
        anteriorUsuario.addActionListener(this);
        estilo.buttonEstilo(anteriorUsuario, new int[]{300, 490, 35, 40}, StringUI.ANTERIOR_BUTTON);

        siguienteUsuario = new JButton();
        siguienteUsuario.addActionListener(this);
        estilo.buttonEstilo(siguienteUsuario, new int[]{345, 490, 35, 40}, StringUI.SIGUIENTE_BUTTON);

        guardarButton = new JButton();
        guardarButton.addActionListener(this);
        estilo.buttonEstilo(guardarButton, new int[]{390, 490, 130, 40}, StringUI.GUARDAR_BUTTON);

        cargarButton = new JButton();
        cargarButton.addActionListener(this);
        estilo.buttonEstilo(cargarButton, new int[]{530, 490, 130, 40}, StringUI.CARGAR_BUTTON);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == guardarButton){
            if(verificarCamposNoVacios())
                if(verificarCamposSonCorrectos()){

                    Empleado empleado = new Empleado();

                    empleado.setNombre(nombreTextField.getText());
                    empleado.setApellidoPaterno(paternoTextField.getText());
                    empleado.setApellidoMaterno(maternoTextField.getText());
                    empleado.setEdad(Integer.parseInt(edadTextField.getText()));
                    empleado.setCurp(curpTextField.getText());

                    empleado.setDireccion(new Direccion(calleTextField.getText(), numeroTextField.getText(), coloniaTextField.getText(), delegacionTextField.getText(), estadoTextField.getText(), cpTextField.getText()));

                    empleado.setNumeroEmpleado(Integer.parseInt(numeroEmpleadoTextField.getText()));
                    empleado.setDepartamento(departamentoTextField.getText());
                    empleado.setSueldo(Double.parseDouble(sueldoTextField.getText()));
                    empleado.setHorasExtra(Integer.parseInt(horasExtraTextField.getText()));

                    int confirmacion = JOptionPane.showConfirmDialog(null, StringUI.CONFIRMAR_LABEL);
                    System.out.println(confirmacion);
                    System.out.println(empleado.toString());

                    vaciarCampos();
                }
        }
        else if(actionEvent.getSource() == nuevoUsuario)
            vaciarCampos();
        else if(actionEvent.getSource() == cargarButton)
            JOptionPane.showMessageDialog(null, StringUI.CARGAR_BUTTON);
        else if(actionEvent.getSource() == anteriorUsuario)
            JOptionPane.showMessageDialog(null, StringUI.ANTERIOR_BUTTON);
        else if(actionEvent.getSource() == siguienteUsuario)
            JOptionPane.showMessageDialog(null, StringUI.SIGUIENTE_BUTTON);
        else if(actionEvent.getSource() == enviarUsuario)
            JOptionPane.showMessageDialog(null, StringUI.ENVIAR_BUTTON);
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
        else if(numeroEmpleadoTextField.getText().isEmpty() || numeroEmpleadoTextField.getText().isBlank())
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

    private boolean verificarCamposSonCorrectos(){
        int edad, numero, numeroEmpleado, horasExtra;
        double sueldo;

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

        if(edad < 0 || edad > 100)
            JOptionPane.showMessageDialog(null, StringUI.EDAD_RANGO_CORRECTO);
        else if(numero < 0)
            JOptionPane.showMessageDialog(null, StringUI.NUMERO_RANGO_CORRECTO);
        else if(curpTextField.getText().length() != 18)
            JOptionPane.showMessageDialog(null, StringUI.CURP_LONGITUD_CORRECTA);
        else if(cpTextField.getText().length() != 5)
            JOptionPane.showMessageDialog(null, StringUI.CP_LONGITUD_CORRECTA);
        else if(numeroEmpleado < 0)
            JOptionPane.showMessageDialog(null, StringUI.NUMERO_EMPLEADO_RANGO_CORRECTO);
        else if(horasExtra < 0)
            JOptionPane.showMessageDialog(null, StringUI.HORAS_EXTRA_RANGO_CORRECTO);
        else if(sueldo < 0)
            JOptionPane.showMessageDialog(null, StringUI.SUELDO_RANGO_CORRECTO);
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

        numeroEmpleadoTextField.setText("");
        departamentoTextField.setText("");
        sueldoTextField.setText("");
        horasExtraTextField.setText("");
    }
}
