/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Abdullah Shublaq
 */
public class GUI extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu File, Edit;
    JMenuItem open, close, exit, font, color, save;
    JTextArea area;
    File file;

    public GUI() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        File = new JMenu("File");
        menuBar.add(File);
        open = new JMenuItem("Open");
        open.setMnemonic('O');
        open.addActionListener(this);
        save = new JMenuItem("Save");
        save.setMnemonic('S');
        save.addActionListener(this);
        close = new JMenuItem("Close");
        close.setMnemonic('C');
        close.addActionListener(this);
        exit = new JMenuItem("Exit");
        exit.setMnemonic('E');
        exit.addActionListener(this);
        File.add(open);
        File.add(save);
        File.add(close);
        File.addSeparator();
        File.add(exit);

        Edit = new JMenu("Edit");
        menuBar.add(Edit);
        font = new JMenuItem("Font");
        font.setMnemonic('F');
        font.addActionListener(this);
        color = new JMenuItem("Color");
        color.setMnemonic('C');
        color.addActionListener(this);
        Edit.add(font);
        Edit.add(color);

        area = new JTextArea("DEFAULT TEXT...");
        area.setEditable(false);
        area.setLineWrap(true);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(350, 235));
        add(scroll);

        setTitle("File Processing");
        setSize(365, 300);
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
        switch (command) {
            case "Open":
                try {
                    System.out.println("open");
                    JFileChooser chooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
                            ".txt", "txt");
                    chooser.setFileFilter(filter);

                    int returnVal = chooser.showOpenDialog(GUI.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        System.out.println("You chose to open this file: "
                                + chooser.getSelectedFile().getName());
                    }
                    file = chooser.getSelectedFile();
                    if (file != null) {
                        Scanner in = new Scanner(file);
                        String s;
                        area.setText("");
                        while (in.hasNextLine()) {
                            area.append(in.nextLine() + "\n");
                        }
                        area.setEditable(true);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Save":
                System.out.println("Save");
                 {
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        OutputStreamWriter osw = new OutputStreamWriter(fos);
                        PrintWriter pw = new PrintWriter(osw);
                        pw.println(area.getText());
                        
                        pw.flush();
                        
                        fos.close();
                        osw.close();
                        pw.close();
                    } catch (Exception ex) {
                        System.out.println(ex.getStackTrace());
                    }
                }

                break;
            case "Close":
                System.out.println("close");
                area.setText("DEFAULT TEXT...");
                area.setEditable(false);
                area.setForeground(Color.BLACK);
                area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
                break;
            case "Exit":
                System.out.println("exit");
                System.exit(0);
                break;
            case "Font":
                System.out.println("font");
                String s = (String) JOptionPane.showInputDialog(
                        null,
                        "Choose Font Size",
                        "Font Size",
                        JOptionPane.INFORMATION_MESSAGE,
                        null, //icon object
                        new String[]{"12", "14", "18", "24", "30", "63", "48", "60", "72", "84"}, //list  items
                        "Blue" //defalut selected item in the list
                );
                System.out.println(s);
                if (s != null) {
                    area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, Integer.parseInt(s)));
                }
                break;
            case "Color":
                System.out.println("color");
                Color selectedColor = JColorChooser.showDialog(GUI.this, "a", color.getBackground()); //modal
                System.out.println(selectedColor);
                if (selectedColor != null) {
                    area.setForeground(selectedColor);
                }
                break;
            default:
                break;
        }
    }
}
