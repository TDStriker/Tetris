package org.richyrich.tetris;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    Clip clip;

    public Sound(String path){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void playSound() {
        clip.start();
    }

    public void resetSound() {
        clip.setFramePosition(0);
    }

    public void stopSound(){
        clip.stop();
    }

    public void loopSound(){
        loopSound(Clip.LOOP_CONTINUOUSLY);
    }

    public void loopSound(int loopNum){
        clip.loop(loopNum);
    }
}
