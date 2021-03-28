package org.richyrich.tetris.utilities;

import java.awt.*;

public class CustomColor extends Color {
    Color color;
    int rgbIndex = 0;

    public CustomColor(int r, int g, int b) {
        super(r,g,b);
        color = new Color(r,g,b);
    }

    public void setRandom(){
        color = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    }

    public void applyGradient(){
        int[] rgb = {color.getRed(),color.getGreen(),color.getBlue()};

        if(rgb[(rgbIndex+1 > 2 ? 0 : rgbIndex+1)] < 255){
            rgb[(rgbIndex+1 > 2 ? 0 : rgbIndex+1)]++;
        }else{
            if(rgb[rgbIndex] > 0){
                rgb[rgbIndex]--;
            }else{
                rgbIndex = (rgbIndex+1 > 2 ? 0 : rgbIndex+1);
            }
        }
    }
}
