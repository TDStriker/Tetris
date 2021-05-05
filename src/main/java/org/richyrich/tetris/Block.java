package org.richyrich.tetris;

import org.richyrich.tetris.utilities.CustomColor;
import org.richyrich.tetris.utilities.CustomImage;
import org.richyrich.tetris.utilities.TetrisSettings;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static org.richyrich.tetris.Tetris.jagger;

public class Block implements GameObject{
    int x;
    int y;

    Color color;
    CustomImage image;

    public Block(Color color){
        this.color = color;
    }

    public Block(Color color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;

        this.image = null;
    }

    public Block(Color color, CustomImage image, int x, int y){
        this.color = color;
        this.image = image;
        this.x = x;
        this.y = y;

        image.colorImage(color);
    }

    public Block clone(){
        return new Block(color, image, x, y);
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setImage(CustomImage image){
        this.image = image;
        image.colorImage(color);
    }

    public void resetImage(){
        image.setImage(TetrisSettings.blockImagePath);
    }

    public void setColor(Color color){
        this.color = color;
        if(image!=null){
            image.colorImage(color);
        }
    }

    public Color getColor(){
        return color;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public void update(int timePassed) {

    }

    @Override
    public void render(Graphics2D g) {
        if(image != null) {
            AffineTransform old = g.getTransform();
            g.translate(x*TetrisSettings.SQUARE_LENGTH, y*TetrisSettings.SQUARE_LENGTH);
            g.drawImage(image.getImage(), x, y, TetrisSettings.SQUARE_LENGTH, TetrisSettings.SQUARE_LENGTH, null, null);
            g.setTransform(old);
        }else {
            g.setColor(color);
            g.fillRect(x * TetrisSettings.SQUARE_LENGTH, y * TetrisSettings.SQUARE_LENGTH, TetrisSettings.SQUARE_LENGTH, TetrisSettings.SQUARE_LENGTH);
        }
    }
}
