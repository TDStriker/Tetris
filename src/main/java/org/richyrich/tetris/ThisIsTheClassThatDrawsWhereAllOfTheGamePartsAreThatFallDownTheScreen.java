package org.richyrich.tetris;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Class that updates and displays the game field
 */
public class ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen implements GameObject {
    // What Data do you need?
    // Hint:  Where is this thing?  How big is it?
    private int squareLength = 25;

    private int maxBoardWidth;
    private int maxBoardHeight;
    private int x;
    private int y;
    private int border = 4;
    private int heightOffset;
    private int[][] gameBoard = new int[Tetris.BOARD_HEIGHT][Tetris.BOARD_WIDTH];

    public ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen(int x, int y, int maxBoardWidth, int maxBoardHeight){
        this.maxBoardWidth = maxBoardWidth;
        this.maxBoardHeight = maxBoardHeight;
        this.squareLength = Math.min(((maxBoardWidth-(border*2))/10), ((maxBoardHeight-(border*2))/20));
        this.x = x;
        this.y = y;
        int actualBoardHeight = (squareLength * 20) + (2 * border);
        this.heightOffset = (maxBoardHeight - actualBoardHeight)/2;
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
        // You can do it via constructor, or a set of "setter" methods

        g.translate(border*2, heightOffset);
        g.setStroke(new BasicStroke (border));
        g.drawRect(x, y, ((squareLength*10) + 2 * border), ((squareLength*20)+ 2 * border));
        g.translate(border, border);
        // Draw a temporary grid of spaces where the blocks will go
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
//                g.drawRect(x + j*SQUARE_LENGTH, y+i*SQUARE_LENGTH, SQUARE_LENGTH, SQUARE_LENGTH);
                g.drawImage(Tetris.bimg, x + j*squareLength, y+i*squareLength, squareLength, squareLength, null, null);
            }
        }

        g.setTransform(old);
    }
}
