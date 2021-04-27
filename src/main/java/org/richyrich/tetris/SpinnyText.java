package org.richyrich.tetris;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class SpinnyText {
    String str = "";
    int strWidth;
    int y;
    int x;

    //  Units: Pixels per second
    int velocityX;
    int velocityY;

    float rotSpeed; //number of rotations/second
    float theta;

    Color color;
    Font font;
    Dimension dim;

    public SpinnyText(int y, int x, float rotSpeed, float theta, Color color, Font font, Dimension dim) {
        this.y = y;
        this.x = x;
        this.rotSpeed = rotSpeed;
        this.theta = theta;
        this.color = color;
        this.font = font;
        this.dim = dim;

        this.strWidth = 0;
        this.velocityX = 100;
        this.velocityY = 150;
    }

    public void setText(String str){
        this.str = str;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void update(int elapsedTimeMillis) {
        theta += (2 * Math.PI * rotSpeed) * (elapsedTimeMillis / 1000f);

        setColor(new Color((int)(Math.random()*128) + 128,(int)(Math.random()*128) + 128,(int)(Math.random()*128) + 128));
        // You aren't declaring a new parameter,  you need to pass it a r
        screenSaver(elapsedTimeMillis);
    }

    public void render(Graphics2D g){
        AffineTransform old = g.getTransform();

        g.setColor(color);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        strWidth = fontMetrics.stringWidth(str);
        g.translate(x,y);
        g.rotate(theta); //g.rotate rotates around 0,0
        g.drawString(str, 0 - (strWidth / 2), 0);

        g.setTransform(old);
    }

    private void screenSaver(int elapsedTimeMillis) {
        final double textExtentX = Math.abs(strWidth/2 * Math.cos(theta));
        final double textExtentY = Math.abs(strWidth/2 * Math.sin(theta));

        //Yo, someone please type something so that I can tell if this is working or not
        //Thank you,  that is more better,

        if((((x - textExtentX) <= 0) && (velocityX < 0)) || (((x + textExtentX) >= dim.width) && (velocityX > 0))){
            velocityX = -velocityX;
            rotSpeed = -rotSpeed * 1.5f;
        }

        if((((y - textExtentY) <= 0) && (velocityY < 0 )) || (((y + textExtentY) >= dim.height) && (velocityY > 0))){
            velocityY = -velocityY;
            rotSpeed = -rotSpeed * 1.5f;
        }

        x += (velocityX * (elapsedTimeMillis/1000f));
        y += (velocityY * (elapsedTimeMillis/1000f));
    }
}
