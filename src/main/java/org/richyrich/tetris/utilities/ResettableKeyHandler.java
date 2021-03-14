package org.richyrich.tetris.utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ResettableKeyHandler extends KeyAdapter {
    private int keyCode;
    private boolean buttonPressed = false;

    public ResettableKeyHandler(int keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == keyCode){
            buttonPressed = true;
        }
    }

    public boolean checkAndReset(){
        boolean currentState = buttonPressed;
        buttonPressed = false;
        return currentState;
    }
}
