package org.richyrich.tetris;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tetris extends JFrame {
    final static int BOARD_WIDTH = 10;
    final static int BOARD_HEIGHT = 20;

    BufferedImage bimg;

    final Dimension dim = new Dimension(1000, 600);
    final Canvas renderySpot;

    final KeyboardListener keyInput = new KeyboardListener();
    final SpinnyText brian = new SpinnyText(dim.height / 2, dim.width / 2, 1, 0, new Color((int) (Math.random() * 128), (int) (Math.random() * 128), (int) (Math.random() * 128)),
        new Font("ROG Fonts", (Font.ITALIC), 20), dim);

    ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen gameBoard;

    final Color backColor;

    private Tetris() {
        try {
            bimg = ImageIO.read(new File("src/main/res/jagger.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        renderySpot = new Canvas();
        renderySpot.setMinimumSize(dim);
        renderySpot.setMaximumSize(dim);
        renderySpot.setPreferredSize(dim);

        this.add(renderySpot);
        this.setResizable(false);
        this.pack();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(this::start);

        this.backColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    private void start() {
        // set the look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        renderySpot.setVisible(true);

        // don't allow AWT to paint the canvas since we are
        this.renderySpot.setIgnoreRepaint(true);
        // enable double buffering (the JFrame has to be
        // visible before this can be done)
        this.renderySpot.createBufferStrategy(2);
        this.renderySpot.requestFocus();

        // I am a pretty pretty princess.  Pleas someone write some code
        // Please. Thank you.
        this.renderySpot.addKeyListener(keyInput);


        //////////
        gameBoard = new ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen(10, 10, 100, 200);


        final Thread gameThread = new Thread(this::gameLoop);
        gameThread.setDaemon(true);
        gameThread.start();
    }

    private void gameLoop() {
        while (true) {
            long startTime = System.currentTimeMillis();

            updateGameState();
            renderGame();

            try {
                Thread.sleep(Math.max(0, 10 - (System.currentTimeMillis() - startTime)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGameState() {
        brian.update(10, keyInput.getInput());
        gameBoard.update(10);
    }

    private void renderGame() {
        final Graphics2D g = (Graphics2D) renderySpot.getBufferStrategy().getDrawGraphics();
        g.setColor(backColor);
        g.drawImage(bimg, 0, 0, dim.width, dim.height, null, null);

        brian.render(g);
        gameBoard.render(g);
        renderySpot.getBufferStrategy().show();
    }

    //region SpaceX
    public static void main(String[] args) {
        try {
            Tetris tets = new Tetris();
            tets.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //endregion
}
