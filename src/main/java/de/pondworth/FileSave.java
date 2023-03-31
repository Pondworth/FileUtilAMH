package de.pondworth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileSave implements ActionListener {
    private final Gui gui;

    public FileSave(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser chooserSave = new JFileChooser();
        //chooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
//        chooserSave.showSaveDialog(null);

        int retval = chooserSave.showSaveDialog(gui.saveButton);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = chooserSave.getSelectedFile();
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try {
                gui.jTextArea1.write(new OutputStreamWriter(new FileOutputStream(file),
                        "utf-8"));
                Desktop.getDesktop().open(file);
                //JOptionPane.showMessageDialog(savedMessage, "Save as file: " + file.getAbsolutePath());
                gui.savedMessage.setText("Save as file: " + file.getAbsolutePath());

            } catch (Exception es) {
                JOptionPane.showMessageDialog(null, es.getMessage());
                es.printStackTrace();
            }
        }
    }
}