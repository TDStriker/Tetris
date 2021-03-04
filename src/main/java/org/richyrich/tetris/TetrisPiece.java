package org.richyrich.tetris;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class TetrisPiece implements GameObject {
    int x;
    int y;

    int width;
    int height;

    Block[] blocks;

    public TetrisPiece(Block[] blocks){
        this.blocks = blocks;
    }

    public TetrisPiece(Block[] blocks, int x, int y){
        this.blocks = blocks;
        this.x = x;
        this.y = y;

        this.width = 0;
        this.height = 0;
        for(Block block : blocks){
            width = Math.max(block.getX(),width);
            height = Math.max(block.getY(),height);
        }
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveHorizontal(int magnitude){
        // Try to move
        x += magnitude;

        // Check our bounds
        if(x < 0) {
            // Naw bro, off the left
            x = 0;
        } else if(x + width >= Tetris.BOARD_WIDTH) {
            // Naw bro, off the right.
            x = Tetris.BOARD_WIDTH - width - 1;
        }
    }

    public void moveVertical(int magnitude){
        y+=magnitude;
        if(y < 0) {
            y = 0;
        } else if(y + height >= Tetris.BOARD_HEIGHT) {
            y = Tetris.BOARD_HEIGHT - height - 1;
        }
    }

    //       rotate potate -> Wombo Combo
    public void rotateClockwise(){
        for(Block block : blocks) {
            int tempX = block.getX();
            block.setPosition(block.getY(),2-tempX);
        }

        int tempWidth = width;
        width = height;
        height = tempWidth;
    }

    public void rotateCounterClockwise(){
        for(Block block : blocks){
            int tempX = block.getX();
            block.setPosition(2-block.getY(), tempX);
        }

        int tempWidth = width;
        width = height;
        height = tempWidth;
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
