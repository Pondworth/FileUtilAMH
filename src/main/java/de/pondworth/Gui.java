package de.pondworth;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Pondworth
 * I am done.
 * your text is my text
 * Thx to Griefed <3
 */
public class Gui extends JFrame {
    JLabel textHeader;
    JButton searchButton;
    JButton fileButton;
    JTextArea jTextArea1 = new JTextArea(); //gbc?
    JScrollPane scroll;
    JLabel searchResults;
    JButton saveButton;
    JLabel savedMessage;
    JTextField search;

    //Mainframe
    public Gui() {
        //setLayout(null); //deactivate Layoutmanager (absolute position)
        setLayout(new FlowLayout()); //predefined layouts
        setSize(800, 600);
        setPreferredSize(new Dimension(800, 600));
        setTitle("File Util AMH"); //super("Frametitle");
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        //panel.setPreferredSize(new Dimension(1000,550));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, 1, 1, 1); //Space between collumns
        setContentPane(panel);
        getContentPane().setPreferredSize(new Dimension(800, 600));

        textHeader = new JLabel("File Util AMH");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        Font font = new Font("Arial", Font.BOLD, 22);
        textHeader.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        textHeader.setFont(font);
        panel.add(textHeader, gbc);

        fileButton = new JButton("File");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        fileButton.addActionListener(new FileChoose(jTextArea1));
        panel.add(fileButton, gbc);

        search = new JTextField("");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        //search.setToolTipText("Enter your search");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        search.addKeyListener(new EnterListener(this));
        panel.add(search, gbc);

        searchButton = new JButton("Go!");
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        searchButton.addActionListener(new SearchAL(this));
        panel.add(searchButton, gbc);

        jTextArea1.setEditable(false);
        scroll = new JScrollPane(jTextArea1);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.gridheight = 10;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll, gbc);
        setLocationRelativeTo(null);

        searchResults = new JLabel("Results: ");
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(searchResults, gbc);

        saveButton = new JButton("Save");
        gbc.gridx = 4;
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        saveButton.addActionListener(new FileSave(this));
        panel.add(saveButton, gbc);

        savedMessage = new JLabel("");
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        savedMessage.setForeground(new Color(51, 102, 0));
        panel.add(savedMessage, gbc);

        //int x =0;
        //x++ = x +1
        setVisible(true); //am Ende, damit die vorherige Funktion durchlaufen kann
    }
}