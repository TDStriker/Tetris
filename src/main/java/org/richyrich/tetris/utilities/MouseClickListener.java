package org.richyrich.tetris.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickListener implements MouseListener {
    String origin;

    public String getClickOrigin(){
        return origin;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        origin = e.getComponent().getName();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        origin = e.getComponent().getName();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        origin = e.getComponent().getName();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
