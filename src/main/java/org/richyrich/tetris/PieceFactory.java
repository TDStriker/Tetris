package org.richyrich.tetris;

import java.awt.Color;

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
              return stick();
        }
        return stick();
    }

    public TetrisPiece rhodeIsland() {
        Block[] bobby = new Block[4];
        bobby[0] = new Block(Color.yellow, 2, 0);
        bobby[1] = new Block(Color.yellow, 1, 0);
        bobby[2] = new Block(Color.yellow, 1, 1);
        bobby[3] = new Block(Color.yellow, 0, 1);
        return new TetrisPiece(bobby);
    }
    public TetrisPiece clevlandZ() {
        Block[] bobby = new Block[4];
        bobby[0] = new Block(Color.orange, 0, 0);
        bobby[1] = new Block(Color.orange, 1, 0);
        bobby[2] = new Block(Color.orange, 1, 1);
        bobby[3] = new Block(Color.orange, 2, 1);
        return new TetrisPiece(bobby);
    }
    public TetrisPiece cube() {
        Block[] bobby = new Block[4];
        bobby[0] = new Block(Color.green, 0, 0);
        bobby[1] = new Block(Color.green, 0, 1);
        bobby[2] = new Block(Color.green, 1, 0);
        bobby[3] = new Block(Color.green, 1, 1);
        TetrisPiece Robert = new TetrisPiece(bobby);
        Robert.setColorChanging(true);
        return Robert;
    }
    public TetrisPiece luigi() {
        Block[] bobby = new Block[4];
        bobby[0] = new Block(Color.green, 0, 0);
        bobby[1] = new Block(Color.green, 0, 1);
        bobby[2] = new Block(Color.green, 0, 2);
        bobby[3] = new Block(Color.green, 1, 2);
        return new TetrisPiece(bobby);
    }
    public TetrisPiece waluigi() {
        Block[] bobby = new Block[4];
        bobby[0] = new Block(new Color(170,0,255), 1, 0);
        bobby[1] = new Block(new Color(170,0,255), 1, 1);
        bobby[2] = new Block(new Color(170,0,255), 1, 2);
        bobby[3] = new Block(new Color(170,0,255), 0, 2);
        return new TetrisPiece(bobby);
    }
    public TetrisPiece triangleTryhard() {
        Block[] bobby = new Block[4];
        bobby[0] = new Block(Color.blue, 1, 0);
        bobby[1] = new Block(Color.blue, 0, 1);
        bobby[2] = new Block(Color.blue, 1, 1);
        bobby[3] = new Block(Color.blue, 2, 1);
        return new TetrisPiece(bobby);
    }
    public TetrisPiece stick() {
        Block[] bobby = new Block[4];
        bobby[0] = new Block(Color.red, 0, 0);
        bobby[1] = new Block(Color.red, 0, 1);
        bobby[2] = new Block(Color.red, 0, 2);
        bobby[3] = new Block(Color.red, 0, 3);
        return new TetrisPiece(bobby);
    }
}
