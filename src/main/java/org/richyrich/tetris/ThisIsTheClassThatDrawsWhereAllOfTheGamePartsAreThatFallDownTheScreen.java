package org.richyrich.tetris;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen implements GameObject {
    // What Data do you need?
    // Hint:  Where is this thing?  How big is it?
    private static int SQUARE_LENGTH = 25;

    private int boardWidth;
    private int boardHeight;
    private int x;
    private int y;

    private int[][] gameBoard = new int[Tetris.BOARD_HEIGHT][Tetris.BOARD_WIDTH];

    public ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen(int x, int y, int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(int timePassed) {
        // Chill yo,  we will do this later.
    }

    @Override
    public void render(Graphics2D g) {
        AffineTransform old = g.getTransform();
        // Draw the rectangle for the board
        // Use the documentation to figure out what you need.
        //do we know the dimensions of our board yet,  No.  You will need to pass it in from somewhere
        // You can do it via constructor, or a set of "setter" methods.
        g.drawRect(x, y, boardWidth, boardHeight);

        // Draw a temporary grid of spaces where the blocks will go
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
//                g.drawRect(x + j*SQUARE_LENGTH, y+i*SQUARE_LENGTH, SQUARE_LENGTH, SQUARE_LENGTH);
                g.drawImage(Tetris.bimg, x + j*SQUARE_LENGTH, y+i*SQUARE_LENGTH, SQUARE_LENGTH, SQUARE_LENGTH, null, null);
            }
        }

        g.setTransform(old);
    }
}
