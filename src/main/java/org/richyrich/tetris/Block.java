package org.richyrich.tetris;

import java.awt.*;

public class Block implements GameObject{
    int x;
    int y;
//    int squareLength;
    Color color;

    public Block(Color color){
        this.color = color;
    }

    public Block(Color color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(int timePassed) {

    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x * TetrisSettings.SQUARE_LENGTH,y * TetrisSettings.SQUARE_LENGTH,TetrisSettings.SQUARE_LENGTH,TetrisSettings.SQUARE_LENGTH);
    }
}
