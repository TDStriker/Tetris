package org.richyrich.tetris;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class TetrisPiece implements GameObject {
    int x;
    int y;

    int width;
    int height;

    boolean colorChanging = false;

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

    public void setColorChanging(boolean colorChanging){
        this.colorChanging = colorChanging;
    }

    public Block[] getTranformBlocks(){
        Block[] transformBlocks = new Block[blocks.length];
        for(int i = 0; i < blocks.length; i++){
            transformBlocks[i] = blocks[i].clone();

            transformBlocks[i].setPosition(x+transformBlocks[i].getX(),y+transformBlocks[i].getY());
        }

        return transformBlocks;
    }

    /*
    *  Say goodbye to you for a special Power UP! #GAMERZ @BIG_CHUNGUS
    *  - not catalin (bc it was Caitlin all along)
    *  - except maybe
    *  - it was Jagger
    */
    public void moveHorizontal(int magnitude, Block[][] gameBoard){
        // Try to move
        x += magnitude;

        applyCollision(gameBoard, magnitude);

//        // Check our bounds
//        if(x < 0) {
//            // Naw bro, off the left
//            x = 0;
//        } else if(x + width >= Tetris.BOARD_WIDTH) {
//            // Naw bro, off the right.
//            x = Tetris.BOARD_WIDTH - width - 1;
//        }
    }

    public void moveVertical(int magnitude){
        y+=magnitude;
        return isBlockDead(gameBoard);
//        if(y < 0) {
//            y = 0;
//        } else if(y + height >= Tetris.BOARD_HEIGHT) {
//            y = Tetris.BOARD_HEIGHT - height - 1;
//        }
    }

    //       rotate potate -> Wombo Combo
    public void rotateClockwise(Block[][] gameBoard){
        Block[] test = blocks;

        boolean rotationValid = true;

        for (Block block : blocks) {
            rotationValid &= movementValid(gameBoard,x+block.getY(),y+2-block.getX());
        }

        if(rotationValid) {
            for (Block block : test) {
                int tempX = block.getX();
                block.setPosition(block.getY(), 2 - tempX);
            }
        }
//        if(movementValid(gameBoard, test)){
//            blocks = test;
//        }

//        Block[] prev = blocks;
//
//        for(Block block : blocks) {
//            int tempX = block.getX();
//            block.setPosition(block.getY(),2-tempX);
//        }
//        if(!movementValid(gameBoard)){
//            for(int i = 0; i < blocks.length; i++){
//                blocks[i].setPosition(prev[i].getX(),prev[i].getY());
//            }
//        }
    }

    public void rotateCounterClockwise(Block[][] gameBoard){
        Block[] prev = blocks;
        boolean rotationValid = true;

        for (Block block : blocks) {
            rotationValid &= movementValid(gameBoard,x+2-block.getY(),y+block.getX());
        }

        if(rotationValid) {
            for (Block block : blocks) {
                int tempX = block.getX();

                block.setPosition(2 - block.getY(), tempX);
            }
        }
//        if(!movementValid(gameBoard, blocks)){
//            for(int i = 0; i < blocks.length; i++){
//                blocks[i].setPosition(prev[i].getX(),prev[i].getY());
//            }
//        }
    }

    public void applyCollision(){
        for(Block block : blocks){
            if(x + block.getX() < 0){
                x += -(x + block.getX());
            } else if(x + block.getX() >= Tetris.BOARD_WIDTH){
                x -= (x + block.getX() - Tetris.BOARD_WIDTH + 1);
            }
            if(gameBoard[y+block.getY()][x+block.getX()] != null){
                x += -magnidude;
            }
            if(y + block.getY() < 0){
                y += -(y + block.getY());
            }
        }
    }

    public boolean movementValid(Block[][] gameBoard, int x, int y) {
        if (x < 0) {
            return false;
        } else if (x >= Tetris.BOARD_WIDTH) {
            return false;
        }
        if (gameBoard[y][x] != null) {
            return false;
        }
        if (y < 0) {
            return false;
        }
        return true;
    }

//    public boolean movementValid(Block[][] gameBoard, Block[] blooperyblap){
//        for(Block block : blooperyblap){
//            if(x + block.getX() < 0){
//                return false;
//            } else if(x + block.getX() >= Tetris.BOARD_WIDTH){
//                return false;
//            }
//            if(gameBoard[y+block.getY()][x+block.getX()] != null){
//                return false;
//            }
//            if(y + block.getY() < 0){
//                return false;
//            }
//        }
//        return true;
//
////        for(Block block : blocks){
////            if(x + block.getX() < 0){
////                return false;
////            } else if(x + block.getX() >= Tetris.BOARD_WIDTH){
////                return false;
////            }
////            if(gameBoard[y+block.getY()][x+block.getX()] != null){
////                return false;
////            }
////            if(y + block.getY() < 0){
////                return false;
////            }
////        }
////        return true;
//    }

    public boolean isBlockDead(){
        for(Block block : blocks){
            if(y + block.getY() >= Tetris.BOARD_HEIGHT){
                y -= (y + block.getY() - Tetris.BOARD_HEIGHT + 1);
                return true;
            }

            if(gameBoard[y+block.getY()][x+block.getX()] != null){
                y--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(int timePassed) {
        if(colorChanging){
            Color color = new Color((int)(Math.random()*128)+128,(int)(Math.random()*128)+128,(int)(Math.random()*128)+128);
            for(Block block : blocks){
                block.setColor(color);
            }
        }
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
