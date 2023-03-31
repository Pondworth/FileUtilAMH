package de.pondworth;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EnterListener extends Search implements KeyListener {

    EnterListener(Gui gui) {
        super(gui);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            performSearch();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
