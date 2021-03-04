package org.richyrich.tetris;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisSettings {
    public static int SQUARE_LENGTH = 25;

    public static Canvas CANVAS;

    //Input Configuration
    public static int LEFT_KEY = KeyEvent.VK_LEFT;
    public static int RIGHT_KEY = KeyEvent.VK_RIGHT;
    public static int UP_KEY = KeyEvent.VK_UP;
    public static int DOWN_KEY = KeyEvent.VK_DOWN;

    public static int CW_ROT_KEY = KeyEvent.VK_E;
    public static int CCW_ROT_KEY = KeyEvent.VK_Q;

    public static void setCanvas(Canvas canvas){
        TetrisSettings.CANVAS = canvas;
    }

    public static void addKeyHandler(KeyListener handler){
        CANVAS.addKeyListener(handler);
    }
}
