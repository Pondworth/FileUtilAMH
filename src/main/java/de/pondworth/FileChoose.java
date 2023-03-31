package de.pondworth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileChoose implements ActionListener {
    private JTextArea area;

    public FileChoose(JTextArea textArea) {
        this.area = textArea;
    }
    // Dependency Injection
//    textArea ist dafür da damit actionPerformed lesen
//    Und den Focus darauf legen kann
//
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getName();

        try {
            FileReader reader = new FileReader(f);
            BufferedReader br = new BufferedReader(reader);
            area.read(br, null);
            br.close();
            area.requestFocus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, e);//center
            ex.printStackTrace();
        }
    }
}
