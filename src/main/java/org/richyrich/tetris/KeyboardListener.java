package org.richyrich.tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
    String input = "";

    @Override
    public void keyPressed(KeyEvent event) {
        char inputChar = event.getKeyChar();
        int inputCode = event.getKeyCode();
        if((inputChar >= '0' && inputChar <= '9') || (inputChar >= 'A' && inputChar <= 'Z') || (inputChar >= 'a' && inputChar <= 'z')) {
            input += event.getKeyChar();
        } else if(inputCode == KeyEvent.VK_BACK_SPACE && (input.length() != 0)){
            input = input.substring(0,input.length()-1);
        //  input = input.substring(0,input.length()-((input.length() == 0): 0, 1));
        }
    }

    public String getInput() {
        return input;
    }
}
