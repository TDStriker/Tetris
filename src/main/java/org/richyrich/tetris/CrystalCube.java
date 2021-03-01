package org.richyrich.tetris;

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
    }

    @Override
    public void update(int timePassed) {
        // Chill yo,  we will do this later.
    }

    @Override
    public void render(Graphics2D g) {
        AffineTransform old = g.getTransform();

        g.translate(border*2,0);
        g.setStroke(new BasicStroke (border));
        g.drawRect(x, y, maxOracleWidth, maxOracleHeight);

        g.translate(border,border);


        g.setTransform(old);
    }
}
