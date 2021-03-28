package org.richyrich.tetris.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionImplementer implements ActionListener {
    String actionCommand;

    public String getActionCommand(){
        return actionCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actionCommand = e.getActionCommand();
    }
}
