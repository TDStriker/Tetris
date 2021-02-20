package org.richyrich.tetris;

import java.awt.*;

public class SpinnyText {
    String str;
    int y;
    int x;
    float rotSpeed; //number of rotations/second
    float theta;

    Color color;
    Font font;

    public SpinnyText(int y, int x, float rotSpeed, float theta, Color color, Font font) {
        this.y = y;
        this.x = x;
        this.rotSpeed = rotSpeed;
        this.theta = theta;
        this.color = color;
        this.font = font;
    }

    public void update(int elapsedTimeMillis, String str) {
        theta += (2 * Math.PI * rotSpeed) * (elapsedTimeMillis / 1000f);
        this.str = str;
    }

    public void render(Graphics2D g){
        g.setColor(color);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        g.translate(x,y);
        g.rotate(theta); //g.rotate rotates around 0,0
        g.drawString(str, 0 - (fontMetrics.stringWidth(str) / 2), 0);
    }
}
