package org.richyrich.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu implements ActionListener{
    JButton startButton;
    ImageIcon buttonBg;

    private boolean isGameStarted;

    public MainMenu(JFrame frame) {
        buttonBg = new ImageIcon("src/main/res/baton.png");
        isGameStarted = false;

        startButton = new JButton("Start", buttonBg);

        startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        startButton.setForeground(Color.yellow);
        startButton.setFont(new Font("Comic Sans MS", (Font.BOLD), 16));

        startButton.setBounds(150,200,300,150);
        startButton.setActionCommand("Start");

        startButton.setBackground(Color.red);
        startButton.setFocusable(false);

        startButton.addActionListener(this);

        frame.add(startButton);
    }

    public boolean isGameStarted(){
        boolean start = isGameStarted;
        isGameStarted = false;
        return start;
    }

    public void update(int timePassed) {
        startButton.setVisible(true);
    }

    public void render(Graphics2D g) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Start".equals(e.getActionCommand())) {
            System.out.println("STARTED");
            isGameStarted = true;
            startButton.setVisible(false);
        }else{
            System.out.println("No");
        }
    }
}
