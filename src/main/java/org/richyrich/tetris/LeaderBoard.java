package org.richyrich.tetris;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class LeaderBoard {
    File leaderboard = new File("src/main/files/leaderboard.txt");
    String[] highScores;

    FileWriter printingPress;

    public LeaderBoard() {
        highScores = new String[10];
        try {
            Scanner fileReader = new Scanner(leaderboard);
            for(int i = 0; i < highScores.length; i++){
                if(fileReader.hasNext()){
                    highScores[i] = fileReader.next();
                }else{
                    highScores[i] = "";
                }
            }
        }catch(Exception e){

        }
    }

    //TODO: I miss the rains down in Africa
    /** Consider checking from lowest score first. */
    public void updateHighScore(int score, String name){
        for (int i = 0; i < highScores.length; i++){
            if(score > Integer.parseInt(highScores[i].substring(highScores[i].indexOf(":")+1))){
                String prev = highScores[i];
                highScores[i] = name + ": " + score;
                for(int j = i; j < highScores.length-1; j++){
                    String temp = highScores[j+1];
                    highScores[j+1] = prev;
                    prev = temp;
                }
                updateFile();
                break;
            }
        }
    }

    public boolean isHighScore(int score) {
        return score>Integer.parseInt(highScores[highScores.length-1].substring(highScores[highScores.length-1].indexOf(":")+1));
    }

    private void updateFile(){
        try {
            printingPress = new FileWriter(leaderboard);
            for(String highScore : highScores) {
                printingPress.write(highScore + System.getProperty("line.separator"));
            }
        } catch (Exception e){

        }
        ArrayList<String> scores = new ArrayList<String>();
        for(int i = 0; i < highScores.length; i++){
            scores.set(i,highScores[i]);
        }

        try {
            Files.write(leaderboard.toPath(), scores);
        }catch(Exception e){

        }
    }
}
