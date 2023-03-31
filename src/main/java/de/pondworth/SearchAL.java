package de.pondworth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchAL extends Search implements ActionListener {
    SearchAL(Gui gui) {
        super(gui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        performSearch();
    }
}