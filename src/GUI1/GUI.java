/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Abdullah Shublaq
 */
public class GUI extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField field;
    JRadioButton button1, button2;

    public GUI() {
        label1 = new JLabel("Enter Celsius temperature:");
        label1.setAlignmentX(CENTER_ALIGNMENT);
        label1.setAlignmentY(CENTER_ALIGNMENT);
        add(label1);

        field = new JTextField(20);
        add(field);

        button1 = new JRadioButton("Fahrenheit");
        button1.addActionListener(this);
        button2 = new JRadioButton("Kelvin");
        button2.addActionListener(this);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        JPanel jPanel = new JPanel(new FlowLayout());
        jPanel.add(button1);
        jPanel.add(button2);
        add(jPanel);

        label2 = new JLabel("New Temperature in is : ");
        label3 = new JLabel("...");
        JPanel jPanel1 = new JPanel(new FlowLayout());
        jPanel1.add(label2);
        jPanel1.add(label3);
        add(jPanel1);

        setTitle("Temperature Conversion ");
        setSize(300, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String command = e.getActionCommand();
        Double result;
        switch (command) {
            case "Fahrenheit":
                try {
                    result = Double.parseDouble(field.getText()) * 9 / 5 + 32;
                    label3.setText(result.toString());
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case "Kelvin":
                try {
                    result = Integer.parseInt(field.getText()) + 273.15;
                    label3.setText(result.toString());
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
        }
    }
}
