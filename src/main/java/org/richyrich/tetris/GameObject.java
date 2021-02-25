package org.richyrich.tetris;

import java.awt.*;

/**
 * The basic object that can participate in the game.
 */
public interface GameObject {
    /**
     * Gives each object the chance to update its state based on how much time has passed
     * @param timePassed how much time has passed in milliseconds
     */
    void update(int timePassed);

    /**
     * Uses the current state of the object to render an image to the screen
     * @param g a Graphics2D object that allows the object to render to the screen
     */
    void render(Graphics2D g);
}
