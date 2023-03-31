package de.pondworth;

import javax.swing.*;

public abstract class Search {
    private Gui gui;

    Search(Gui gui) {
        this.gui = gui;
    }

    public void performSearch() {
        SwingUtilities.invokeLater(() -> {
            StringBuilder results = new StringBuilder();
            String[] searchFor = gui.search.getText().split(",");
            String[] lines = gui.jTextArea1.getText().split("\\n");
            int hits = 0;
            for (int i = 0; i < lines.length; i++) {
                for (int n = 0; n < searchFor.length; n++) {
                    if (lines[i].toUpperCase().contains(searchFor[n].toUpperCase())) {
                        hits += 1;
                        results
                                .append(hits)
                                .append(": ")
                                .append("Line " + i + 1 + " :")
                                .append(lines[i])
                                .append(System.getProperty("line.separator"));
                        break;
                    }
                }
            }
            gui.jTextArea1.setText(results.toString());
            gui.searchResults.setText("Results: " + hits + "entries");
        });
    }
}
