package org.richyrich.tetris;

import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {
    final static int BOARD_WIDTH = 10;
    final static int BOARD_HEIGHT = 20;

    final Dimension dim = new Dimension(1000, 600);
    final Canvas renderySpot;

    final KeyboardListener keyInput = new KeyboardListener();
    final SpinnyText brian = new SpinnyText(dim.height/2, dim.width/2, 10, 0, new Color((int)(Math.random()*128),(int)(Math.random()*128),(int)(Math.random()*128)),
        new Font("Verdana", (Font.ITALIC), 20));
    //Brian Fact! Brian is the Brian of the operation. Respect him.

//    float theta = 0;
//    String str;

    final Color backColor;

    private Tetris() {
        renderySpot = new Canvas();


        renderySpot.setMinimumSize(dim);
        renderySpot.setMaximumSize(dim);
        renderySpot.setPreferredSize(dim);

        this.add(renderySpot);
        this.setResizable(false);
        this.pack();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(this::start);

        this.backColor = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
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
        final Thread gameThread = new Thread(this::gameLoop);
        gameThread.setDaemon(true);
        gameThread.start();
    }

    private void gameLoop() {
        while(true) {
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

    private void updateGameState(){
//        theta += (Math.PI / 50);/
//        str = keyInput.getInput();
          brian.update(10,keyInput.getInput(),dim);
    }

    private void renderGame() {
        final Graphics2D g = (Graphics2D)renderySpot.getBufferStrategy().getDrawGraphics();
        g.setColor(backColor);
        g.fillRect(0,0,dim.width,dim.height);

        brian.render(g);
        renderySpot.getBufferStrategy().show();
    }

    //region SpaceX
    public static void main(String[] args) {
//        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//        for(String font: fonts) {
//            System.out.printf("This is font %s %n", font);
//        }

        try {
            Tetris tets = new Tetris();
            tets.setVisible(true);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    //endregion

    //region Sandwiches
    /*
    private static void doGameStuff() {
        // Imagine this take 102ms
        long startTime = System.currentTimeMillis();

        playerAction();
        gameRefresh();
        //Board
        display();

        thread.sleep(Math.max(0, 100 - (System.currentTimeMillis() - startTime)));
    }

    private static void gameRefresh(){
        applyGravity();
        clearRows();
    }

    private static void applyGravity(){
        killCurrentBlock();
        spawnBlock();
    }

    public static void killCurrentBlock(){
        // When converting current piece to Dead Blocks, check to see if any blocks are out of bounds
        // Traverse through current piece (matrix) and add the blocks to the game board
        checkGameLose();
    }

    public static void checkGameLose(){
        //check to see if any current blocks are out of bounds
    }*/
    //endregion
}
