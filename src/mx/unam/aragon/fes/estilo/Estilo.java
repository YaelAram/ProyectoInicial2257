package mx.unam.aragon.fes.estilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Estilo implements FocusListener, MouseListener {
    private final Color greyLight = new Color(230, 230, 230);
    private final Color grey = new Color(212, 212, 212);
    private final Color greyDark = new Color(55, 58, 64);
    private final Color black = new Color(0, 0, 0);
    private final Font primaryFont = new Font("Roboto", Font.PLAIN, 16);
    private final Font primaryFontBold = new Font("Roboto", Font.BOLD, 16);
    private final Font secondaryFont = new Font("Roboto", Font.BOLD, 13);
    private JFrame jFrame;

    //Styling Method JFrame
    public void frameEstilo(JFrame jFrame, String title, int exitMode, int[] bound){
        jFrame.setBounds(bound[0], bound[1], bound[2], bound[3]);
        jFrame.setTitle(title);
        jFrame.getContentPane().setBackground(this.greyLight);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(exitMode);
        jFrame.setLocationRelativeTo(null);
        this.jFrame = jFrame;
    }

    //Styling Method JPanel
    public void panelEstilo(JPanel jPanel){
        jPanel.setLayout(null);
        jPanel.setBackground(this.greyLight);
    }

    //Styling Method JLabel
    public void labelEstilo(JLabel jLabel, int[] bound, String text){
        jLabel.setBounds(bound[0], bound[1], bound[2], bound[3]);
        jLabel.setText(text);
        jLabel.setForeground(this.black);
        jLabel.setFont(this.secondaryFont);
        jFrame.add(jLabel);
    }

    //Styling Methods JTextField
    public void activoTextFieldEstilo(JTextField jTextField){
        jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, this.greyDark));
        jTextField.setBackground(this.greyLight);
        jTextField.setForeground(this.black);
    }

    public void inactivoTextFieldEstilo(JTextField jTextField){
        jTextField.setBorder(BorderFactory.createEmptyBorder(0,0,1,0));
        jTextField.setBackground(this.grey);
        jTextField.setForeground(this.greyDark);
    }

    public void textFieldEstilo(JTextField jTextField, int[] bound){
        jTextField.setBounds(bound[0], bound[1], bound[2], bound[3]);
        jTextField.setFont(this.primaryFont);
        jTextField.setForeground(this.black);
        inactivoTextFieldEstilo(jTextField);
        jTextField.setText(jTextField.getName());
        jTextField.addFocusListener(this);
        jFrame.add(jTextField);
    }

    //Styling Methods JButton
    public void activoButtonEstilo(JButton jButton){
        jButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, this.greyDark));
        jButton.setBackground(this.greyDark);
        jButton.setForeground(this.greyLight);
    }

    public void inactivoButtonEstilo(JButton jButton){
        jButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, this.greyDark));
        jButton.setBackground(this.greyLight);
        jButton.setForeground(this.greyDark);
    }

    public void buttonEstilo(JButton jButton, int[] bound, String text){
        jButton.setBounds(bound[0], bound[1], bound[2], bound[3]);
        jButton.setText(text);
        jButton.setFocusable(false);
        jButton.setFont(this.primaryFontBold);
        inactivoButtonEstilo(jButton);
        jButton.addMouseListener(this);
        jFrame.add(jButton);
    }

    //Focus Events
    @Override
    public void focusGained(FocusEvent focusEvent) {
        try{
            activoTextFieldEstilo((JTextField) focusEvent.getSource());
        }
        catch (Exception error){
            System.out.println(error.getMessage());
            error.printStackTrace();
        }
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        try{
            inactivoTextFieldEstilo((JTextField) focusEvent.getSource());
        }
        catch (Exception error){
            System.out.println(error.getMessage());
            error.printStackTrace();
        }
    }

    //Mouse Events
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        try{
            activoButtonEstilo((JButton) mouseEvent.getSource());
        }
        catch (Exception error){
            System.out.println(error.getMessage());
            error.printStackTrace();
        }
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        try{
            inactivoButtonEstilo((JButton) mouseEvent.getSource());
        }
        catch (Exception error){
            System.out.println(error.getMessage());
            error.printStackTrace();
        }
    }
}
