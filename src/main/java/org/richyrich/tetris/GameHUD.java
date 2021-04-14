package org.richyrich.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

public class GameHUD implements GameObject, ActionListener {
    private int x;
    private int y;

    private boolean isRestarted;
    private boolean isHomie;

    JButton restartButton;
    JButton homeButton;

    ImageIcon buttonBackground;

    private int score;

    public GameHUD(int x, int y, JFrame frame){
        this.x = x;
        this.y = y;

        this.isRestarted = false;
        this.isHomie = false;

        buttonBackground = new ImageIcon("src/main/res/baton.png");

        this.score = 0;

        restartButton = new JButton("Restart", buttonBackground);
        homeButton = new JButton("Home", buttonBackground);

        restartButton.setHorizontalTextPosition(SwingConstants.CENTER);
        restartButton.setForeground(Color.white);
        restartButton.setFont(new Font("Comic Sans MS", (Font.BOLD), 16));
        //TODO: Get actual x & y vals
        restartButton.setBounds(100, 100, 100, 100);
        restartButton.setActionCommand("Restart");
        restartButton.setBackground(Color.yellow);
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);
        frame.add(restartButton);

        homeButton.setHorizontalTextPosition(SwingConstants.CENTER);
        homeButton.setForeground(Color.white);
        homeButton.setFont(new Font("Comic Sans MS", (Font.BOLD), 16));
        //TODO: Get actual x & y val
        homeButton.setBounds(150, 200, 100, 100);
        homeButton.setActionCommand("Home");
        homeButton.setBackground(Color.cyan);
        homeButton.setFocusable(false);
        homeButton.addActionListener(this);
        frame.add(homeButton);
    }

    public void incrementScore(int val){
        score += val;
    }

    @Override
    public void update(int timePassed) {

    }

    @Override
    public void render(Graphics2D g) {
        AffineTransform old = g.getTransform();

        g.translate(x,y);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", (Font.BOLD), 16));
        g.drawString("Score: " + String.valueOf(score), 15, 25);

        g.setTransform(old);
    }

    public boolean isRestarted(){
        return isRestarted;
    }

    public boolean isHomie(){
        return isHomie;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Restart".equals(e.getActionCommand())) {
            System.out.println("RESTARTED");
            isRestarted = true;
            restartButton.setVisible(false);
        }else if("Home".equals(e.getActionCommand())){
            System.out.println("HOMIE-O");
            isHomie = true;
            homeButton.setVisible(false);
        }
    }
//IMPORTANT LORE: BIG PURPLE L - Why pieces join together when the game ends

}
