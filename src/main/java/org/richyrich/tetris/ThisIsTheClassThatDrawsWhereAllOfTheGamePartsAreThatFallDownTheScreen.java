package org.richyrich.tetris;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Class that updates and displays the game field
 */
public class ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen implements GameObject {
    // What Data do you need?
    // Hint:  Where is this thing?  How big is it?
//    private int squareLength = 25;
//
    private int maxBoardWidth;
    private int maxBoardHeight;
    private int x;
    private int y;
    private int border = 4;
    private int heightOffset;
    private Block[][] gameBoard = new Block[Tetris.BOARD_HEIGHT][Tetris.BOARD_WIDTH];
    private TetrisPiece currentPiece;

    private ResettableKeyHandler leftListener;
    private ResettableKeyHandler rightListener;
    private ResettableKeyHandler upListener;
    private ResettableKeyHandler downListener;

    public ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen(int x, int y, int maxBoardWidth, int maxBoardHeight){
        this.maxBoardWidth = maxBoardWidth;
        this.maxBoardHeight = maxBoardHeight;
        TetrisSettings.SQUARE_LENGTH = Math.min(((maxBoardWidth-(border*2))/10), ((maxBoardHeight-(border*2))/20));
        this.x = x;
        this.y = y;
        int actualBoardHeight = (TetrisSettings.SQUARE_LENGTH * 20) + (2 * border);
        this.heightOffset = (maxBoardHeight - actualBoardHeight)/2;

        Block[] blocks = new Block[]{new Block(Color.red, 0, 0), new Block(Color.red, 1, 0), new Block(Color.red, 0, 1), new Block(Color.red, 2, 0)};
        this.currentPiece = new TetrisPiece(blocks, 5, 5);

        this.leftListener = new ResettableKeyHandler(TetrisSettings.LEFT_KEY);
        this.rightListener = new ResettableKeyHandler(TetrisSettings.RIGHT_KEY);
        this.upListener = new ResettableKeyHandler(TetrisSettings.UP_KEY);
        this.downListener = new ResettableKeyHandler(TetrisSettings.DOWN_KEY);

        TetrisSettings.addKeyHandler(leftListener);
        TetrisSettings.addKeyHandler(rightListener);
        TetrisSettings.addKeyHandler(upListener);
        TetrisSettings.addKeyHandler(downListener);
    }

    @Override
    public void update(int timePassed) {
        if(leftListener.checkAndReset()) {
            currentPiece.moveHorizontal(-1);
            System.out.println("Slide to the Left!");
        }
        if(rightListener.checkAndReset()){
            currentPiece.moveHorizontal(1);
            System.out.println("Slide to the Right!");
        }
        if(upListener.checkAndReset()){
            currentPiece.moveVertical(-1);
            System.out.println("Criss-Cross!");
        }
        if(downListener.checkAndReset()){
            currentPiece.moveVertical(1);
            System.out.println("Everybody Clap yo Hands!");
        }

        currentPiece.update(timePassed);
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
        g.drawRect(x, y, ((TetrisSettings.SQUARE_LENGTH*10) + 2 * border), ((TetrisSettings.SQUARE_LENGTH*20)+ 2 * border));
        g.translate(border, border);
        // Draw a temporary grid of spaces where the blocks will go
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
//                g.drawRect(x + j*SQUARE_LENGTH, y+i*SQUARE_LENGTH, SQUARE_LENGTH, SQUARE_LENGTH);
//                g.drawImage(Tetris.bimg, x + j*squareLength, y+i*squareLength, squareLength, squareLength, null, null);
                if(gameBoard[i][j] != null){
                    gameBoard[i][j].setPosition(j, i);
                    gameBoard[i][j].render(g);
                }
            }
        }

        currentPiece.render(g);

        g.setTransform(old);
    }
}
