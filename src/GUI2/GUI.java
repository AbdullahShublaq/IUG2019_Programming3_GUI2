/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Abdullah Shublaq
 */
public class GUI extends JFrame {

    JList<String> list;
    JButton b1;
    JTextArea area;

    public GUI() {
        DefaultListModel<String> deflist = new DefaultListModel<>();
        list = new JList<>(deflist);
        list.setPreferredSize(new Dimension(100, 100));
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(!list.isSelectionEmpty()){
                    area.setText("");
                }
            }
        });
        deflist.addElement("Black");
        deflist.addElement("Blue");
        deflist.addElement("Cyan");
        deflist.addElement("Dark Gray");
        deflist.addElement("Gray");
        JScrollPane scrolllist = new JScrollPane(list);
        scrolllist.setPreferredSize(new Dimension(120, 100));
        add(scrolllist);

        b1 = new JButton("Copy>>>");
        b1.setFocusPainted(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                List<String> Select = list.getSelectedValuesList();
                System.out.println(Select.size());
                for (String item : Select) {
                    area.setText(area.getText() + item + "\n");
                }
            }
        });
        add(b1);

        area = new JTextArea();
        area.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(90, 90));
        add(scroll);

        setTitle("Multiple Selection Lists");
        setSize(500, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
