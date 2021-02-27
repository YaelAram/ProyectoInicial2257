package mx.unam.aragon.fes.gui;

import mx.unam.aragon.fes.estilo.Estilo;
import mx.unam.aragon.fes.estilo.StringUI;

import javax.swing.*;

public class AltaEmpleado {
    private final JFrame jFrame;

    public AltaEmpleado(){
        jFrame = new JFrame();
        Estilo estilo = new Estilo();
        estilo.frameEstilo(jFrame, StringUI.TITULO_VENTANA, WindowConstants.EXIT_ON_CLOSE, new int[]{1, 2, 470, 600});
        construirUI();
        jFrame.setVisible(true);
    }

    private void construirUI(){
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setBounds(0, 10, 470, 570);

        jTabbedPane.add(StringUI.TAB_REGISTRO_USUARIO, new RegistroEmpleado());
        jTabbedPane.add(StringUI.TAB_EMPRESA_DATOS, new Empresarial());

        jFrame.add(jTabbedPane);
    }
}
