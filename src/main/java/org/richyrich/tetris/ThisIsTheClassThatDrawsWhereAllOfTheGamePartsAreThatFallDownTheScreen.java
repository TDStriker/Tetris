package org.richyrich.tetris;

import org.richyrich.tetris.utilities.ResettableKeyHandler;
import org.richyrich.tetris.utilities.TetrisSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Class that updates and displays the game field
 */
//                                  W    A       G   P    A  T
public class ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen implements GameObject {
    /**
        T etrathingamagoddius
        H
     */


    private int maxBoardWidth;
    private int maxBoardHeight;
    private int x;
    private int y;
    private int border = 4;
    private int heightOffset;
    private boolean gameRunning;
    private Block[][] gameBoard = new Block[Tetris.BOARD_HEIGHT][Tetris.BOARD_WIDTH];
    private TetrisPiece currentPiece;
    CrystalCube fortuneTeller;
    GameHUD gameStats;

    private ResettableKeyHandler leftListener;
    private ResettableKeyHandler rightListener;
    private ResettableKeyHandler upListener;
    private ResettableKeyHandler downListener;
    private ResettableKeyHandler clockwiseListener;
    private ResettableKeyHandler counterClockwiseListener;


    /** The time in milliseconds that has passed since the last time we took action based on gravity */
    private int timeSinceGravity;
    private int gravityRefreshRate;

    public ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen(int x, int y, int maxBoardWidth, int maxBoardHeight, JFrame frame){
        this.gameRunning = true;
        this.maxBoardWidth = maxBoardWidth;
        this.maxBoardHeight = maxBoardHeight;
        TetrisSettings.SQUARE_LENGTH = Math.min(((maxBoardWidth-(border*2))/10), ((maxBoardHeight-(border*2))/20));
        this.x = x;
        this.y = y;
        int actualBoardHeight = (TetrisSettings.SQUARE_LENGTH * 20) + (2 * border);
        this.heightOffset = (maxBoardHeight - actualBoardHeight)/2;

        this.fortuneTeller = new CrystalCube(TetrisSettings.DIM.width/2, TetrisSettings.DIM.height - TetrisSettings.SQUARE_LENGTH*12, TetrisSettings.DIM.width/2, TetrisSettings.SQUARE_LENGTH*12);
        this.gameStats = new GameHUD(TetrisSettings.DIM.width/2,0, frame);

        this.leftListener = new ResettableKeyHandler(TetrisSettings.LEFT_KEY);
        this.rightListener = new ResettableKeyHandler(TetrisSettings.RIGHT_KEY);
        this.upListener = new ResettableKeyHandler(TetrisSettings.UP_KEY);
        this.downListener = new ResettableKeyHandler(TetrisSettings.DOWN_KEY);
        this.clockwiseListener = new ResettableKeyHandler(TetrisSettings.CW_ROT_KEY);
        this.counterClockwiseListener = new ResettableKeyHandler(TetrisSettings.CCW_ROT_KEY);

        TetrisSettings.addKeyHandler(leftListener);
        TetrisSettings.addKeyHandler(rightListener);
        TetrisSettings.addKeyHandler(upListener);
        TetrisSettings.addKeyHandler(downListener);
        TetrisSettings.addKeyHandler(clockwiseListener);
        TetrisSettings.addKeyHandler(counterClockwiseListener);

    }

    public void start(){
        this.gameRunning = true;

        Block[] blocks = new Block[]{new Block(Color.red, 0, 0), new Block(Color.red, 1, 0), new Block(Color.red, 0, 1), new Block(Color.red, 2, 0)};
        this.currentPiece = new TetrisPiece(blocks, 5, 0);

        gravityRefreshRate = 1000;
    }

    public void clearRows(){
        for(int row = 0; row < gameBoard.length; row++){
            for(int col = 0; col < gameBoard[0].length; col++){
                if(gameBoard[row][col] == null){
                    break;
                }
                if(col == gameBoard[0].length-1){
                    for(int i = row-1; i > 1; i--){
                        for(int j = 0; j < gameBoard[0].length; j++){
                            gameBoard[i+1][j] = gameBoard[i][j];
                        }
                    }
                    if(gravityRefreshRate > 250){
                        gravityRefreshRate -= 10;
                    }
                    gameStats.incrementScore(100);
                }
            }
        }
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    @Override
    public void update(int timePassed) {
        timeSinceGravity += timePassed;

        if(leftListener.checkAndReset()) {
            currentPiece.moveHorizontal(-1,gameBoard);
            /** System.out.println("Slide to the Left!"); **/
        }
        if(rightListener.checkAndReset()){
            currentPiece.moveHorizontal(1,gameBoard);
            /** System.out.println("Slide to the Right!"); **/
        }
        if(downListener.checkAndReset()){
            currentPiece.moveVertical(1,gameBoard);
            /** System.out.println("Everybody Clap Yo Hands!"); **/
        }
        if(clockwiseListener.checkAndReset()){
            currentPiece.rotateClockwise(gameBoard);
            /** System.out.println("Reverse Reverse!"); **/
        }
        if(counterClockwiseListener.checkAndReset()){
            currentPiece.rotateCounterClockwise(gameBoard);
            /** System.out.println("ChaCha Real Smooth!"); **/
        }

        if(timeSinceGravity >= gravityRefreshRate){
            if(currentPiece.moveVertical(1, gameBoard)){
                Block[] deadBlocks = currentPiece.getTranformBlocks();
                for(Block block : deadBlocks){
                    gameBoard[block.getY()][block.getX()] = block;
                }
                currentPiece = fortuneTeller.getUpcomingPiece();
                currentPiece.setPosition(5, 0);
                if(!currentPiece.positionValid(gameBoard)){
                    gameRunning = false;
                }
            }
            timeSinceGravity = 0;
        }

        clearRows();

        currentPiece.update(timePassed);
        fortuneTeller.update(timePassed);
        gameStats.update(timePassed);
    }

    @Override
    public void render(Graphics2D g) {
        AffineTransform old = g.getTransform();

        g.translate(border*2, heightOffset);
        g.setStroke(new BasicStroke (border));
        g.drawRect(x, y, ((TetrisSettings.SQUARE_LENGTH*10) + 2 * border), ((TetrisSettings.SQUARE_LENGTH*20)+ 2 * border));
        g.translate(border, border);

        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
                if(gameBoard[i][j] != null){
                    gameBoard[i][j].setPosition(j, i);
                    gameBoard[i][j].render(g);
                }
            }
        }

        currentPiece.render(g);

        g.setTransform(old);

        fortuneTeller.render(g);
        gameStats.render(g);
    }
}
