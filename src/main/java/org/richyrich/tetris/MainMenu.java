package org.richyrich.tetris;

import org.richyrich.tetris.utilities.TetrisSettings;

import java.awt.*;

public class MainMenu implements GameObject{
    Button startGame;

    public MainMenu(){
        startGame = new Button("Start Game");

        startGame.setLocation(TetrisSettings.DIM.width/2,TetrisSettings.DIM.height/2);
        startGame.setSize(100,100);
    }

    @Override
    public void update(int timePassed) {

    }

    @Override
    public void render(Graphics2D g) {
        startGame.paint(g);
        startGame.setVisible(true);
    }
}
