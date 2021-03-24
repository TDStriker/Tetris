package org.richyrich.tetris;

import org.richyrich.tetris.utilities.MouseClickListener;
import org.richyrich.tetris.utilities.TetrisSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu {
    JButton startButton;
    ImageIcon buttonBg;
    MouseClickListener listener;

    private boolean isGameStarted;

    public MainMenu(MouseClickListener listener) {
        buttonBg = new ImageIcon("src/main/res/baton.png");
        isGameStarted = false;
        this.listener = listener;


        startButton = new JButton("Start", buttonBg);
        startButton.setHorizontalTextPosition(SwingConstants.CENTER);

        startButton.setBounds(0,0,300,150);
//        startGame.setSize(100,50);
        startButton.setActionCommand("Start");

        startButton.setBackground(Color.red);

        startButton.addMouseListener(listener);
    }

    public void actionPerformed() {
        try {

            if (startButton.equals(listener.getClickOrigin())) {
                System.out.println("hello");
            } else {
//            System.out.println("rude");
            }
        }catch(NullPointerException npe){

        }
    }

    public boolean isGameStarted(){
        return false;
    }

    public void update(int timePassed) {
        actionPerformed();
    }

    public void render(Graphics2D g) {
        startButton.paint(g);
        startButton.setVisible(true);
    }
}
