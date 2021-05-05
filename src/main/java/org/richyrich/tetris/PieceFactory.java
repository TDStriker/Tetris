package org.richyrich.tetris;

import org.richyrich.tetris.utilities.CustomColor;
import org.richyrich.tetris.utilities.CustomImage;
import org.richyrich.tetris.utilities.TetrisSettings;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;

public class PieceFactory {
    public static final PieceFactory DEFAULT = new PieceFactory();

    public TetrisPiece generatePiece(){
      int random = (int)(Math.random() * 7);
      switch(random) {
          case 0:
              return rhodeIsland();

          case 1:
              return clevlandZ();

          case 2:
              return cube();

          case 3:
              return luigi();

          case 4:
              return waluigi();

          case 5:
              return triangleTryhard();

          case 6:
              return holyEye();
        }
        return holyEye();
    }

    public TetrisPiece rhodeIsland() {
        Block[] bobby = new Block[4];
        try{
            bobby[0] = new Block(Color.yellow, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 2, 0);
            bobby[1] = new Block(Color.yellow, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 0);
            bobby[2] = new Block(Color.yellow, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 1);
            bobby[3] = new Block(Color.yellow, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 1);
        }catch(Exception e){

        }
        return new TetrisPiece(bobby);
    }
    public TetrisPiece clevlandZ() {
        Block[] bobby = new Block[4];
        try{
            bobby[0] = new Block(Color.orange, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 0);
            bobby[1] = new Block(Color.orange, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 0);
            bobby[2] = new Block(Color.orange, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 1);
            bobby[3] = new Block(Color.orange, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 2, 1);
        }catch(Exception e){

        }
        return new TetrisPiece(bobby);
    }
    public TetrisPiece cube() {
        Block[] bobby = new Block[4];
        try {
        bobby[0] = new Block(Color.green, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 0);
        bobby[1] = new Block(Color.green, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 1);
        bobby[2] = new Block(Color.green, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 0);
        bobby[3] = new Block(Color.green, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 1);
    } catch (Exception e){

        }
        TetrisPiece Robert = new TetrisPiece(bobby);
        Robert.setColorChanging(true);
        return Robert;
    }
    public TetrisPiece luigi() {
        Block[] bobby = new Block[4];
        try{
            bobby[0] = new Block(Color.green, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 0);
            bobby[1] = new Block(Color.green, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 1);
            bobby[2] = new Block(Color.green, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 2);
            bobby[3] = new Block(Color.green, new CustomImage (ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 2);
        } catch(Exception e) {

        }
        return new TetrisPiece(bobby);
    }
    public TetrisPiece waluigi() {
        Block[] bobby = new Block[4];
        try {
            bobby[0] = new Block(new Color(170, 0, 255), new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 0);
            bobby[1] = new Block(new Color(170, 0, 255), new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 1);
            bobby[2] = new Block(new Color(170, 0, 255), new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 2);
            bobby[3] = new Block(new Color(170, 0, 255), new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 2);
        } catch(Exception e) {

        }
        return new TetrisPiece(bobby);
    }
    public TetrisPiece triangleTryhard() {
        Block[] bobby = new Block[4];
        try {
            bobby[0] = new Block(Color.blue, new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 0);
            bobby[1] = new Block(Color.blue, new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 1);
            bobby[2] = new Block(Color.blue, new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 1, 1);
            bobby[3] = new Block(Color.blue, new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 2, 1);
        } catch (Exception e) {

        }
        return new TetrisPiece(bobby);
    }
    public TetrisPiece holyEye() {
        Block[] bobby = new Block[4];
        try {
            bobby[0] = new Block(new CustomColor(255, 0, 0), new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 0);
            bobby[1] = new Block(new CustomColor(255, 0, 0), new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 1);
            bobby[2] = new Block(new CustomColor(255, 0, 0), new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 2);
            bobby[3] = new Block(new CustomColor(255, 0, 0), new CustomImage(ImageIO.read(new File(TetrisSettings.blockImagePath))), 0, 3);
        }catch(Exception e){

        }
        TetrisPiece Robert = new TetrisPiece(bobby);
        Robert.setGradient(true);
        return Robert;
    }
}
