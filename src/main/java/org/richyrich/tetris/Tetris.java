package org.richyrich.tetris;

import org.richyrich.tetris.utilities.KeyboardListener;
import org.richyrich.tetris.utilities.MouseClickListener;
import org.richyrich.tetris.utilities.TetrisSettings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tetris extends JFrame {

    private GameStates gameState;

    final static int BOARD_WIDTH = 10;
    final static int BOARD_HEIGHT = 20;

    public static BufferedImage bimg;
    public static BufferedImage baton;

    final Canvas renderySpot;


    final KeyboardListener keyInput = new KeyboardListener();
    final MouseClickListener mouseInput = new MouseClickListener();


    final MainMenu menu = new MainMenu(this);


    final SpinnyText brian = new SpinnyText(TetrisSettings.DIM.height / 2, TetrisSettings.DIM.width / 2, 5, 0, new Color((int) (Math.random() * 128), (int) (Math.random() * 128), (int) (Math.random() * 128)),
        new Font("ROG Fonts", (Font.ITALIC), 20), TetrisSettings.DIM);
    final SpinnyText gregory = new SpinnyText(TetrisSettings.DIM.height / 2, TetrisSettings.DIM.width / 2, 1, 0, new Color((int) (Math.random() * 128), (int) (Math.random() * 128), (int) (Math.random() * 128)),
        new Font("Curlz MT", (Font.ITALIC), 20), TetrisSettings.DIM);
    final SpinnyText jim = new SpinnyText(TetrisSettings.DIM.height / 2 + 10, TetrisSettings.DIM.width / 2 + 10, 0.5f, 0, new Color((int) (Math.random() * 128), (int) (Math.random() * 128), (int) (Math.random() * 128)),
        new Font("Comic Sans MS", (Font.ITALIC), 20), TetrisSettings.DIM);
    final SpinnyText phil = new SpinnyText(0, 0, -2, (float)Math.PI, new Color((int) (Math.random() * 128), (int) (Math.random() * 128), (int) (Math.random() * 128)),
        new Font("Verdana", (Font.ITALIC), 20), TetrisSettings.DIM);
    final SpinnyText roderick = new SpinnyText(0, 0, -2, (float)Math.PI, new Color((int) (Math.random() * 128), (int) (Math.random() * 128), (int) (Math.random() * 128)),
        new Font("Jazz LET", (Font.ITALIC), 20), TetrisSettings.DIM);

    final SpinnyText endgameText = new SpinnyText(TetrisSettings.DIM.height / 2, TetrisSettings.DIM.width / 2, 0, 0, new Color((int) (Math.random() * 128), (int) (Math.random() * 128), (int) (Math.random() * 128)),
        new Font("ROG Fonts", (Font.ITALIC), 20), TetrisSettings.DIM);

    final SpinnyText[] theBoyz = {brian, gregory, jim, phil, roderick};

    ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen gameBoard;

    final Color backColor;

    private Tetris() {
        try {
            bimg = ImageIO.read(new File("src/main/res/jagger.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       /**
         try {
            baton = ImageIO.read(new File("src/main/res/baton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        **/

        renderySpot = new Canvas();
        renderySpot.setMinimumSize(TetrisSettings.DIM);
        renderySpot.setMaximumSize(TetrisSettings.DIM);
        renderySpot.setPreferredSize(TetrisSettings.DIM);

        this.add(renderySpot);
        this.setResizable(false);
        this.pack();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(this::start);

        //this.backColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        this.backColor = Color.BLACK;
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
        this.renderySpot.addMouseListener(mouseInput);
        TetrisSettings.setCanvas(this.renderySpot);

        gameBoard = new ThisIsTheClassThatDrawsWhereAllOfTheGamePartsAreThatFallDownTheScreen(0, 0, TetrisSettings.DIM.width/2, TetrisSettings.DIM.height);

        gameState = GameStates.MAIN_MENU;

        final Thread gameThread = new Thread(this::runProgram);
        gameThread.setDaemon(true);
        gameThread.start();
    }

    private void runProgram(){
        while(true){
            switch (gameState){
                case MAIN_MENU:
                    runMenu();
                    break;

                case TETRAS:
                    gameBoard.start();
                    gameLoop();
                    break;

                case GAME_MODIFIERS:
                    //More cr*p
                    break;

                case SCOREBOARD:
                    // %*^#@! Caitlin
                    break;
                    //sh*te
                    //L*NGUAGE!!!!!!!!!!
                case SETTINGS:
                    //P** P**
                    break;

                default:
                    gameLoop();
                    break;
            }
        }
    }

    private void runMenu(){
        while(!false) {
            updateMenu();
            renderMenu();

            if(menu.isGameStarted()){
                System.out.println("Do the thing yo");
                gameState = GameStates.TETRAS;
                break;
            }
//            break;
        }
//        gameState = GameStates.TETRAS;
    }

    private void gameLoop() {
        while(true) {
            while (gameBoard.isGameRunning()) {
                long startTime = System.currentTimeMillis();

                updateGameState();
                renderGame();

                try {
                    Thread.sleep(Math.max(0, 10 - (System.currentTimeMillis() - startTime)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            endgameText.update(10, "You Lose");
            renderGame();
        }
    }

    private void updateMenu(){
        menu.update(10);
    }
   //!muy bien!
    private void renderMenu(){
        final Graphics2D g = (Graphics2D) renderySpot.getBufferStrategy().getDrawGraphics();
        g.setColor(backColor);
        g.drawImage(bimg, 0, 0, TetrisSettings.DIM.width, TetrisSettings.DIM.height, null, null);
//        g.fillRect(0,0, TetrisSettings.DIM.width, TetrisSettings.DIM.height);

        menu.render(g);

        renderySpot.getBufferStrategy().show();
    }

    private void updateGameState() {
//        brian.update(10, keyInput.getInput());
        gameBoard.update(10);

//        for(SpinnyText madlad : theBoyz){
//            madlad.update(10, keyInput.getInput());
//        }
    }

    private void renderGame() {
        final Graphics2D g = (Graphics2D) renderySpot.getBufferStrategy().getDrawGraphics();
        g.setColor(backColor);
        //g.drawImage(bimg, 0, 0, dim.width, dim.height, null, null);
        g.fillRect(0,0, TetrisSettings.DIM.width, TetrisSettings.DIM.height);

        g.setColor(new Color((int)(Math.random()*128) + 128,(int)(Math.random()*128) + 128,(int)(Math.random()*128) + 128));
        gameBoard.render(g);

        endgameText.render(g);

//        brian.render(g);
//        jim.render(g);
//        phil.render(g);
//        gregory.render(g);
//        roderick.render(g);

//        for(SpinnyText madlad : theBoyz){
//            madlad.render(g);
//        }

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
