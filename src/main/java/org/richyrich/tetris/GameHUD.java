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
        restartButton.setBounds(460, 150, 120, 80);
        restartButton.setActionCommand("Restart");
        restartButton.setBackground(Color.red);
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);
        restartButton.setVisible(false);
        frame.add(restartButton);

        homeButton.setHorizontalTextPosition(SwingConstants.CENTER);
        homeButton.setForeground(Color.white);
        homeButton.setFont(new Font("Comic Sans MS", (Font.BOLD), 16));
        //TODO: Get actual x & y val
        homeButton.setBounds(320, 150, 120, 80);
        homeButton.setActionCommand("Home");
        homeButton.setBackground(Color.red);
        homeButton.setFocusable(false);
        homeButton.addActionListener(this);
        homeButton.setVisible(false);
        frame.add(homeButton);
    }

    public void incrementScore(int val){
        score += val;
    }

    public void murderScore(){
        score = 0;
    }

    @Override
    public void update(int timePassed) {
        restartButton.setVisible(true);
        homeButton.setVisible(true);
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
        boolean restart = isRestarted;
        isRestarted = false;
        return restart;
    }

    public boolean isHomie(){
        boolean home = isHomie;
        isHomie = false;
        return home;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Restart".equals(e.getActionCommand())) {
            System.out.println("RESTARTED");
            isRestarted = true;
            homeButton.setVisible(false);
            restartButton.setVisible(false);
        }else if("Home".equals(e.getActionCommand())){
            System.out.println("HOMIE-O");
            isHomie = true;
            homeButton.setVisible(false);
            restartButton.setVisible(false);
        }
    }
//IMPORTANT LORE: BIG PURPLE L - Why pieces join together when the game ends

}
