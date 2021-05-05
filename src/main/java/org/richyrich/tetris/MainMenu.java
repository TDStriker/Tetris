package org.richyrich.tetris;

import org.richyrich.tetris.utilities.CustomImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MainMenu implements ActionListener{
    JButton startButton;
    CustomImage buttonBg;

    private boolean isGameStarted;

    public MainMenu(JFrame frame) {
        try{
            buttonBg = new CustomImage(ImageIO.read(new File("src/main/res/baton.png")));
            buttonBg.colorImage(new Color(25,25,25));
        }catch(Exception e){

        }
        isGameStarted = false;

        startButton = new JButton("Start", new ImageIcon(buttonBg.getImage()));

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

