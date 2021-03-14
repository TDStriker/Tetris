package org.richyrich.tetris;

import org.richyrich.tetris.utilities.TetrisSettings;

import java.awt.*;
import java.awt.geom.AffineTransform;
/**
 * Class that updates and displays the upcoming blocks
 */
public class CrystalCube implements GameObject { //The Crystal Cube //<----(The Crystal Cube Indicator) //Obviously //Don't give me that sass

    // Oracle = Crystal Cube    but is better fight me.
    private int maxOracleWidth;
    private int maxOracleHeight;
    private int x;
    private int y;
    private int border = 4;

    public CrystalCube(int x, int y, int maxOracleWidth, int maxOracleHeight){
        this.maxOracleWidth = maxOracleWidth - 4*border;
        this.maxOracleHeight = (int)(maxOracleHeight - 1.5*border);
        this.x = x;
        this.y = y;

        this.approachingPieces = new TetrisPiece[3];
        for(int i = 0; i < approachingPieces.length; i++){
            approachingPieces[i] = PieceFactory.DEFAULT.generatePiece();
        }
    }

    public TetrisPiece getUpcomingPiece(){
        TetrisPiece upcoming = approachingPieces[0];

        for(int i = 0; i < approachingPieces.length - 1; i++){
            approachingPieces[i] = approachingPieces[i+1];
        }
        approachingPieces[approachingPieces.length-1] = PieceFactory.DEFAULT.generatePiece();

        return upcoming;
    }

    @Override
    public void update(int timePassed) {
        // Chill yo,  we will do this later.
        for(TetrisPiece banana : approachingPieces){
            banana.update(timePassed);
        }
    }

    @Override
    public void render(Graphics2D g) {
        AffineTransform old = g.getTransform();

        g.translate(border*2,0);
        g.setStroke(new BasicStroke (border));
        g.translate(x,y);
        g.drawRect(0, 0, maxOracleWidth, maxOracleHeight);

        g.translate(border + TetrisSettings.SQUARE_LENGTH,border);

        for(TetrisPiece spectorReflector : approachingPieces){
            spectorReflector.render(g);
            g.translate(0,TetrisSettings.SQUARE_LENGTH * 4);
        }


        g.setTransform(old);
    }
}
