package org.richyrich.tetris.utilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CustomImage{
    BufferedImage image;
    Color color;

    public CustomImage(BufferedImage image){
        this.image = image;
    }

    public CustomImage(BufferedImage image, Color color){
        this.image = image;
        this.color = color;

        colorImage(color);
    }

    public BufferedImage getImage(){
        return image;
    }

    public ImageIcon getImageIcon(){
        return new ImageIcon(image);
    }

    public void negate(){
      for (int col = 0; col < image.getWidth(); col++) {
          for (int row = 0; row < image.getHeight(); row++) {
              Color c = new Color(image.getRGB(col, row));
              int r = c.getRed();
              int g = c.getGreen();
              int b = c.getBlue();
              image.setRGB(col, row, new Color((255-r),(255-g),(255-b)).getRGB());
          }
      }
    }

    public void keepOnly(Color color){
        for (int col = 0; col < image.getWidth(); col++) {
            for (int row = 0; row < image.getHeight(); row++) {
                Color c = new Color(image.getRGB(col, row));
                int r = (color.getRed() > 122) ? c.getRed() : 0;
                int g = (color.getGreen() > 122) ? c.getGreen() : 0;
                int b = (color.getBlue() > 122) ? c.getBlue() : 0;

                image.setRGB(col, row, new Color(r,g,b).getRGB());
            }
        }
    }

    public void setImage(String path){
        try {
            image = (ImageIO.read(new File(path)));
        }catch(Exception e){

        }
    }

    public void colorImage(Color color){
        for (int col = 0; col < image.getWidth(); col++) {
            for (int row = 0; row < image.getHeight(); row++) {
                Color c = new Color(image.getRGB(col, row));

                int maxRGB = Math.max(Math.max(c.getRed(),c.getBlue()),c.getGreen());

                int r = (maxRGB*color.getRed())/255;
                int g = (maxRGB*color.getGreen())/255;
                int b = (maxRGB*color.getBlue())/255;

//                int r = (c.getRed() + (2 * color.getRed()))/3;
//                int g = (c.getGreen() + (2 * color.getRed()))/3;
//                int b = (c.getGreen() + (2 * color.getBlue()))/3;

                image.setRGB(col, row, new Color(r,g,b).getRGB());
            }
        }
    }
}
