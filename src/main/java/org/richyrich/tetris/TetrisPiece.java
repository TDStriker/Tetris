package org.richyrich.tetris;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class TetrisPiece implements GameObject {
    int x;
    int y;

    Block[] blocks;

    public TetrisPiece(Block[] blocks){
        this.blocks = blocks;
    }

    public TetrisPiece(Block[] blocks, int x, int y){
        this.blocks = blocks;
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveHorizontal(int magnitude){
        x+=magnitude;
    }

    public void moveVertical(int magnitude){
        y+=magnitude;
    }


    @Override
    public void update(int timePassed) {

    }

    @Override
    public void render(Graphics2D g) {
        AffineTransform old = g.getTransform();

        g.translate(x*TetrisSettings.SQUARE_LENGTH, y*TetrisSettings.SQUARE_LENGTH);
        for(Block block : blocks){
            block.render(g);
        }

        g.setTransform(old);
    }
}
