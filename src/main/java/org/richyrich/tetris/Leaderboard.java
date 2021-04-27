package org.richyrich.tetris;

import java.io.File;
import java.util.Scanner;

public class Leaderboard {
    File leaderboard = new File("src/main/files/leaderboard.txt");
    String[] highScores;

    public Leaderboard() {
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

}
